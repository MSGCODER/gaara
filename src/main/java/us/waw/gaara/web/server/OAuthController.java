package us.waw.gaara.web.server;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.request.OAuthRequest;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import us.waw.gaara.common.Response;
import us.waw.gaara.common.Response.Status;
import us.waw.gaara.common.ResponseWithData;
import us.waw.gaara.service.AccountService;
import us.waw.gaara.service.OAuthService;
import us.waw.gaara.util.OAuthUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenn on 16/9/20.
 */
@Controller
@RequestMapping(value = "/oauth2")
public class OAuthController {
    @Autowired
    private OAuthService oAuthService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/authorize")
    // @ResponseBody
    public ModelAndView oauth(HttpServletRequest request) throws OAuthProblemException, OAuthSystemException {
        ModelAndView mv = new ModelAndView();
        // 构建OAuth请求
        OAuthAuthzRequest oAuthAuthzRequest = new OAuthAuthzRequest(request);

        // 校验客户端Id
        if(!oAuthService.isValidClientId(oAuthAuthzRequest.getClientId())){
            return new ModelAndView("error", "errorMsg", "非法的client id.");
        }

        String responseType = oAuthAuthzRequest.getParam("response_type");
        /**
         * 客户端授权模式
         * 1. 授权码模式: responseType = code
         * 2. 简化模式
         * 3. 密码模式
         * 4. 客户端模式
         */
        if(responseType.equals("code")){
            // 请求的action
            String action = oAuthAuthzRequest.getParam("action");
            if(action != null && action.equals("login")){
                String username = oAuthAuthzRequest.getParam("username");
                String password = oAuthAuthzRequest.getParam("password");

                if(accountService.isValidAccount(username, password)){
                    // 生成授权码
                    OAuthIssuer oAuthIssuer = new OAuthIssuerImpl(new MD5Generator());
                    String authCode = oAuthIssuer.authorizationCode();
                    String redirectUrl = oAuthAuthzRequest.getParam("redirect_url");
                    return new ModelAndView("redirect:" + redirectUrl + "?code=" + authCode);
                }else {
                    return new ModelAndView("error", "errorMsg", "用户名或密码不正确.");
                }

            }else {
                mv.setViewName("auth_login");
                mv.addAllObjects(OAuthUtils.getOauthModel(oAuthAuthzRequest));
            }
        }

        return mv;
    }

    /**
     * 根据授权码获取access_token
     * @param request
     * @return
     * @throws OAuthProblemException
     * @throws OAuthSystemException
     *
     * example : curl -d "client_id=123456&client_secret=abcdefg&grant_type=authorization_code&code=secret&redirect_uri=xxx" http://localhost:8080/oauth2/access_token
     */
    @RequestMapping(value = "/access_token")
    @ResponseBody
    public Response accessToken(HttpServletRequest request) throws OAuthProblemException, OAuthSystemException {
        ResponseWithData response = new ResponseWithData();

        OAuthTokenRequest oAuthTokenRequest = new OAuthTokenRequest(request);

        //1. 校验客户端Id是否正确
        if(!oAuthService.isValidClientId(oAuthTokenRequest.getClientId())){
            // return new ModelAndView("error", "errorMsg", "非法的client id.");
            return new Response(Status.CODE_INVALID_CLIENT_ID, Status.MSG_INVALID_CLIENT_ID);
        }

        //2. 校验客户端secret key是否正确
        if(!oAuthService.isValidClientSecretKey(oAuthTokenRequest.getClientSecret())){
            return new Response(Status.CODE_INVALID_CLIENT_SECRET_KEY, Status.MSG_INVALID_CLIENT_SECRET_KEY);
        }

        //3. 校验AUTHORIZATION_CODE
        String authCode = oAuthTokenRequest.getParam(OAuth.OAUTH_CODE);
        if(!oAuthService.isValidAuthCode(authCode)){
            return new Response(Status.CODE_INVALID_AUTH_CODE, Status.MSG_INVALID_AUTH_CODE);
        }

        // 生成access_token
        OAuthIssuer oAuthIssuer = new OAuthIssuerImpl(new MD5Generator());
        String accessToken = oAuthIssuer.accessToken();

        response.putData("access_token", accessToken);
        // access_token的生命周期,单位是秒
        response.putData("expires_in", 3600);

        return response;
    }

}

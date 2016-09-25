package waw.gaara.web.server;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.request.OAuthRequest;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import waw.gaara.service.AccountService;
import waw.gaara.service.OAuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenn on 16/9/20.
 */
@Controller
@RequestMapping(value = "/oauth2")
public class OAuthServer {
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
            return new ModelAndView("error", "errorMsg", "非法的client id");
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

                }else {
                    
                }

            }else {
                mv.setViewName("auth_login");
            }
        }

        return mv;
    }

}

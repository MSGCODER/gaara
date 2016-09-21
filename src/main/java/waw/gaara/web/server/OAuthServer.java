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

    @RequestMapping(value = "/authorize")
    //    @ResponseBody
    public ModelAndView oauth(HttpServletRequest request) throws OAuthProblemException, OAuthSystemException {
        ModelAndView mv = new ModelAndView();
        // 构建OAuth请求
        OAuthAuthzRequest oAuthAuthzRequest = new OAuthAuthzRequest(request);

        // 校验客户端Id
        if(!oAuthService.isValidClientId(oAuthAuthzRequest.getClientId())){
        //            OAuthResponse oAuthResponse = OAuthResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
        //                    .setError(OAuthError.TokenResponse.INVALID_CLIENT)
        //                    .setErrorDescription("非法的client id")
        //                    .buildBodyMessage();

            return new ModelAndView("error", "errorMsg", "非法的client id");
        }

        mv.setViewName("user_authenticate");
        return mv;
    }

}

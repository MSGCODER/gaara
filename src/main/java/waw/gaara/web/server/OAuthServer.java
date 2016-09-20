package waw.gaara.web.server;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.request.OAuthRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import waw.gaara.service.OAuthService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenn on 16/9/20.
 */
@Controller
@RequestMapping(value = "/server")
public class OAuthServer {
    @Autowired
    private OAuthService oAuthService;

    @RequestMapping(value = "/authorize")
    //    @ResponseBody
    public String oauth(HttpServletRequest request) throws OAuthProblemException, OAuthSystemException {
        // 构建OAuth请求
        OAuthAuthzRequest oAuthAuthzRequest = new OAuthAuthzRequest(request);

        // 校验客户端Id
        if(!oAuthService.isValidClientId(oAuthAuthzRequest.getClientId())){
            return "user_authenticate";
        }



        return "user_authenticate";
    }

}

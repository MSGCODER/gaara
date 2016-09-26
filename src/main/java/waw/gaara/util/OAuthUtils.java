package waw.gaara.util;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by lenn on 16/9/25.
 */
public class OAuthUtils {
    /**
     * 封装OAuth的请求参数值
     * @param oAuthAuthzRequest
     * @return
     */
    public static Map<String, String> getOauthModel(OAuthAuthzRequest oAuthAuthzRequest){
        Map<String, String> model = new HashMap<String, String>();
        String[] items = new String[]{"scope", "client_id", "redirect_url", "state"};
        for(String item : items){
            putItemInMap(oAuthAuthzRequest, model, item);
        }
        return model;
    }

    /**
     * 根据参数名提取参数值到map中
     * @param oAuthAuthzRequest
     * @param map
     * @param name
     */
    private static void putItemInMap(OAuthAuthzRequest oAuthAuthzRequest, Map<String, String> map, String name){
        String value = oAuthAuthzRequest.getParam(name);
        if(!StringUtils.isEmpty(value)){
            map.put(name, value);
        }
    }
}

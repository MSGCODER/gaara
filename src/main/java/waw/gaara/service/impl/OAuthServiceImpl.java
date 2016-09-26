package waw.gaara.service.impl;

import org.springframework.stereotype.Service;
import waw.gaara.service.OAuthService;

/**
 * Created by lenn on 16/9/20.
 */
@Service
public class OAuthServiceImpl implements OAuthService {

    @Override
    public Boolean isValidClientId(String clientId) {
        // TODO 虚假的逻辑
        if(clientId.equals("123456")){
            return true;
        }

        return false;
    }

    @Override
    public Boolean isValidClientSecretKey(String clientSecretKey) {
        // todo 虚假的逻辑
        if(clientSecretKey.equals("abcdefg")){
            return true;
        }
        return false;
    }

    @Override
    public Boolean isValidAuthCode(String authCode) {
        // todo 虚假的逻辑
        if(authCode.equals("secret")){
            return true;
        }

        return false;
    }
}

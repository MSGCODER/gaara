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
        // TODO

        return true;
    }
}

package us.waw.gaara.service.impl;

import org.springframework.stereotype.Service;
import us.waw.gaara.service.AccountService;

/**
 * Created by lenn on 16/9/25.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public Boolean isValidAccount(String username, String password) {
        if(username == null || "".equals(username)){
            throw new RuntimeException("Parameter username is empty.");
        }

        if(password == null || "".equals(password)){
            throw new RuntimeException("Parameter password is empty.");
        }

        if("lenn".equals(username) && "youshenbubai".equals(password)){
            return true;
        }

        return false;
    }
}

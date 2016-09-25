package waw.gaara.service;

/**
 * Created by lenn on 16/9/25.
 */
public interface AccountService {
    /**
     * 校验账户是否合法
     * @param username
     * @param password
     * @return
     */
    Boolean isValidAccount(String username, String password);
}

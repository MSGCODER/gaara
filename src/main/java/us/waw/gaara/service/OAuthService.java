package us.waw.gaara.service;

/**
 * Created by lenn on 16/9/20.
 */
public interface OAuthService {
    /**
     * 校验客户端id是否合法
     * @param clientId
     * @return
     */
    Boolean isValidClientId(String clientId);

    /**
     * 校验客户端secret key是否合法
     * @param clientSecretKey
     * @return
     */
    Boolean isValidClientSecretKey(String clientSecretKey);

    /**
     * 校验授权码是否正确
     * @param authCode
     * @return
     */
    Boolean isValidAuthCode(String authCode);

}

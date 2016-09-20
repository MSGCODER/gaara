package waw.gaara.service;

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

}

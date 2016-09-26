package waw.gaara.dao.entity;

/**
 * Created by lenn on 16/9/26.
 */

/**
 * 注册的第三方应用
 */
public class Client {
    private Integer id;

    // 申请应用时分配的AppKey
    private String clientId;

    // 申请应用时分配的AppSecret
    private String clientSecret;

    // 注册应用时设置的回调地址
    private String redirectUri;

    // 注册应用的名字
    private String name;

    // 注册应用的描述
    private String description;

    // 该第三方应用是否被disable掉
    private Boolean isDisabled;

    public Client() {
    }

    public Client(String clientId, String clientSecret, String redirectUri, String description) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.description = description;
        this.isDisabled = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }
}

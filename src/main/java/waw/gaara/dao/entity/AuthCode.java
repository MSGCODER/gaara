package waw.gaara.dao.entity;

/**
 * Created by lenn on 16/9/26.
 */

import java.util.Date;

/**
 * 授权码
 */
public class AuthCode {
    private Integer id;

    private String clientId;

    private String userId;

    private String authCode;

    private Boolean isAvailable;

    private Date createTime;

    public AuthCode() {
    }

    public AuthCode(String clientId, String userId, String authCode, Date createTime) {
        this.clientId = clientId;
        this.userId = userId;
        this.authCode = authCode;
        this.isAvailable = true;
        this.createTime = createTime;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

package cn.yunsenlin.web.base.dto.user.android;

public class LoginInfoReturn {
    private String token;
    private String error;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LoginInfoReturn(String token, String error, String userId) {
        this.token = token;
        this.error = error;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

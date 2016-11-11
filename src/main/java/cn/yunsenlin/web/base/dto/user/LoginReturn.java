package cn.yunsenlin.web.base.dto.user;

public class LoginReturn {
    private String token;
    private String error;
    private int userId;

    public LoginReturn(String token, String error, int userId) {
        this.token = token;
        this.error = error;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

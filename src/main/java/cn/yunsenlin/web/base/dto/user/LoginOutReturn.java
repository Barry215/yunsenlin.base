package cn.yunsenlin.web.base.dto.user;

public class LoginOutReturn {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LoginOutReturn(String error) {
        this.error = error;
    }
}

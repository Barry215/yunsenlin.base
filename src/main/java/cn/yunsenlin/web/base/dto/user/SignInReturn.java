package cn.yunsenlin.web.base.dto.user;


public class SignInReturn {
    private String error;

    public SignInReturn(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

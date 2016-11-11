package cn.yunsenlin.web.base.dto.user;

public class SendEmailReturn {
    private String error;
    private boolean success;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public SendEmailReturn(String error, boolean success) {
        this.error = error;
        this.success = success;
    }
}

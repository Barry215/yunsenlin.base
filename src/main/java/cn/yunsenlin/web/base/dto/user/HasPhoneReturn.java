package cn.yunsenlin.web.base.dto.user;

public class HasPhoneReturn {
    private boolean has;
    private String error;

    public boolean isHas() {
        return has;
    }

    public void setHas(boolean has) {
        this.has = has;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HasPhoneReturn(boolean has, String error) {
        this.has = has;
        this.error = error;
    }
}

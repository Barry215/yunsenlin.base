package cn.yunsenlin.web.base.dto.calculate.android;

public class ExecutionReturn {
    private String error;

    public ExecutionReturn(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

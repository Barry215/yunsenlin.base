package cn.yunsenlin.web.base.error;



public enum  ErrorUtils {
    DataValid("D0001","数据验证不通过"),
    NoLogin("U0001","登录错误");
    private String errorCode;
    private String errorInfo;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    ErrorUtils(String errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }
}

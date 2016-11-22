package cn.yunsenlin.web.base.error;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum  ErrorUtils {
    DataValid("D0001","数据验证不通过"),
    NoLogin("U0001","登录错误"),
    EmailAlreadyHas("U0002","邮件地址已经存在"),
    PhoneAlreadyHas("U0003","手机号码已经存在"),
    NoEmail("U0004","邮件地址不存在"),
    NoPhone("U0005","手机号码不存在"),
    ErrorPhoneCode("U0006","手机验证码错误"),
    ErrorEmailCode("U0007","邮箱验证码错误"),
    PhoneMessageTooMuch("U0008","手机验证码发送过于频繁，请半小时后重试");
    public String errorCode;
    public String errorInfo;
    private static Logger logger = LoggerFactory.getLogger(ErrorUtils.class);

    public String getErrorCode() {
        logger.info("客户端和服务端交互发生了数据交互错误，错误类型代码"+this.errorCode+
        ",错误信息："+this.errorInfo);
        return errorCode;
    }

    ErrorUtils(String errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }
}

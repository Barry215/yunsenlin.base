package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.user.LoginParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.RegxFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return LoginParam.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String errorCode = ErrorUtils.DataValid.getErrorCode();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"loginName",errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password",errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"remember",errorCode);
        LoginParam loginParam = (LoginParam) o;
        String loginName = loginParam.getLoginName();
        String password = loginParam.getPassword();
        if (!loginName.matches(RegxFactory.emailRegx)
                &&!loginName.matches(RegxFactory.phoneRegx)){
            errors.rejectValue("loginName",errorCode);
        }
        if (password.length()<6||password.length()>20){
            errors.rejectValue("password",errorCode);
        }
    }
}

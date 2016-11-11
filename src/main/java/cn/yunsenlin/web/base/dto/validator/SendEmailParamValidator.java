package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.user.SendEmailParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.RegxFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SendEmailParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return SendEmailParam.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String errorCode = ErrorUtils.DataValid.errorCode;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email",errorCode);
        SendEmailParam sendEmailParam = (SendEmailParam) o;
        String email = sendEmailParam.getEmail();
        if (email==null||!email.matches(RegxFactory.emailRegx)){
            errors.rejectValue("email",errorCode);
        }

    }
}

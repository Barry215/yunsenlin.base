package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.user.SendEmailParam;
import cn.yunsenlin.web.base.dto.user.SendPhoneParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.RegxFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SendPhoneParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return SendPhoneParam.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String errCode = ErrorUtils.DataValid.getErrorCode();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone",errCode);
        SendPhoneParam sendPhoneParam = (SendPhoneParam) o;
        String phone = sendPhoneParam.getPhone();
        if (phone==null||!phone.matches(RegxFactory.emailRegx)){
            errors.rejectValue("phone",errCode);
        }

    }
}

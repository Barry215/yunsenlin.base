package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.user.HasPhoneParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.RegxFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class HasPhoneParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return HasPhoneParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String errorCode = ErrorUtils.DataValid.errorCode;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone",errorCode);
        HasPhoneParam hasPhoneParam = (HasPhoneParam) target;
        String phone = hasPhoneParam.getPhone();
        if (!phone.matches(RegxFactory.phoneRegx)){
            errors.rejectValue("phone",errorCode);
        }
    }
}

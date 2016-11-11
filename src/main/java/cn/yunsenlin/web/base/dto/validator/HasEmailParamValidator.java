package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.user.HasEmailParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.RegxFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class HasEmailParamValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return HasEmailParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String errorCode = ErrorUtils.DataValid.getErrorCode();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email",errorCode);
        HasEmailParam hasEmailParam = (HasEmailParam) target;
        String email = hasEmailParam.getEmail();
        if (!email.matches(RegxFactory.mobileRegx)){
            errors.rejectValue("email",errorCode);
        }
    }
}

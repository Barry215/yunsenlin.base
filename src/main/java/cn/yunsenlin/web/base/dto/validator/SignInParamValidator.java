package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.user.SignInParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.factory.RegxFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignInParamValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SignInParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String errCode = ErrorUtils.DataValid.errorCode;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", errCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", errCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneCode", errCode);
        SignInParam signInParam = (SignInParam) target;
        if (!BigDecimalFactory.isNumber(signInParam.getPhoneCode())) {
            errors.rejectValue("phoneCode", errCode);
        }
        if (!signInParam.getPhone().matches(RegxFactory.phoneRegx)) {
            errors.rejectValue("phone", errCode);
        }
        String email = signInParam.getEmail();
        String emailCode = signInParam.getEmailCode();
        if (email != null && email.length() > 0 && !email.matches(RegxFactory.emailRegx)) {
            errors.rejectValue("email", errCode);
            if (emailCode != null && BigDecimalFactory.isNumber(emailCode)) {
                errors.rejectValue("emailCode", errCode);
            }
        }
    }
}

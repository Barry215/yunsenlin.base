package cn.yunsenlin.web.base.dto.user.android.validator;

import cn.yunsenlin.web.base.dto.user.android.SignInParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignInParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return SignInParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        SignInParam signInParam = (SignInParam) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mobile",code);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"code",code);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password",code);
        if (!signInParam.getMobile().matches("^1[34578]\\d{9}$")||
                signInParam.getMobile().length()!=11){
            errors.rejectValue("mobile",code);
        }
        if (signInParam.getPassword().length()<6||signInParam.getPassword()
                .length()>20){
            errors.rejectValue("password",code);
        }
        if (signInParam.getCode().length()!=6){
            errors.rejectValue("code",code);
        }
    }
}

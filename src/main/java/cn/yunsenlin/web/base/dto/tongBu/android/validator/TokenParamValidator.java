package cn.yunsenlin.web.base.dto.tongBu.android.validator;

import cn.yunsenlin.web.base.dto.tongBu.android.TokenParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TokenParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return TokenParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        TokenParam t = (TokenParam) target;
        if (t.getUserId()<=0){
            errors.rejectValue("userId",code);
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"token",code);
    }
}

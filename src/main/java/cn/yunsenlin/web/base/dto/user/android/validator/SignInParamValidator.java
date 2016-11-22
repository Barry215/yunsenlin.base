package cn.yunsenlin.web.base.dto.user.android.validator;

import cn.yunsenlin.web.base.dto.user.android.SignInParam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SignInParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return SignInParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

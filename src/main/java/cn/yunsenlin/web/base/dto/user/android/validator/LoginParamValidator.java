package cn.yunsenlin.web.base.dto.user.android.validator;

import cn.yunsenlin.web.base.dto.user.android.LoginParam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return LoginParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

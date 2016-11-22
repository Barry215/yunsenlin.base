package cn.yunsenlin.web.base.dto.tongBu.android.validator;

import cn.yunsenlin.web.base.dto.tongBu.android.TokenParam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TokenParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return TokenParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

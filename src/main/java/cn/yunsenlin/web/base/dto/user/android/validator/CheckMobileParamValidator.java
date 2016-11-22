package cn.yunsenlin.web.base.dto.user.android.validator;

import cn.yunsenlin.web.base.dto.user.android.CheckMobileParam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CheckMobileParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return CheckMobileParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

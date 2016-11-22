package cn.yunsenlin.web.base.dto.user.android.validator;

import cn.yunsenlin.web.base.dto.user.android.MobileParam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MobileParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return MobileParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

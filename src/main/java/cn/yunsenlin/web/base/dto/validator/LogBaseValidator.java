package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.calculate.android.LogBase;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LogBaseValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return LogBase.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}

package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.EvaluateLogBase;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EvaluateLogBaseValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return EvaluateLogBase.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

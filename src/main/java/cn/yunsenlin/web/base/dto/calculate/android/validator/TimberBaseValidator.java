package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.TimberBase;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TimberBaseValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return TimberBase.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

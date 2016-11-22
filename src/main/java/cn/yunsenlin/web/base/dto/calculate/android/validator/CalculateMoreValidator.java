package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.CalculateMore;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CalculateMoreValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return CalculateMore.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

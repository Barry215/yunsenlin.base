package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.BillKey;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BillKeyValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return BillKey.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.TimberBase;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TimberBaseValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return TimberBase.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TimberBase timberBase = (TimberBase) target;
        if (!BigDecimalFactory.isNumber(
                timberBase.getHeight(),timberBase.getLength(),
                timberBase.getWidth()
        )){
            errors.rejectValue("length", ErrorUtils.DataValid.getErrorCode());
        }
    }
}

package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.LogBase;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class LogBaseValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return LogBase.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        LogBase logBase = (LogBase) target;
        if (!BigDecimalFactory.isNumber(
                logBase.getDiameter(),logBase.getLength()
        )){
            errors.rejectValue("length",code);
        }
    }
}

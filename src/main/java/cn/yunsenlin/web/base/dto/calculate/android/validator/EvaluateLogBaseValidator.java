package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.EvaluateLogBase;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EvaluateLogBaseValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return EvaluateLogBase.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"logCode",code);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cityCode",code);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"diameter",code);
        EvaluateLogBase evaluateLogBase = (EvaluateLogBase) target;
        if (BigDecimalFactory.isNumber(
                evaluateLogBase.getLength(),evaluateLogBase.getDiameter()
        )){
            errors.rejectValue("length",code);
        }
    }
}

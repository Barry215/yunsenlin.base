package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.WeightBase;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class WeightBaseValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return WeightBase.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        WeightBase weightBase = (WeightBase) target;
        if (BigDecimalFactory.isNumber(
             weightBase.getLorry(),weightBase.getTotal()
        )){
            errors.rejectValue("total", ErrorUtils.DataValid.getErrorCode());
        }
    }
}

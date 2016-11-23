package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.BillKey;
import cn.yunsenlin.web.base.error.ErrorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BillKeyValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return BillKey.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"time",code);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"token",code);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id",code);
        BillKey billKey = (BillKey) target;
        if (billKey.getUserId()<=0){
            errors.rejectValue("id",code);
        }
    }
}

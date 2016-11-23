package cn.yunsenlin.web.base.dto.user.android.validator;

import cn.yunsenlin.web.base.dto.user.android.CheckMobileParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CheckMobileParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return CheckMobileParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        CheckMobileParam checkMobileParam = (CheckMobileParam) target;
        if (!checkMobileParam.getMobile().matches("^1[34578]\\d{9}$")||
                checkMobileParam.getMobile().length()!=11){
            errors.rejectValue("mobile",code);
        }
        if (checkMobileParam.getCode().length()!=6){
            errors.rejectValue("code",code);
        }
    }
}

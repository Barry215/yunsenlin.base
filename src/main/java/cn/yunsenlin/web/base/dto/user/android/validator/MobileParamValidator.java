package cn.yunsenlin.web.base.dto.user.android.validator;

import cn.yunsenlin.web.base.dto.user.android.MobileParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MobileParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return MobileParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        MobileParam mobileParam = (MobileParam) target;
        if (!mobileParam.getMobile().matches("^1[34578]\\d{9}$")||
                mobileParam.getMobile().length()!=11){
            errors.rejectValue("mobile",code);
        }
    }
}

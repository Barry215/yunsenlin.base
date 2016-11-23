package cn.yunsenlin.web.base.dto.tongBu.android.validator;

import cn.yunsenlin.web.base.dto.tongBu.android.GetBillListParam;
import cn.yunsenlin.web.base.dto.tongBu.android.TimeIndex;
import cn.yunsenlin.web.base.error.ErrorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

public class GetBillListParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return GetBillListParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        GetBillListParam getBillListParam = (GetBillListParam) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userId",code);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"token",code);
        if (getBillListParam.getUserId()<=0){
            errors.rejectValue("userId",code);
        }
        List<TimeIndex> timeIndices = getBillListParam.getIndexList();
        timeIndices.stream().filter(t -> t.getTime() == null).forEach(t -> errors.rejectValue("indexList", code));
    }
}

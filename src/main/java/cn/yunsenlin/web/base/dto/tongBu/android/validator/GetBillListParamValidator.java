package cn.yunsenlin.web.base.dto.tongBu.android.validator;

import cn.yunsenlin.web.base.dto.tongBu.android.GetBillListParam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class GetBillListParamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return GetBillListParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

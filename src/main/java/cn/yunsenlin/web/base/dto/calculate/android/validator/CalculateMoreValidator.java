package cn.yunsenlin.web.base.dto.calculate.android.validator;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

public class CalculateMoreValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return CalculateMore.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String code = ErrorUtils.DataValid.getErrorCode();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"time",code);
        CalculateMore c = (CalculateMore) target;
        List<Log> logList = c.getLogList();
        List<Timber> timberList = c.getTimberList();
        List<Validation> validationList = c.getValidationList();
        List<Weight> weightList =c.getWeightList();
        if (logList!=null) {
            logList.stream().filter(l -> BigDecimalFactory.isNumber(
                    l.getNum(), l.getPiece(), l.getDiameter(), l.getLength()
                    , l.getTypeCode()
            )).forEach(l -> errors.rejectValue("num", code));
        }
        if (timberList!=null) {
            timberList.stream().filter(t -> BigDecimalFactory.isNumber(
                    t.getNum(), t.getPiece(), t.getWidth(), t.getLength(),
                    t.getHeight(), t.getStack()
            )).forEach(t -> errors.rejectValue("num", code));
        }
        if (weightList!=null) {
            weightList.stream().filter(w -> BigDecimalFactory.isNumber(
                    w.getPiece(), w.getLorry(), w.getTotal()
            )).forEach(w -> errors.rejectValue("total", code));
        }
        if (validationList!=null) {
            for (Validation v :
                    validationList) {
                if (BigDecimalFactory.isNumber(
                        v.getNum(), v.getPiece(), v.getDiameter(), v.getLength()
                )) {
                    errors.rejectValue("num", code);
                }
                if (v.getType() == null || !(v.getType().equals("xiongjing") || v.getType().equals("genjing"))) {
                    errors.rejectValue("type", code);
                }
                if (v.getCityCode() == null && v.getCityCode().length() == 0) {
                    errors.rejectValue("cityCode", code);
                }
                if (v.getLogCode() == null && v.getLogCode().length() == 0) {
                    errors.rejectValue("logCode", code);
                }
            }
        }
    }
}

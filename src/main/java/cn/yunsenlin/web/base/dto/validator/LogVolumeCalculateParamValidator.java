package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.calculate.VolumeCalculateParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.service.WoodTypeService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LogVolumeCalculateParamValidator implements Validator{
    private final WoodTypeService woodTypeService;

    public LogVolumeCalculateParamValidator(WoodTypeService woodTypeService) {
        this.woodTypeService = woodTypeService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return VolumeCalculateParam.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String errorCode = ErrorUtils.DataValid.errorCode;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"length", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"diameter",errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"typeCode",errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"num",errorCode);
        VolumeCalculateParam param = (VolumeCalculateParam) target;
        String length = param.getLength();
        String diameter = param.getDiameter();
        String typeCode = param.getTypeCode();
        String num = param.getNum();
        if (!woodTypeService.hasTypeCode(typeCode)){
            errors.rejectValue("typeCode",errorCode);
        }
        if(!BigDecimalFactory.isNumber(length)){
            errors.rejectValue("length",errorCode);
        }
        if (!BigDecimalFactory.isNumber(diameter)){
            errors.rejectValue("diameter",errorCode);
        }
        if (!BigDecimalFactory.isNumber(num)){
            errors.rejectValue("num",errorCode);
        }
    }
}

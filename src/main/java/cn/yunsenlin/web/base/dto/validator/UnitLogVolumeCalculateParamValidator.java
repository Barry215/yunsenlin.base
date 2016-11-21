package cn.yunsenlin.web.base.dto.validator;

import cn.yunsenlin.web.base.dto.calculate.android.UnitVolumeCalculateParam;
import cn.yunsenlin.web.base.dto.calculate.android.WoodBase;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.service.WoodTypeService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class UnitLogVolumeCalculateParamValidator implements Validator{
    private final WoodTypeService woodTypeService;

    public UnitLogVolumeCalculateParamValidator(WoodTypeService woodTypeService) {
        this.woodTypeService = woodTypeService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UnitVolumeCalculateParam.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        String errorCode = ErrorUtils.DataValid.errorCode;
        UnitVolumeCalculateParam object = (UnitVolumeCalculateParam) target;
        List<WoodBase> woodBaseList = object.getWoodBaseList();
        for (WoodBase woodBase : woodBaseList) {
            String length = woodBase.getLength();
            String diameter = woodBase.getDiameter();
            String typeCode = woodBase.getTypeCode();
            int num = woodBase.getNum();
            if (typeCode==null||!woodTypeService.hasTypeCode(typeCode)){
                errors.rejectValue("woodBaseList",errorCode);
            }
            if(length==null||!BigDecimalFactory.isNumber(length)){
                errors.rejectValue("woodBaseList",errorCode);
            }
            if (diameter==null||!BigDecimalFactory.isNumber(diameter)){
                errors.rejectValue("woodBaseList",errorCode);
            }
            if (num<0){
                errors.rejectValue("woodBaseList",errorCode);
            }
        }

    }
}

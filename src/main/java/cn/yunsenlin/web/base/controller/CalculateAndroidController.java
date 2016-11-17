package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.UnitVolumeCalculateParam;
import cn.yunsenlin.web.base.dto.calculate.VolumeCalculateParam;
import cn.yunsenlin.web.base.dto.calculate.VolumeCalculateReturn;
import cn.yunsenlin.web.base.service.VolumeAutoCalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Transactional
@RequestMapping("/android/calculate")
public class CalculateAndroidController {
    private final VolumeAutoCalculateService volumeAutoCalculateService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Validator logVolumeCalculateValidator;
    private final Validator unitVolumeCalculateParam;

    public CalculateAndroidController(VolumeAutoCalculateService volumeAutoCalculateService, Validator logVolumeCalculateValidator, Validator unitVolumeCalculateParam) {
        this.volumeAutoCalculateService = volumeAutoCalculateService;
        this.logVolumeCalculateValidator = logVolumeCalculateValidator;
        this.unitVolumeCalculateParam = unitVolumeCalculateParam;
    }
    @InitBinder(value = "logVolumeCalculateValidator")
    public void initVolumeCalculateValidator(DataBinder binder) {
        binder.addValidators(logVolumeCalculateValidator);
    }
    @InitBinder(value = "unitVolumeCalculateParam")
    public void initWoodBaseValidator(DataBinder binder){
        binder.addValidators(unitVolumeCalculateParam);
    }

    @RequestMapping(value = "/logVolumeCalculate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public VolumeCalculateReturn volumeCalculate(
            @Valid
            @RequestBody VolumeCalculateParam volumeCalculateValidator,
            BindingResult result){
        if (result.hasErrors()){
            return new VolumeCalculateReturn("-1",result.getAllErrors().toString());
        }
        String length = volumeCalculateValidator.getLength();
        String diameter = volumeCalculateValidator.getDiameter();
        String typeCode = volumeCalculateValidator.getTypeCode();
        String num = volumeCalculateValidator.getNum();
        logger.info("volumeCalculate running length="+length+"," +
                "diameter="+diameter+",typeCode="+typeCode+",num="+num);
        String volume =
            volumeAutoCalculateService.getLogVolumeAutoCalculate(length,diameter,typeCode,num);
        return new VolumeCalculateReturn(volume,"0");
    }
    @RequestMapping(value = "/unitLogVolumeCalculate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public VolumeCalculateReturn unitVolumeCalculate(@RequestBody
                                                         @Valid UnitVolumeCalculateParam unitVolumeCalculateParam, BindingResult result){
        if (result.hasErrors()){
            return new VolumeCalculateReturn("-1",result.getAllErrors().toString());
        }
        logger.info("unitVolumeCalculateParam running list:"+ unitVolumeCalculateParam);
        String volume =
                volumeAutoCalculateService.getLogVolumeAutoCalculate(unitVolumeCalculateParam.getWoodBaseList());
        return new VolumeCalculateReturn(volume,"0");
    }

}

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
@RequestMapping("/calculate")
public class CalculateController {
    private final VolumeAutoCalculateService volumeAutoCalculateService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Validator volumeCalculateValidator;
    private final Validator unitVolumeCalculateParam;

    public CalculateController(VolumeAutoCalculateService volumeAutoCalculateService, Validator volumeCalculateValidator, Validator unitVolumeCalculateParam) {
        this.volumeAutoCalculateService = volumeAutoCalculateService;
        this.volumeCalculateValidator = volumeCalculateValidator;
        this.unitVolumeCalculateParam = unitVolumeCalculateParam;
    }
    @InitBinder(value = "volumeCalculateValidator")
    public void initVolumeCalculateValidator(DataBinder binder) {
        binder.addValidators(volumeCalculateValidator);
    }
    @InitBinder(value = "unitVolumeCalculateParam")
    public void initWoodBaseValidator(DataBinder binder){
        binder.addValidators(unitVolumeCalculateParam);
    }

    @RequestMapping(value = "/volumeCalculate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
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
        logger.info("volumeCalculate running length="+length+"," +
                "diameter="+diameter+",typeCode="+typeCode);
        String volume =
            volumeAutoCalculateService.getVolumeAutoCalculate(length,diameter,typeCode);
        return new VolumeCalculateReturn(volume,"0");
    }
    @RequestMapping(value = "/unitVolumeCalculate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public VolumeCalculateReturn unitVolumeCalculate(@RequestBody
                                                         @Valid UnitVolumeCalculateParam unitVolumeCalculateParam, BindingResult result){
        if (result.hasErrors()){
            return new VolumeCalculateReturn("-1",result.getAllErrors().toString());
        }
        logger.info("unitVolumeCalculateParam running list:"+ unitVolumeCalculateParam);
        String volume =
                volumeAutoCalculateService.getVolumeAutoCalculate(unitVolumeCalculateParam.getWoodBaseList());
        return new VolumeCalculateReturn(volume,"0");
    }

}

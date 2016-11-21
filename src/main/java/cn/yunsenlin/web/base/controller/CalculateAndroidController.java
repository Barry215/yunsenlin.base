package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.service.CommonInfoService;
import cn.yunsenlin.web.base.service.VolumeAutoCalculateService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

@Transactional
@RequestMapping("/android/calculate")
public class CalculateAndroidController {
    private final VolumeAutoCalculateService volumeAutoCalculateService;
    private final CommonInfoService commonInfoService;
    private final Validator evaluateLogBaseValidator;
    private final Validator logBaseValidator;
    private final Validator timberBaseValidator;
    private final Validator weightBaseValidator;

    public CalculateAndroidController(VolumeAutoCalculateService volumeAutoCalculateService,
                                      CommonInfoService commonInfoService,
                                      Validator evaluateLogBaseValidator,
                                      Validator logBaseValidator,
                                      Validator timberBaseValidator,
                                      Validator weightBaseValidator) {
        this.volumeAutoCalculateService = volumeAutoCalculateService;
        this.commonInfoService = commonInfoService;
        this.evaluateLogBaseValidator = evaluateLogBaseValidator;
        this.logBaseValidator = logBaseValidator;
        this.timberBaseValidator = timberBaseValidator;
        this.weightBaseValidator = weightBaseValidator;
    }

    @InitBinder(value = "logBase")
    public void logBaseValidator(DataBinder binder) {
        binder.addValidators(logBaseValidator);
    }

    @InitBinder(value = "weightBase")
    public void weightBaseValidator(DataBinder binder) {
        binder.addValidators(weightBaseValidator);
    }

    @InitBinder(value = "timberBase")
    public void timberBaseValidator(DataBinder binder) {
        binder.addValidators(timberBaseValidator);
    }

    @InitBinder(value = "evaluateLogBase")
    public void evaluateLogBaseValidator(DataBinder binder) {
        binder.addValidators(evaluateLogBaseValidator);
    }

    @RequestMapping(value = "/log2013", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn log2013(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100001","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/log1984", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn log1984(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100002","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/russianLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn russianLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100004","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/americanLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn americanLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100005","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/southeastAsiaLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn southeastAsiaLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100006","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/mineLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn mineLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100007","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/purlinLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn purlinLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100012","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/rafterLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn rafterLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100003","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/boleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn boleLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100009","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/smallBoleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn smallBoleLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100008","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/shanBoleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn shanBoleLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100013","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/pinusBoleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn pinusBoleLog(LogBase logBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getLogVolumeAutoCalculate(
                logBase.getLength(),
                logBase.getDiameter(),
                "100014","1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/weightLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public WeightBaseReturn weightLog(WeightBase weightBase,BindingResult result) {
        if (result.hasErrors()){
            return new WeightBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String weight = volumeAutoCalculateService.getWeightCalculate(
                weightBase.getTotal(),
                weightBase.getLorry()
        );
        return new WeightBaseReturn(
                weight,"0"
        );
    }

    @RequestMapping(value = "/timber", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn timber(TimberBase timberBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getTimberVolumeAutoCalculate(
                timberBase.getLength(),
                timberBase.getWidth(),
                timberBase.getHeight(),
                "1"
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/getCityList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CityListReturn getCityList() {
        return new CityListReturn(
                commonInfoService.getCityList()
        );
    }

    @RequestMapping(value = "/getValuateLogListByXiongJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public EvaluatedLogTypeListReturn getValuateLogListByXiongJing() {
        return new EvaluatedLogTypeListReturn(
                commonInfoService.getX()
        );
    }

    @RequestMapping(value = "/getValuateLogListByGenJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public EvaluatedLogTypeListReturn getValuateLogListByGenJing() {
        return new EvaluatedLogTypeListReturn(
                commonInfoService.getG()
        );
    }

    @RequestMapping(value = "/valuateLogByGenJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn valuateLogByGenJing(EvaluateLogBase evaluateLogBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getEvaluateGenJingVolumeAutoCalculate(
                evaluateLogBase.getLength(),
                evaluateLogBase.getDiameter(),
                "1",
                evaluateLogBase.getLogCode(),
                evaluateLogBase.getCityCode()
        );
        return new LogBaseReturn(volume,"0");
    }

    @RequestMapping(value = "/valuateLogByXiongJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn valuateLogByXiongJing(EvaluateLogBase evaluateLogBase,BindingResult result) {
        if (result.hasErrors()){
            return new LogBaseReturn(
                    "", ErrorUtils.DataValid.getErrorCode()
            );
        }
        String volume = volumeAutoCalculateService.getEvaluateXiongJingVolumeAutoCalculate(
                evaluateLogBase.getLength(),
                evaluateLogBase.getDiameter(),
                "1",
                evaluateLogBase.getLogCode(),
                evaluateLogBase.getCityCode()
        );
        return new LogBaseReturn(volume,"0");
    }

}

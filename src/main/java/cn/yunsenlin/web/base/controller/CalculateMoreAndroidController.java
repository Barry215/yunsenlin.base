package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.service.SessionService;
import cn.yunsenlin.web.base.service.UserRecordSaveService;
import cn.yunsenlin.web.base.service.VolumeAutoCalculateService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RequestMapping("/android/calculateMore")
public class CalculateMoreAndroidController {
    private final VolumeAutoCalculateService volumeAutoCalculateService;
    private final SessionService sessionService;
    private final UserRecordSaveService userRecordSaveService;
    private final Validator calculateMoreValidator;
    private final Validator billKeyValidator;

    public CalculateMoreAndroidController(VolumeAutoCalculateService volumeAutoCalculateService,
                                          SessionService sessionService,
                                          UserRecordSaveService userRecordSaveService,
                                          Validator calculateMoreValidator,
                                          Validator billKeyValidator) {
        this.volumeAutoCalculateService = volumeAutoCalculateService;
        this.sessionService = sessionService;
        this.userRecordSaveService = userRecordSaveService;
        this.calculateMoreValidator = calculateMoreValidator;
        this.billKeyValidator = billKeyValidator;
    }

    @InitBinder(value = "calculateMore")
    public void logBaseValidator(DataBinder binder) {
        binder.addValidators(calculateMoreValidator);
    }

    @InitBinder(value = "billKey")
    public void weightBaseValidator(DataBinder binder) {
        binder.addValidators(billKeyValidator);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CalculateMoreReturn index(@RequestBody @Valid CalculateMore calculateMore, BindingResult result) {
        if (result.hasErrors()) {
            new CalculateMoreReturn();
        }
        CalculateMoreReturn calculateMoreReturn = new CalculateMoreReturn();
        calculateMoreReturn.setTime(calculateMore.getTime());
        List<Log> logList = calculateMore.getLogList() == null ? new ArrayList<>() : calculateMore.getLogList();
        List<Timber> timberList = calculateMore.getTimberList() == null ? new ArrayList<>() : calculateMore.getTimberList();
        List<Validation> validationList = calculateMore.getValidationList() == null ? new ArrayList<>() : calculateMore.getValidationList();
        List<Weight> weightList = calculateMore.getWeightList() == null ? new ArrayList<>() : calculateMore.getWeightList();
        List<LogReturn> logReturnList
                = volumeAutoCalculateService.getLogReturn(
                logList);
        List<WeightReturn> weightReturnList
                = volumeAutoCalculateService.getWeightReturn(
                weightList);
        List<TimberReturn> timberReturnList
                = volumeAutoCalculateService.getTimberReturn(
                timberList);
        List<ValidationReturn> validationReturnList
                = volumeAutoCalculateService.getValidationReturn(
                validationList);
        calculateMoreReturn.setLogList(logReturnList);
        calculateMoreReturn.setTimberList(timberReturnList);
        calculateMoreReturn.setValidationList(validationReturnList);
        calculateMoreReturn.setWeightList(weightReturnList);
        String logSum = volumeAutoCalculateService.getLogSum(
                logList
        );
        String logVolume = volumeAutoCalculateService.getLogVolume(
                logList
        );
        String weightSum = volumeAutoCalculateService.getWeightSum(
                weightList
        );
        String weightVolume = volumeAutoCalculateService.getWeight(
                weightList
        );
        String timberSum = volumeAutoCalculateService.getTimberSum(
                timberList
        );
        String timberVolume = volumeAutoCalculateService.getTimberVolume(
                timberList
        );
        String valuationSum = volumeAutoCalculateService.getValidationSum(
                validationList
        );
        String ValuationVolume = volumeAutoCalculateService.getValidationVolume(
                validationList
        );
        String allSum = null;
        if (logSum.length() > 0
                && valuationSum.length() > 0
                && weightSum.length() > 0
                && timberSum.length() > 0) {
            allSum = BigDecimalFactory.get(logSum).add(
                    BigDecimalFactory.get(valuationSum)
            ).add(
                    BigDecimalFactory.get(timberSum)
            ).add(
                    BigDecimalFactory.get(weightSum)
            ).toString();
        }
        calculateMoreReturn.setAllSum(allSum);
        calculateMoreReturn.setLogSum(logSum);
        calculateMoreReturn.setTimberSum(timberSum);
        calculateMoreReturn.setValuationSum(valuationSum);
        calculateMoreReturn.setWeightSum(weightSum);
        calculateMoreReturn.setLogVolume(
                volumeAutoCalculateService.getLogVolume(logList)
        );
        calculateMoreReturn.setWeightVolume(
                volumeAutoCalculateService.getWeight(weightList)
        );
        calculateMoreReturn.setValuationVolume(
                volumeAutoCalculateService.getValidationVolume(validationList)
        );
        calculateMoreReturn.setTimberVolume(
                volumeAutoCalculateService.getTimberVolume(timberList)
        );
        calculateMoreReturn.setLogVolume(logVolume);
        calculateMoreReturn.setWeightVolume(weightVolume);
        calculateMoreReturn.setValuationVolume(ValuationVolume);
        calculateMoreReturn.setTimberVolume(timberVolume);
        String error = "0";
        if (sessionService.checkToken(
                calculateMore.getToken(), calculateMore.getUserId()
        )) {
            userRecordSaveService.save(calculateMoreReturn, calculateMore);
        } else {
            error = ErrorUtils.NoLogin.getErrorCode();
        }
        calculateMoreReturn.setError(error);
        return calculateMoreReturn;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn index(@RequestBody @Valid BillKey billKey, BindingResult result) {
        if (result.hasErrors()) {
            return new ExecutionReturn(
                    ErrorUtils.NoLogin.getErrorCode());
        }
        if (sessionService.checkToken(
                billKey.getToken(), billKey.getUserId()
        )) {
            BillUserRecordKey billUserRecordKey = new BillUserRecordKey();
            billUserRecordKey.setUserid(billKey.getUserId());
            billUserRecordKey.setTime(billKey.getTime());
            userRecordSaveService.delete(
                    billUserRecordKey
            );
            return new ExecutionReturn(
                    "0"
            );
        } else {
            return new ExecutionReturn(
                    ErrorUtils.NoLogin.getErrorCode()
            );
        }
    }
}

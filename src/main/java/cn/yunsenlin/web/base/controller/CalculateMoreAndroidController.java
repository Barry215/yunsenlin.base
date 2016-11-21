package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.factory.BigDecimalFactory;
import cn.yunsenlin.web.base.service.VolumeAutoCalculateService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Transactional
@RequestMapping("/android/calculateMore")
public class CalculateMoreAndroidController {
    private final VolumeAutoCalculateService volumeAutoCalculateService;

    public CalculateMoreAndroidController(VolumeAutoCalculateService volumeAutoCalculateService) {
        this.volumeAutoCalculateService = volumeAutoCalculateService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CalculateMoreReturn index(CalculateMore calculateMore) {
        CalculateMoreReturn calculateMoreReturn = new CalculateMoreReturn();
        calculateMoreReturn.setTime(calculateMore.getTime());
        List<LogReturn> logReturnList
                = volumeAutoCalculateService.getLogReturn(calculateMore.getLogList());
        List<WeightReturn> weightReturnList
                = volumeAutoCalculateService.getWeightReturn(calculateMore.getWeightList());
        List<TimberReturn> timberReturnList
                = volumeAutoCalculateService.getTimberReturn(calculateMore.getTimberList());
        List<ValidationReturn> validationReturnList
                = volumeAutoCalculateService.getValidationReturn(calculateMore.getValidationList());
        calculateMoreReturn.setLogList(logReturnList);
        calculateMoreReturn.setTimberList(timberReturnList);
        calculateMoreReturn.setValidationList(validationReturnList);
        calculateMoreReturn.setWeightList(weightReturnList);
        String logSum = volumeAutoCalculateService.getLogSum(
                calculateMore.getLogList()
        );
        String logVolume= volumeAutoCalculateService.getLogVolume(
                calculateMore.getLogList()
        );
        String weightSum= volumeAutoCalculateService.getWeightSum(
                calculateMore.getWeightList()
        );
        String weightVolume= volumeAutoCalculateService.getWeight(
                calculateMore.getWeightList()
        );
        String timberSum= volumeAutoCalculateService.getTimberSum(
                calculateMore.getTimberList()
        );
        String timberVolume= volumeAutoCalculateService.getTimberVolume(
                calculateMore.getTimberList()
        );
        String valuationSum= volumeAutoCalculateService.getValidationSum(
                calculateMore.getValidationList()
        );
        String ValuationVolume= volumeAutoCalculateService.getValidationVolume(
                calculateMore.getValidationList()
        );
        String allSum = null;
        if (logSum.length()>0
                &&valuationSum.length()>0
                &&weightSum.length()>0
                &&timberSum.length()>0){
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
                volumeAutoCalculateService.getLogVolume(calculateMore.getLogList())
        );
        calculateMoreReturn.setWeightVolume(
                volumeAutoCalculateService.getWeight(calculateMore.getWeightList())
        );
        calculateMoreReturn.setValuationVolume(
                volumeAutoCalculateService.getValidationVolume(calculateMore.getValidationList())
        );
        calculateMoreReturn.setTimberVolume(
                volumeAutoCalculateService.getTimberVolume(calculateMore.getTimberList())
        );
        calculateMoreReturn.setLogVolume(logVolume);
        calculateMoreReturn.setWeightVolume(weightVolume);
        calculateMoreReturn.setValuationVolume(ValuationVolume);
        calculateMoreReturn.setTimberVolume(timberVolume);
        // TODO: 11/21/2016
        String error;
        return calculateMoreReturn;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn index(BillKey billKey) {
        return null;
    }
}

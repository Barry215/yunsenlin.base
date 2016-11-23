package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.dto.calculate.android.*;

import java.math.BigDecimal;
import java.util.List;

public interface VolumeAutoCalculateService {
    BigDecimal getLogVolumeAutoCalculate(String length, String diameter, String typeCode, String num);
    BigDecimal getTimberVolumeAutoCalculate(String length,String width,String height,String num);
    BigDecimal getEvaluateXiongJingVolumeAutoCalculate(String length, String xiongjing, String num, String logCode, String cityCode);
    BigDecimal getEvaluateGenJingVolumeAutoCalculate(String length, String xiongjing, String num, String logCode, String cityCode);
    BigDecimal getWeightCalculate(String total,String lorry);
    List<LogReturn> getLogReturn(List<Log> logList);
    List<WeightReturn> getWeightReturn(List<Weight> weightList);
    List<TimberReturn> getTimberReturn(List<Timber> timberList);
    List<ValidationReturn> getValidationReturn(List<Validation> validationList);
    String getLogSum(List<Log> logList);
    String getLogVolume(List<Log> logList);
    String getWeightSum(List<Weight> weightList);
    String getWeight(List<Weight> weightList);
    String getTimberSum(List<Timber> timberList);
    String getTimberVolume(List<Timber> timberList);
    String getValidationSum(List<Validation> validationList);
    String getValidationVolume(List<Validation> validationList);
}

package cn.yunsenlin.web.base.service;


import java.math.BigDecimal;

public interface EvaluateVolumeCalculateService {
    BigDecimal evaluateXiongJing(String length, String xiongjing,
                                 String num, String typeCode, String cityCode);
    BigDecimal evaluateGenJing(String length,String xiongjing,
                             String num,String typeCode,String cityCode);
}

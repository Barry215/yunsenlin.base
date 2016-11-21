package cn.yunsenlin.web.base.service;


public interface EvaluateVolumeCalculateService {
    String evaluateXiongJing(String length,String xiongjing,
                             String num,String typeCode,String cityCode);
    String evaluateGenJing(String length,String xiongjing,
                             String num,String typeCode,String cityCode);
}

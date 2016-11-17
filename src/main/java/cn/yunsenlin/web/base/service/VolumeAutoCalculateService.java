package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.dto.calculate.WoodBase;

import java.util.List;

public interface VolumeAutoCalculateService {
    String getLogVolumeAutoCalculate(String length, String diameter, String typeCode,String num);
    String getLogVolumeAutoCalculate(List<WoodBase> woodBaseList);
    String getTimberVolumeAutoCalculate(String length,String width,String height);
    String getEvaluateVolumeAutoCalculate(String length,String xiongjing,String num,String typeCode,String cityCode);
}

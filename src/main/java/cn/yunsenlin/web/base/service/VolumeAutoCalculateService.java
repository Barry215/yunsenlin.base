package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.dto.calculate.WoodBase;

import java.util.List;

public interface VolumeAutoCalculateService {
    String getVolumeAutoCalculate(String length,String diameter,String typeCode);
    String getVolumeAutoCalculate(List<WoodBase> woodBaseList);
}

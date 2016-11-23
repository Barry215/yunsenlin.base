package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.service.EvaluateVolumeCalculateService;

import java.math.BigDecimal;

public class EvaluateVolumeCalculateServiceImpl implements EvaluateVolumeCalculateService {

    @Override
    public BigDecimal evaluateXiongJing(String length, String xiongjing, String num, String typeCode, String cityCode) {
        // TODO: 11/22/2016  暂时无法计算估值木材
        return null;
    }

    @Override
    public BigDecimal evaluateGenJing(String length, String xiongjing, String num, String typeCode, String cityCode) {
        // TODO: 11/22/2016  暂时无法计算估值木材
        return null;
    }
}

package cn.yunsenlin.web.base.service;

import java.math.BigDecimal;

public interface TimberVolumeCalculateService {
    BigDecimal getVolumeCalculateResult(String length, String width, String height);
}

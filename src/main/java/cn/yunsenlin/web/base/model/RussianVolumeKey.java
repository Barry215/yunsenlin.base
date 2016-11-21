package cn.yunsenlin.web.base.model;

import java.math.BigDecimal;

public class RussianVolumeKey {
    public RussianVolumeKey() {
    }

    private Double length;

    private Double diameter;

    public RussianVolumeKey(BigDecimal length, BigDecimal diameter) {
        this.length = length.doubleValue();
        this.diameter = diameter.doubleValue();
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }
}
package cn.yunsenlin.web.base.model;

import java.math.BigDecimal;

public class RafterLogCalculateRecord {
    private Integer id;

    private Double length;

    private Double width;

    private Double volume;

    public RafterLogCalculateRecord(BigDecimal length, BigDecimal width, BigDecimal volume) {
        this.length = length.doubleValue();
        this.width = width.doubleValue();
        this.volume = volume.doubleValue();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}
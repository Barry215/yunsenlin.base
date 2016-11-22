package cn.yunsenlin.web.base.model;

public class BillUserRecord extends BillUserRecordKey {
    private Double logSum;

    private Double logVolume;

    private Double weight;

    private Double weightSum;

    private Double timberSum;

    private Double timberVolume;

    private Double validationSum;

    private Double validationVolume;

    public Double getLogSum() {
        return logSum;
    }

    public void setLogSum(Double logSum) {
        this.logSum = logSum;
    }

    public Double getLogVolume() {
        return logVolume;
    }

    public void setLogVolume(Double logVolume) {
        this.logVolume = logVolume;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeightSum() {
        return weightSum;
    }

    public void setWeightSum(Double weightSum) {
        this.weightSum = weightSum;
    }

    public Double getTimberSum() {
        return timberSum;
    }

    public void setTimberSum(Double timberSum) {
        this.timberSum = timberSum;
    }

    public Double getTimberVolume() {
        return timberVolume;
    }

    public void setTimberVolume(Double timberVolume) {
        this.timberVolume = timberVolume;
    }

    public Double getValidationSum() {
        return validationSum;
    }

    public void setValidationSum(Double validationSum) {
        this.validationSum = validationSum;
    }

    public Double getValidationVolume() {
        return validationVolume;
    }

    public void setValidationVolume(Double validationVolume) {
        this.validationVolume = validationVolume;
    }
}
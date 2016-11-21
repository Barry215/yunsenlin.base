package cn.yunsenlin.web.base.dto.calculate.android;

import java.util.Date;
import java.util.List;

public class CalculateMoreReturn {
    private Date time;
    private List<LogReturn> logList;
    private List<WeightReturn> weightList;
    private List<TimberReturn> timberList;
    private List<ValidationReturn> validationList;
    private String error;
    private String logSum;
    private String logVolume;
    private String weightSum;
    private String weightVolume;
    private String timberSum;
    private String timberVolume;
    private String valuationSum;
    private String ValuationVolume;
    private String allSum;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<LogReturn> getLogList() {
        return logList;
    }

    public void setLogList(List<LogReturn> logList) {
        this.logList = logList;
    }

    public List<WeightReturn> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<WeightReturn> weightList) {
        this.weightList = weightList;
    }

    public List<TimberReturn> getTimberList() {
        return timberList;
    }

    public void setTimberList(List<TimberReturn> timberList) {
        this.timberList = timberList;
    }

    public List<ValidationReturn> getValidationList() {
        return validationList;
    }

    public void setValidationList(List<ValidationReturn> validationList) {
        this.validationList = validationList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLogSum() {
        return logSum;
    }

    public void setLogSum(String logSum) {
        this.logSum = logSum;
    }

    public String getLogVolume() {
        return logVolume;
    }

    public void setLogVolume(String logVolume) {
        this.logVolume = logVolume;
    }

    public String getWeightSum() {
        return weightSum;
    }

    public void setWeightSum(String weightSum) {
        this.weightSum = weightSum;
    }

    public String getWeightVolume() {
        return weightVolume;
    }

    public void setWeightVolume(String weightVolume) {
        this.weightVolume = weightVolume;
    }

    public String getTimberSum() {
        return timberSum;
    }

    public void setTimberSum(String timberSum) {
        this.timberSum = timberSum;
    }

    public String getTimberVolume() {
        return timberVolume;
    }

    public void setTimberVolume(String timberVolume) {
        this.timberVolume = timberVolume;
    }

    public String getValuationSum() {
        return valuationSum;
    }

    public void setValuationSum(String valuationSum) {
        this.valuationSum = valuationSum;
    }

    public String getValuationVolume() {
        return ValuationVolume;
    }

    public void setValuationVolume(String valuationVolume) {
        ValuationVolume = valuationVolume;
    }

    public String getAllSum() {
        return allSum;
    }

    public void setAllSum(String allSum) {
        this.allSum = allSum;
    }
}

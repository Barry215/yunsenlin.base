package cn.yunsenlin.web.base.dto.calculate.android;

import java.util.Date;
import java.util.List;

public class CalculateMore {
    private Date time;
    private List<Log> logList;
    private List<Weight> weightList;
    private List<Timber> timberList;
    private List<Validation> validationList;
    private String token;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public List<Weight> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<Weight> weightList) {
        this.weightList = weightList;
    }

    public List<Timber> getTimberList() {
        return timberList;
    }

    public void setTimberList(List<Timber> timberList) {
        this.timberList = timberList;
    }

    public List<Validation> getValidationList() {
        return validationList;
    }

    public void setValidationList(List<Validation> validationList) {
        this.validationList = validationList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

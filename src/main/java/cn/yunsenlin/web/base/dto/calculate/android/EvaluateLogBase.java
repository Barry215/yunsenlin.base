package cn.yunsenlin.web.base.dto.calculate.android;

public class EvaluateLogBase extends LogBase{
    private String logCode;
    private String cityCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }
}

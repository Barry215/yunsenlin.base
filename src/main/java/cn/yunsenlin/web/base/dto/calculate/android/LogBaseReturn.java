package cn.yunsenlin.web.base.dto.calculate.android;


public class LogBaseReturn {
    private String volume;
    private String error;

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LogBaseReturn(String volume, String error) {
        this.volume = volume;
        this.error = error;
    }

    public LogBaseReturn() {
    }
}

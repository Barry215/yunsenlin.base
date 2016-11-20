package cn.yunsenlin.web.base.dto.sigar;

public class Who {
    private String device;
    private String host;
    private Long time;
    private String user;

    public Who(String device, String host, Long time, String user) {
        this.device = device;
        this.host = host;
        this.time = time;
        this.user = user;
    }

    public String getDevice() {

        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

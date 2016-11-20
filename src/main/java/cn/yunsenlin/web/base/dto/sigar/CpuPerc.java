package cn.yunsenlin.web.base.dto.sigar;

public class CpuPerc {
    private double user;
    private double sys;
    private double wait;
    private double nice;
    private double idle;
    private double combined;

    public double getUser() {
        return user;
    }

    public void setUser(double user) {
        this.user = user;
    }

    public double getSys() {
        return sys;
    }

    public void setSys(double sys) {
        this.sys = sys;
    }

    public double getWait() {
        return wait;
    }

    public void setWait(double wait) {
        this.wait = wait;
    }

    public double getNice() {
        return nice;
    }

    public void setNice(double nice) {
        this.nice = nice;
    }

    public double getIdle() {
        return idle;
    }

    public void setIdle(double idle) {
        this.idle = idle;
    }

    public double getCombined() {
        return combined;
    }

    public void setCombined(double combined) {
        this.combined = combined;
    }

    public CpuPerc(double user, double sys, double wait, double nice, double idle, double combined) {
        this.user = user;
        this.sys = sys;
        this.wait = wait;
        this.nice = nice;
        this.idle = idle;
        this.combined = combined;
    }


}

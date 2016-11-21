package cn.yunsenlin.web.base.dto.calculate.android;

import java.util.Date;

public class BillKey {
    private Date time;
    private String token;

    public BillKey(Date time, String token) {
        this.time = time;
        this.token = token;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

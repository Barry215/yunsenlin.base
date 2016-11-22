package cn.yunsenlin.web.base.dto.calculate.android;

import java.util.Date;

public class BillKey {
    private Date time;
    private String token;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

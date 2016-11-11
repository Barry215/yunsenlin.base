package cn.yunsenlin.web.base.model;

import java.util.Date;

public class Session {
    private int userId;
    private String session = "";
    private String token = "";
    private Date tokenCreateTime = new Date();
    private Long tokenPeriod;

    public Date getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(Date tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    public Long getTokenPeriod() {
        return tokenPeriod;
    }

    public void setTokenPeriod(Long tokenPeriod) {
        this.tokenPeriod = tokenPeriod;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}

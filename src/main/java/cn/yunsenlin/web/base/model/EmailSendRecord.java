package cn.yunsenlin.web.base.model;

import java.util.Date;

public class EmailSendRecord {
    private Integer id;

    private String email;

    private String code;

    private Date time;

    public EmailSendRecord(String email, String code) {
        this.email = email;
        this.code = code;
        this.time = new Date();
    }

    public EmailSendRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
package cn.yunsenlin.web.base.model;

import java.util.Date;

public class PhoneSendRecord {
    private Integer id;

    private String phone;

    private String code;

    private Date time;

    public PhoneSendRecord(String phone, String code) {
        this.phone = phone;
        this.code = code;
        this.time = new Date();
    }

    public PhoneSendRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
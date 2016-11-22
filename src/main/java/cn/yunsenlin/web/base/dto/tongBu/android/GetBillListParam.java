package cn.yunsenlin.web.base.dto.tongBu.android;

public class GetBillListParam extends IndexReturn{
    private String token;
    private int userId;

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
}

package cn.yunsenlin.web.base.dto.calculate.android;

public class Validation extends EvaluateLogBase{
    private String num;
    private String type;
    private String piece;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}

package cn.yunsenlin.web.base.dto.calculate;

public class WoodBase {
    private String length;
    private String diameter;
    private String typeCode;
    private int num;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WoodBase{");
        sb.append("length='").append(length).append('\'');
        sb.append(", diameter='").append(diameter).append('\'');
        sb.append(", typeCode='").append(typeCode).append('\'');
        sb.append(", num=").append(num);
        sb.append('}');
        return sb.toString();
    }
}

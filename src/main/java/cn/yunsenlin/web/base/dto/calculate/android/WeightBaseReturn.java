package cn.yunsenlin.web.base.dto.calculate.android;

public class WeightBaseReturn {
    private String weight;
    private String error;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public WeightBaseReturn(String weight, String error) {
        this.weight = weight;
        this.error = error;
    }
}

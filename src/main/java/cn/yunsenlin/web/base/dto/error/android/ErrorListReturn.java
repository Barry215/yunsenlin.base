package cn.yunsenlin.web.base.dto.error.android;

import java.util.List;

public class ErrorListReturn {
    private List<ErrorParam> errorList;

    public List<ErrorParam> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorParam> errorList) {
        this.errorList = errorList;
    }
}

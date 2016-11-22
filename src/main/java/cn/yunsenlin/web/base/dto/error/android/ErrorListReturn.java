package cn.yunsenlin.web.base.dto.error.android;

import cn.yunsenlin.web.base.error.ErrorUtils;

import java.util.ArrayList;
import java.util.List;

public class ErrorListReturn {
    private List<ErrorParam> errorList = new ArrayList<>();

    public void add(ErrorUtils errorUtils){
        errorList.add(
                new ErrorParam(
                       errorUtils.errorCode,errorUtils.errorInfo
                )
        );
    }

    public List<ErrorParam> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorParam> errorList) {
        this.errorList = errorList;
    }
}

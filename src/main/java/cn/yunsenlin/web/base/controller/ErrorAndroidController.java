package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.error.android.ErrorListReturn;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Transactional
@RequestMapping("/android/error")
public class ErrorAndroidController {
    @RequestMapping(value = "/getErrorCodeList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ErrorListReturn getErrorCodeList() {
        return null;
    }
}

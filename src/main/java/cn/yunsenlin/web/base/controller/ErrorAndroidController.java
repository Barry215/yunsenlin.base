package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.error.android.ErrorListReturn;
import cn.yunsenlin.web.base.error.ErrorUtils;
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
        ErrorListReturn errorListReturn = new ErrorListReturn();
        errorListReturn.add(ErrorUtils.ErrorPhoneCode);
        errorListReturn.add(ErrorUtils.DataValid);
        errorListReturn.add(ErrorUtils.PhoneAlreadyHas);
        errorListReturn.add(ErrorUtils.NoLogin);
        errorListReturn.add(ErrorUtils.NoPhone);
        errorListReturn.add(ErrorUtils.PhoneMessageTooMuch);
        return null;
    }
}

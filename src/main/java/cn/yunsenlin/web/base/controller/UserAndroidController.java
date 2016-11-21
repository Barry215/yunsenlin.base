package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.ExecutionReturn;
import cn.yunsenlin.web.base.dto.user.LoginReturn;
import cn.yunsenlin.web.base.dto.user.android.CheckMobileParam;
import cn.yunsenlin.web.base.dto.user.android.LoginParam;
import cn.yunsenlin.web.base.dto.user.android.MobileParam;
import cn.yunsenlin.web.base.dto.user.android.SignInParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Transactional
@RequestMapping("/android/user")
public class UserAndroidController {
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LoginReturn login(LoginParam logBase) {
        return null;
    }
    @RequestMapping(value = "/sendMessageToSignIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn sendMessageToSignIn(MobileParam mobileParam) {
        return null;
    }
    @RequestMapping(value = "/checkCodeToSignIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn checkCodeToSignIn(CheckMobileParam mobileParam) {
        return null;
    }
    @RequestMapping(value = "/sendMessageToGetBackPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn sendMessageToGetBackPassword(MobileParam mobileParam) {
        return null;
    }
    @RequestMapping(value = "/checkCodeToGetBackPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn checkCodeToGetBackPassword(CheckMobileParam mobileParam) {
        return null;
    }
    @RequestMapping(value = "/signIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn signIn(SignInParam signInParam) {
        return null;
    }
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn resetPassword(SignInParam signInParam) {
        return null;
    }
}

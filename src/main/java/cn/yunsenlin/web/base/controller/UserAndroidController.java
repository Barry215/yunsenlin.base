package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.ExecutionReturn;
import cn.yunsenlin.web.base.dto.user.android.LoginInfoReturn;
import cn.yunsenlin.web.base.dto.user.android.CheckMobileParam;
import cn.yunsenlin.web.base.dto.user.android.LoginParam;
import cn.yunsenlin.web.base.dto.user.android.MobileParam;
import cn.yunsenlin.web.base.dto.user.android.SignInParam;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.OutLetService;
import cn.yunsenlin.web.base.service.SessionService;
import cn.yunsenlin.web.base.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Transactional
@RequestMapping("/android/user")
public class UserAndroidController {
    private final UserService userService;
    private final OutLetService outLetService;
    private final SessionService sessionService;
    private final Validator checkMobileParamValidator;
    private final Validator loginParamValidator;
    private final Validator mobileParamValidator;
    private final Validator signInParamValidator;

    public UserAndroidController(UserService userService,
                                 OutLetService outLetService,
                                 SessionService sessionService,
                                 Validator checkMobileParamValidator,
                                 Validator loginParamValidator,
                                 Validator mobileParamValidator,
                                 Validator signInParamValidator) {
        this.userService = userService;
        this.outLetService = outLetService;
        this.sessionService = sessionService;
        this.checkMobileParamValidator = checkMobileParamValidator;
        this.loginParamValidator = loginParamValidator;
        this.mobileParamValidator = mobileParamValidator;
        this.signInParamValidator = signInParamValidator;
    }
    @InitBinder(value = "loginParam")
    public void loginParamValidator(DataBinder binder) {
        binder.addValidators(loginParamValidator);
    }
    @InitBinder(value = "mobileParam")
    public void mobileParamValidator(DataBinder binder) {
        binder.addValidators(mobileParamValidator);
    }
    @InitBinder(value = "checkMobileParam")
    public void checkMobileParamValidator(DataBinder binder) {
        binder.addValidators(checkMobileParamValidator);
    }
    @InitBinder(value = "signInParam")
    public void logBaseValidator(DataBinder binder) {
        binder.addValidators(signInParamValidator);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LoginInfoReturn login(LoginParam loginParam, BindingResult result) {
        if (result.hasErrors()){
            return new LoginInfoReturn(
                    "", ErrorUtils.DataValid.getErrorCode(),""
            );
        }
        if(userService.login(
                loginParam.getLoginName(),loginParam.getPassword()
        )
        ){
            User user = userService.loginToGetUser(
                    loginParam.getLoginName(),loginParam.getPassword()
            );
            String token = sessionService.createToken(user.getUserId(),6048000000L);
            return new LoginInfoReturn(
                    token,"0",user.getUserId()+""
            );
        }
        return new LoginInfoReturn(
                "",ErrorUtils.NoLogin.getErrorCode(),""
        );
    }
    @RequestMapping(value = "/sendMessageToSignIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn sendMessageToSignIn(MobileParam mobileParam,BindingResult result) {
        if (result.hasErrors()){
            return new ExecutionReturn(
                    ErrorUtils.DataValid.getErrorCode()
            );
        }
        if (userService.hasPhone(mobileParam.getMobile())){
            return new ExecutionReturn(
                    ErrorUtils.PhoneAlreadyHas.getErrorCode()
            );
        }
        if(outLetService.sendPhone(mobileParam.getMobile())){
            return new ExecutionReturn("0");
        }else {
            return new ExecutionReturn(
                    ErrorUtils.PhoneMessageTooMuch.getErrorCode()
            );
        }
    }
    @RequestMapping(value = "/checkCodeToSignIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn checkCodeToSignIn(CheckMobileParam checkMobileParam,BindingResult result) {
        if (result.hasErrors()){
            return new ExecutionReturn(
                    ErrorUtils.DataValid.getErrorCode()
            );
        }
        if (outLetService.checkPhoneCode(checkMobileParam
        .getCode(),checkMobileParam.getMobile())){
            return new ExecutionReturn("0");
        }
        return new ExecutionReturn(
                ErrorUtils.ErrorPhoneCode.getErrorCode()
        );
    }
    @RequestMapping(value = "/sendMessageToGetBackPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn sendMessageToGetBackPassword(MobileParam mobileParam,BindingResult result) {
        if (result.hasErrors()){
            return new ExecutionReturn(
                    ErrorUtils.DataValid.getErrorCode()
            );
        }
        if (!userService.hasPhone(mobileParam.getMobile())){
            return new ExecutionReturn(
                    ErrorUtils.NoPhone.getErrorCode()
            );
        }
        if(outLetService.sendPhone(mobileParam.getMobile())){
            return new ExecutionReturn("0");
        }else {
            return new ExecutionReturn(
                    ErrorUtils.PhoneMessageTooMuch.getErrorCode()
            );
        }
    }
    @RequestMapping(value = "/checkCodeToGetBackPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn checkCodeToGetBackPassword(CheckMobileParam checkMobileParam,BindingResult result) {
        if (result.hasErrors()){
            return new ExecutionReturn(
                    ErrorUtils.DataValid.getErrorCode()
            );
        }
        if (outLetService.checkPhoneCode(checkMobileParam
                .getCode(),checkMobileParam.getMobile())){
            return new ExecutionReturn("0");
        }
        return new ExecutionReturn(
                ErrorUtils.ErrorPhoneCode.getErrorCode()
        );
    }
    @RequestMapping(value = "/signIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn signIn(SignInParam signInParam,BindingResult result) {
        if (result.hasErrors()){
            return new ExecutionReturn(
                    ErrorUtils.DataValid.getErrorCode()
            );
        }
        if (outLetService.checkPhoneCode(signInParam
                .getCode(),signInParam.getMobile())){
            return new ExecutionReturn("0");
        }
        User user = new User(
                signInParam.getMobile(),signInParam.getPassword()
        );
        userService.signIn(user);
        return new ExecutionReturn("0");
    }
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn resetPassword(SignInParam signInParam,BindingResult result) {
        if (result.hasErrors()){
            return new ExecutionReturn(
                    ErrorUtils.DataValid.getErrorCode()
            );
        }
        if (outLetService.checkPhoneCode(signInParam
                .getCode(),signInParam.getMobile())){
            return new ExecutionReturn("0");
        }
        userService.modifyPasswordByPhone(
                signInParam.getMobile(),signInParam.getPassword()
        );
        return new ExecutionReturn("0");
    }
}

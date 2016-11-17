package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.user.*;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.RegxFactory;
import cn.yunsenlin.web.base.factory.TokenNameFactory;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.OutLetService;
import cn.yunsenlin.web.base.service.SessionService;
import cn.yunsenlin.web.base.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Transactional
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final SessionService sessionService;
    private final Validator loginParamValidator;
    private final Validator hasPhoneParamValidator;
    private final Validator hasEmailParamValidator;
    private final Validator sendEmailParamValidator;
    private final Validator sendPhoneParamValidator;
    private final Validator signInParamValidator;
    private final OutLetService outLetService;

    public UserController(UserService userService, SessionService sessionService, Validator loginParamValidator, Validator hasPhoneParamValidator, Validator hasEmailParamValidator, Validator sendEmailParamValidator, Validator sendPhoneParamValidator, Validator signInParamValidator, OutLetService outLetService) {
        this.userService = userService;
        this.sessionService = sessionService;
        this.loginParamValidator = loginParamValidator;
        this.hasPhoneParamValidator = hasPhoneParamValidator;
        this.hasEmailParamValidator = hasEmailParamValidator;
        this.sendEmailParamValidator = sendEmailParamValidator;
        this.sendPhoneParamValidator = sendPhoneParamValidator;
        this.signInParamValidator = signInParamValidator;
        this.outLetService = outLetService;
    }

    @InitBinder(value = "loginParam")
    public void initLoginParamValidator(DataBinder binder) {
        binder.addValidators(loginParamValidator);
    }

    @InitBinder(value = "hasPhoneParam")
    public void initHasPhoneParamValidator(DataBinder binder) {
        binder.addValidators(hasPhoneParamValidator);
    }

    @InitBinder(value = "hasEmailParam")
    public void initHasEmailParamValidator(DataBinder binder) {
        binder.addValidators(hasEmailParamValidator);
    }

    @InitBinder(value = "sendEmailParam")
    public void initSendEmailParamValidator(DataBinder binder){
        binder.addValidators(sendEmailParamValidator);
    }

    @InitBinder(value = "sendPhoneParam")
    public void initSendPhoneParamValidator(DataBinder binder){
        binder.addValidators(sendPhoneParamValidator);
    }

    @InitBinder(value = "signInParam")
    public void initSignInParamValidator(DataBinder binder){
        binder.addValidators(signInParamValidator);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LoginReturn login(
            @Valid @RequestBody LoginParam loginParam, BindingResult result) {
        if (result.hasErrors()) {
            return new LoginReturn("",
                    ErrorUtils.DataValid.getErrorCode(), -1
            );
        }
        String loginName = loginParam.getLoginName();
        String password = loginParam.getPassword();
        boolean remember = loginParam.isRemember();
        if (userService.login(loginName, password)) {
            User user = userService.loginToGetUser(loginName, password);
            String token;
            if (remember) {
                token = sessionService.createToken(user.getUserId(), RegxFactory.rememberTokenLong);
                sessionService.insert(token, user, user, TokenNameFactory.loginState);
            } else {
                token = sessionService.createToken(user.getUserId(), RegxFactory.tokenLong);
                sessionService.insert(token, user, user, TokenNameFactory.loginState);
            }
            return new LoginReturn(token, "0", user.getUserId());
        } else {
            return new LoginReturn("", ErrorUtils.NoLogin.getErrorCode(), -1);
        }
    }

    @RequestMapping(value = "/hasPhone", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public HasPhoneReturn hasPhone(@Valid @RequestBody HasPhoneParam hasPhoneParam, BindingResult result) {
        if (result.hasErrors()) {
            return new HasPhoneReturn(true, ErrorUtils.EmailAlreadyHas.getErrorCode());
        } else {
            String phone = hasPhoneParam.getPhone();
            boolean has = userService.hasPhone(phone);
            return new HasPhoneReturn(has, "0");
        }
    }

    @RequestMapping(value = "/hasEmail", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public HasEmailReturn hasEmail(@Valid @RequestBody HasEmailParam hasEmailParam, BindingResult result) {
        if (result.hasErrors()) {
            return new HasEmailReturn(true, ErrorUtils.PhoneAlreadyHas.getErrorCode());
        } else {
            String email = hasEmailParam.getEmail();
            boolean has = userService.hasEmail(email);
            return new HasEmailReturn(has, "0");
        }
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SignInReturn SignIn(@Valid @RequestBody SignInParam signInParam, BindingResult result) {
        if (result.hasErrors()){
            return new SignInReturn(ErrorUtils.DataValid.getErrorCode());
        }
        String phone = signInParam.getPhone();
        String phoneCode = signInParam.getPhoneCode();
        String password = signInParam.getPassword();
        String email = signInParam.getEmail();
        String emailCode = signInParam.getEmailCode();
        if (!outLetService.checkPhoneCode(phoneCode,phone)){
            return new SignInReturn(ErrorUtils.ErrorPhoneCode.getErrorCode());
        }
        if (email==null||email.length()==0){
            if (!outLetService.checkEmailCode(emailCode,email)){
                return new SignInReturn(ErrorUtils.ErrorEmailCode.getErrorCode());
            }
            User user = new User(password,password);
            userService.signIn(user);
        }else{
            User user = new User(email,phone,password);
            userService.signIn(user);
        }
        return new SignInReturn("0");
    }

    @RequestMapping(value = "/sendEmailToSignIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SendEmailReturn sendEmailToSignIn(
            @Valid @RequestBody SendEmailParam sendEmailParam, BindingResult result) {
        if (result.hasErrors()){
            return new SendEmailReturn(ErrorUtils.DataValid.getErrorCode(),
                    false);
        }
        String email = sendEmailParam.getEmail();
        if (userService.hasEmail(email)){
            return new SendEmailReturn(ErrorUtils.EmailAlreadyHas.getErrorCode(),
                    false);
        }
        return new SendEmailReturn("0",outLetService.sendEmail(email));
    }

    @RequestMapping(value = "/sendPhoneToSignIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SendPhoneReturn sendPhoneToSignIn(
            @Valid @RequestBody SendPhoneParam sendPhoneParam, BindingResult result) {
        if (result.hasErrors()){
            return new SendPhoneReturn(ErrorUtils.DataValid.getErrorCode(),
                    false);
        }
        String phone = sendPhoneParam.getPhone();
        if (userService.hasPhone(phone)){
            return new SendPhoneReturn(ErrorUtils.PhoneAlreadyHas.getErrorCode(),
                    false);
        }
        return new SendPhoneReturn("0",outLetService.sendPhone(phone));
    }

    @RequestMapping(value = "/sendEmailToRepassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SendEmailReturn sendEmailToRepassword(
            @Valid @RequestBody SendEmailParam sendEmailParam, BindingResult result) {
        if (result.hasErrors()){
            return new SendEmailReturn(ErrorUtils.DataValid.getErrorCode(),
                    false);
        }
        String email = sendEmailParam.getEmail();
        if (!userService.hasEmail(email)){
            return new SendEmailReturn(ErrorUtils.NoEmail.getErrorCode(),
                    false);
        }
        return new SendEmailReturn("0",outLetService.sendEmail(email));
    }

    @RequestMapping(value = "/sendPhoneToRepassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SendPhoneReturn sendPhoneToRepassword(
            @Valid @RequestBody SendPhoneParam sendPhoneParam, BindingResult result) {
        if (result.hasErrors()){
            return new SendPhoneReturn(ErrorUtils.DataValid.getErrorCode(),
                    false);
        }
        String phone = sendPhoneParam.getPhone();
        if (!userService.hasPhone(phone)){
            return new SendPhoneReturn(ErrorUtils.NoPhone.getErrorCode(),
                    false);
        }
        return new SendPhoneReturn("0",outLetService.sendPhone(phone));
    }
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LoginOutReturn loginOut(loginOutParam loginOutParam){
        sessionService.deleteToken(loginOutParam.getUserId());
        return new LoginOutReturn("0");
    }
}

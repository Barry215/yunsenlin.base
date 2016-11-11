package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.user.*;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.factory.TokenNameFactory;
import cn.yunsenlin.web.base.model.User;
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

    public UserController(UserService userService, SessionService sessionService, Validator loginParamValidator, Validator hasPhoneParamValidator, Validator hasEmailParamValidator) {
        this.userService = userService;
        this.sessionService = sessionService;
        this.loginParamValidator = loginParamValidator;
        this.hasPhoneParamValidator = hasPhoneParamValidator;
        this.hasEmailParamValidator = hasEmailParamValidator;
    }
    @InitBinder(value="loginParam")
    public void initLoginParamValidator(DataBinder binder){
        binder.addValidators(loginParamValidator);
    }

    @InitBinder(value = "hasPhoneParam")
    public void initHasPhoneParamValidator(DataBinder binder){
        binder.addValidators(hasPhoneParamValidator);
    }
    @InitBinder(value = "hasEmailParam")
    public void initHasEmailParamValidator(DataBinder binder){
        binder.addValidators(hasEmailParamValidator);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LoginReturn login(
            @Valid @RequestBody LoginParam loginParam, BindingResult result){
        if (result.hasErrors()){
            return new LoginReturn("",
                    result.getAllErrors().toString(),-1
            );
        }
        String loginName = loginParam.getLoginName();
        String password = loginParam.getPassword();
        boolean remember = loginParam.isRemember();
        if (userService.login(loginName,password)){
            User user = userService.loginToGetUser(loginName,password);
            String token;
            if (remember){
                token =sessionService.createToken(user.getUserId(),604800000L);
                sessionService.insert(token,user,user, TokenNameFactory.loginState);
            }else{
                token =sessionService.createToken(user.getUserId(),18000000L);
                sessionService.insert(token,user,user, TokenNameFactory.loginState);
            }
            return new  LoginReturn(token,"0",user.getUserId());
        }else{
            return new LoginReturn("", ErrorUtils.NoLogin.toString(),-1);
        }
    }
    @RequestMapping(value = "/hasPhone", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public HasPhoneReturn hasPhone(@Valid @RequestBody HasPhoneParam hasPhoneParam, BindingResult result){
        if (result.hasErrors()){
            return new HasPhoneReturn(true,ErrorUtils.EmailAlreadyHas.getErrorCode());
        }else{
            String phone = hasPhoneParam.getPhone();
            boolean has = userService.hasPhone(phone);
            return new HasPhoneReturn(has,"0");
        }
    }
    @RequestMapping(value = "/hasEmail", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public HasEmailReturn hasEmail(@Valid @RequestBody HasEmailParam hasEmailParam, BindingResult result){
        if (result.hasErrors()){
            return new HasEmailReturn(true,ErrorUtils.PhoneAlreadyHas.getErrorCode());
        }else{
            String email = hasEmailParam.getEmail();
            boolean has = userService.hasEmail(email);
            return new HasEmailReturn(has,"0");
        }
    }
    @RequestMapping(value = "/signIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SignInReturn SignIn(@Valid @RequestBody SignInParam signInParam,BindingResult result){
        return null;
    }
}

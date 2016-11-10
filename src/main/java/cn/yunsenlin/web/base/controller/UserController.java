package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.user.LoginParam;
import cn.yunsenlin.web.base.dto.user.LoginReturn;
import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.model.User;
import cn.yunsenlin.web.base.service.SessionService;
import cn.yunsenlin.web.base.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

public class UserController {
    private final UserService userService;
    private final SessionService sessionService;
    private final Validator loginParamValidator;

    public UserController(UserService userService, SessionService sessionService, Validator loginParamValidator) {
        this.userService = userService;
        this.sessionService = sessionService;
        this.loginParamValidator = loginParamValidator;
    }
    @InitBinder(value="loginParamValidator")
    public void initLoginParamValidator(DataBinder binder){
        binder.addValidators(loginParamValidator);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LoginReturn login(
            @Valid LoginParam loginParamValidator, BindingResult result){
        if (result.hasErrors()){
            return new LoginReturn("",
                    result.getAllErrors().toString()
            );
        }
        String loginName = loginParamValidator.getLoginName();
        String password = loginParamValidator.getPassword();
        boolean remember = loginParamValidator.isRemember();
        if (userService.login(loginName,password)){
            User user = userService.loginToGetUser(loginName,password);
            String token =sessionService.createToken(user.getUserId());
            return new  LoginReturn(token,"0");
        }else{
            return new LoginReturn("", ErrorUtils.NoLogin.toString());
        }
    }
}

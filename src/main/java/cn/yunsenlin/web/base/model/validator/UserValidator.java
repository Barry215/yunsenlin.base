package cn.yunsenlin.web.base.model.validator;


import cn.yunsenlin.web.base.error.ErrorUtils;
import cn.yunsenlin.web.base.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        String errorCode = ErrorUtils.DataValid.getErrorCode();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userId", errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email",errorCode);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password",errorCode);
        User user = (User) target;
        if (!user.getEmail().matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$")){
            errors.rejectValue("email",errorCode);
        }
        String phone = user.getPhone();
        if (phone.length()>0&&!phone.matches("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\\\d{8}")){
            errors.rejectValue("phone",errorCode);
        }
    }
}

package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.CalculateMoreReturn;
import cn.yunsenlin.web.base.dto.tongBu.android.*;
import cn.yunsenlin.web.base.model.BillUserRecordKey;
import cn.yunsenlin.web.base.service.SessionService;
import cn.yunsenlin.web.base.service.UserRecordSaveService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RequestMapping("/android/tongBu")
public class TongBuAndroidController {
    private final Validator tokenParamValidator;
    private final Validator getBillListParamValidator;
    private final UserRecordSaveService userRecordSaveService;
    private final SessionService sessionService;
    public TongBuAndroidController(Validator tokenParamValidator, Validator getBillListParamValidator, UserRecordSaveService userRecordSaveService, SessionService sessionService) {
        this.tokenParamValidator = tokenParamValidator;
        this.getBillListParamValidator = getBillListParamValidator;
        this.userRecordSaveService = userRecordSaveService;
        this.sessionService = sessionService;
    }
    @InitBinder(value = "tokenParam")
    public void loginParamValidator(DataBinder binder) {
        binder.addValidators(tokenParamValidator);
    }
    @InitBinder(value = "getBillListParam")
    public void mobileParamValidator(DataBinder binder) {
        binder.addValidators(getBillListParamValidator);
    }

    @RequestMapping(value = "/getBillIndex", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public IndexReturn getBillIndex(@RequestBody @Valid TokenParam tokenParam) {
        if (sessionService.checkToken(
                tokenParam.getToken(),tokenParam.getUserId()
        )) {
            return userRecordSaveService.getIndexReturn(tokenParam.getUserId());
        }
        else{
            return new IndexReturn();
        }
    }
    @RequestMapping(value = "/getBillList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BillListReturn getBillList(@RequestBody @Valid GetBillListParam getBillListParam) {
        if (sessionService.checkToken(
                getBillListParam.getToken(),getBillListParam.getUserId()
        )) {
            List<CalculateMoreReturn> billList = new ArrayList<>();
            List<TimeIndex> timeIndexList = getBillListParam.getIndexList();
            for (TimeIndex t :
                    timeIndexList) {
                BillUserRecordKey key = new BillUserRecordKey();
                key.setUserid(getBillListParam.getUserId());
                key.setTime(t.getTime());
                CalculateMoreReturn c =userRecordSaveService.get(key);
                billList.add(c);
            }
            return new BillListReturn(billList);
        }
        return new BillListReturn();
    }
}

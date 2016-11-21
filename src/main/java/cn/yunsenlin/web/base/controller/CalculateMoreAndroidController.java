package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Transactional
@RequestMapping("/android/calculateMore")
public class CalculateMoreAndroidController {
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CalculateMoreReturn index(CalculateMore calculateMore) {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ExecutionReturn index(BillKey billKey) {
        return null;
    }
}

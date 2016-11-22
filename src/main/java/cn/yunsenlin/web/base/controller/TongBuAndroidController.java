package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.tongBu.android.BillListReturn;
import cn.yunsenlin.web.base.dto.tongBu.android.IndexReturn;
import cn.yunsenlin.web.base.dto.tongBu.android.TokenParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Transactional
@RequestMapping("/android/tongBu")
public class TongBuAndroidController {
    @RequestMapping(value = "/getBillIndex", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public IndexReturn getBillIndex(TokenParam tokenParam) {
        return null;
    }
    @RequestMapping(value = "/getBillList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BillListReturn getBillList(IndexReturn indexReturn) {
        return null;
    }
}

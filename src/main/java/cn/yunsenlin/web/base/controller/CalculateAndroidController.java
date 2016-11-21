package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RequestMapping("/android/calculate")
public class CalculateAndroidController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/log2013", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn log2013(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/log1984", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn log1984(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/russianLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn russianLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/americanLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn americanLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/southeastAsiaLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn southeastAsiaLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/mineLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn mineLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/purlinLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn purlinLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/rafterLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn rafterLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/boleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn boleLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/smallBoleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn smallBoleLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/shanBoleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn shanBoleLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/pinusBoleLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn pinusBoleLog(LogBase logBase) {
        return null;
    }

    @RequestMapping(value = "/weightLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public WeightBaseReturn weightLog(WeightBase weightBase) {
        return null;
    }

    @RequestMapping(value = "/timber", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn timber(TimberBase timberBase) {
        return null;
    }

    @RequestMapping(value = "/getCityList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CityListReturn getCityList() {
        return null;
    }

    @RequestMapping(value = "/getValuateLogListByXiongJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public EvaluatedLogTypeListReturn getValuateLogListByXiongJing() {
        return null;
    }

    @RequestMapping(value = "/getValuateLogListByGenJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public EvaluatedLogTypeListReturn getValuateLogListByGenJing() {
        return null;
    }

    @RequestMapping(value = "/valuateLogByGenJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn valuateLogByGenJing(EvaluateLogBase evaluateLogBase) {
        return null;
    }

    @RequestMapping(value = "/valuateLogByXiongJing", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public LogBaseReturn valuateLogByXiongJing(EvaluateLogBase evaluateLogBase) {
        return null;
    }

}

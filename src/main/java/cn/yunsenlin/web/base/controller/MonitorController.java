package cn.yunsenlin.web.base.controller;

import cn.yunsenlin.web.base.service.SigarService;
import org.hyperic.sigar.SigarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.net.UnknownHostException;

@Transactional
@RequestMapping("/monitor")
public class MonitorController {
    private final SigarService sigarService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MonitorController(SigarService sigarService) {
        this.sigarService = sigarService;
    }

    @RequestMapping(value="/monitor")
    public String hello(ModelMap modelMap){
        try {
            modelMap.put("who",sigarService.getWho());
            modelMap.put("net",sigarService.getNet());
            modelMap.put("os",sigarService.getOs());
            modelMap.put("javaP",sigarService.getJavaProperty());
            modelMap.put("ethernet",sigarService.getEthernet());
            modelMap.put("disk",sigarService.getDisk());
            modelMap.put("memory",sigarService.getMemory());
            modelMap.put("cpu",sigarService.getCpu());
        } catch ( SigarException|UnknownHostException e) {
            logger.error(e.getMessage());
        }
        return "monitor";
    }

}

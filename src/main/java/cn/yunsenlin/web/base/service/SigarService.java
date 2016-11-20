package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.dto.sigar.*;
import org.hyperic.sigar.SigarException;

import java.net.UnknownHostException;
import java.util.List;

public interface SigarService {
    List<Cpu> getCpu() throws SigarException;
    List<Net> getNet() throws SigarException;
    List<Ethernet> getEthernet() throws SigarException;
    Os getOs();
    List<Who> getWho() throws SigarException;
    List<Disk> getDisk() throws SigarException;
    Memory getMemory() throws SigarException;
    JavaProperty getJavaProperty() throws UnknownHostException;
}

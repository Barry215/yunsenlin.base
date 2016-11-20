package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dto.sigar.*;
import cn.yunsenlin.web.base.dto.sigar.Cpu;
import cn.yunsenlin.web.base.dto.sigar.Who;
import cn.yunsenlin.web.base.service.SigarService;
import org.hyperic.sigar.*;
import org.hyperic.sigar.CpuPerc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class SigarServiceImpl implements SigarService {
    @Override
    public List<Cpu> getCpu() throws SigarException {
        Sigar sigar = new Sigar();
        CpuInfo cpuInfoList[] = sigar.getCpuInfoList();
        CpuPerc cpuPercs[] = sigar.getCpuPercList();
        List<Cpu> cpuList = new ArrayList<>();
        for (int i = 0; i < cpuInfoList.length; i++) {
            CpuInfo info = cpuInfoList[i];
            Cpu cpu = new Cpu(
                    info.getMhz(),
                    info.getVendor(),
                    info.getModel(),
                    info.getCacheSize()
            );
            CpuPerc cpuPerc = cpuPercs[i];
            cpu.setCpuPerc(
                    new cn.yunsenlin.web.base.dto.sigar.CpuPerc(
                            cpuPerc.getUser(),
                            cpuPerc.getSys(),
                            cpuPerc.getWait(),
                            cpuPerc.getNice(),
                            cpuPerc.getIdle(),
                            cpuPerc.getCombined()
                    )
            );
            cpuList.add(cpu);
        }
        return cpuList;
    }

    @Override
    public List<Net> getNet() throws SigarException {
        Sigar sigar = new Sigar();
        String ifNames[] = sigar.getNetInterfaceList();
        List<Net> netList = new ArrayList<>();
        for (String name : ifNames) {
            NetInterfaceConfig ifConfig = sigar.getNetInterfaceConfig(name);
            Net net = new Net(
                    name,
                    ifConfig.getAddress(),
                    ifConfig.getNetmask()
            );
            if ((ifConfig.getFlags() & 1L) <= 0L) {
                continue;
            }
            NetInterfaceStat ifStat = sigar.getNetInterfaceStat(name);
            net.setRxPackets(ifStat.getRxPackets());
            net.setTxPackets(ifStat.getTxPackets());
            net.setRxBytes(ifStat.getRxBytes());
            net.setTxBytes(ifStat.getTxBytes());
            net.setRxErrors(ifStat.getRxErrors());
            net.setTxErrors(ifStat.getTxErrors());
            net.setRxDropped(ifStat.getRxDropped());
            net.setTxDropped(ifStat.getTxDropped());
            netList.add(net);
        }
        return netList;
    }

    @Override
    public List<Ethernet> getEthernet() throws SigarException {
        Sigar sigar;
        sigar = new Sigar();
        String[] iFaces = sigar.getNetInterfaceList();
        List<Ethernet> ethernetList = new ArrayList<>();
        for (String iFace : iFaces) {
            Ethernet ethernet = new Ethernet();
            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(iFace);
            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                continue;
            }
            ethernet.setAddress(cfg.getAddress());
            ethernet.setBroadCast(cfg.getBroadcast());
            ethernet.setMac(cfg.getHwaddr());
            ethernet.setNetMask(cfg.getNetmask());
            ethernet.setDescription(cfg.getDescription());
            ethernet.setType(cfg.getType());
            ethernetList.add(ethernet);
        }
        return ethernetList;
    }

    @Override
    public Os getOs() {
        OperatingSystem OS = OperatingSystem.getInstance();
        return new Os(
                OS.getArch(),
                OS.getCpuEndian(),
                OS.getDataModel(),
                OS.getDescription(),
                OS.getName(),
                OS.getPatchLevel(),
                OS.getVendor(),
                OS.getVendorCodeName(),
                OS.getVendorName(),
                OS.getVendorVersion(),
                OS.getVersion()
        );
    }

    @Override
    public List<Who> getWho() throws SigarException {
        Sigar sigar = new Sigar();
        List<Who> whoList = new ArrayList<>();
        org.hyperic.sigar.Who[] who = sigar.getWhoList();
        if (who != null && who.length > 0) {
            for (org.hyperic.sigar.Who _who : who) {
                Who who1 = new Who(
                        _who.getDevice(),
                        _who.getHost(),
                        _who.getTime(),
                        _who.getUser()
                );
                whoList.add(who1);
            }
        }
        return whoList;
    }

    @Override
    public List<Disk> getDisk() throws SigarException {
        Sigar sigar = new Sigar();
        FileSystem fsList[] = sigar.getFileSystemList();
        List<Disk> diskList = new ArrayList<>();
        for (FileSystem fs : fsList) {
            // 分区的盘符名称
            Disk disk = new Disk(
                    fs.getDevName(),
                    fs.getDirName(),
                    fs.getFlags(),
                    fs.getSysTypeName(),
                    fs.getTypeName(),
                    fs.getType()
            );
            FileSystemUsage usage;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    disk.setTotal(usage.getTotal());
                    disk.setFree(usage.getFree());
                    disk.setAvail(usage.getAvail());
                    disk.setUsed(usage.getUsed());
                    disk.setDiskReads(usage.getDiskReads());
                    disk.setDiskWrites(usage.getDiskWrites());
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }
            diskList.add(disk);
        }
        return diskList;
    }

    @Override
    public Memory getMemory() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        Swap swap = sigar.getSwap();
        return new Memory(
                mem.getTotal() / 1024L,
                mem.getUsed() / 1024L,
                mem.getFree() / 1024L,
                swap.getTotal() / 1024L,
                swap.getUsed() / 1024L,
                swap.getFree() / 1024L
        );
    }

    @Override
    public JavaProperty getJavaProperty() throws UnknownHostException {
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
        JavaProperty javaProperty = new JavaProperty();
        javaProperty.setUserName(userName);
        javaProperty.setComputerName(computerName);
        javaProperty.setUserDomain(userDomain);
        javaProperty.setIp(ip);
        javaProperty.setAddr_getHostName(addr.getHostName());
        javaProperty.setR_totalMemory(r.totalMemory());
        javaProperty.setR_freeMemory(r.freeMemory());
        javaProperty.setR_availableProcessors(r.availableProcessors());
        javaProperty.setJava_version(props.getProperty("java.version"));
        javaProperty.setJava_vendor(props.getProperty("java.vendor"));
        javaProperty.setJava_vendor_url(props.getProperty("java.vendor.url"));
        javaProperty.setJava_home(props.getProperty("java.home"));
        javaProperty.setJava_vm_specification_version(props.getProperty("java.vm.specification.version"));
        javaProperty.setJava_vm_specification_name(props.getProperty("java.vm.specification.name"));
        javaProperty.setJava_vm_specification_vendor(props.getProperty("java.vm.specification.vendor"));
        javaProperty.setJava_vm_version(props.getProperty("java.vm.version"));
        javaProperty.setJava_vm_vendor(props.getProperty("java.vm.vendor"));
        javaProperty.setJava_vm_name(props.getProperty("java.vm.name"));
        javaProperty.setJava_specification_name(props.getProperty("java.specification.name"));
        javaProperty.setJava_specification_vender(props.getProperty("java.specification.vender"));
        javaProperty.setJava_specification_version(props.getProperty("java.specification.version"));
        javaProperty.setJava_class_version(props.getProperty("java.class.version"));
        javaProperty.setJava_class_path(props.getProperty("java.class.path"));
        javaProperty.setJava_library_path(props.getProperty("java.library.path"));
        javaProperty.setJava_io_tmpdir(props.getProperty("java.io.tmpdir"));
        javaProperty.setJava_ext_dirs(props.getProperty("java.ext.dirs"));
        javaProperty.setOs_name(props.getProperty("os.name"));
        javaProperty.setOs_arch(props.getProperty("os.arch"));
        javaProperty.setOs_version(props.getProperty("os.version"));
        javaProperty.setFile_separator(props.getProperty("file.separator"));
        javaProperty.setPath_separator(props.getProperty("path.separator"));
        javaProperty.setLine_separator(props.getProperty("line.separator"));
        javaProperty.setUser_name(props.getProperty("user.name"));
        javaProperty.setUser_home(props.getProperty("user.home"));
        javaProperty.setUser_dir(props.getProperty("user.dir"));
        return javaProperty;
    }
}

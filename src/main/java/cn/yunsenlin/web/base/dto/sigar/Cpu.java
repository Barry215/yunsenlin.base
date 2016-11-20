package cn.yunsenlin.web.base.dto.sigar;

public class Cpu {
    private int mhz;
    private String vendor;
    private String model;
    private Long cacheSize;
    private CpuPerc cpuPerc;

    public CpuPerc getCpuPerc() {
        return cpuPerc;
    }

    public void setCpuPerc(CpuPerc cpuPerc) {
        this.cpuPerc = cpuPerc;
    }

    public int getMhz() {
        return mhz;
    }

    public void setMhz(int mhz) {
        this.mhz = mhz;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Long cacheSize) {
        this.cacheSize = cacheSize;
    }

    public Cpu(int mhz, String vendor, String model, Long cacheSize) {
        this.mhz = mhz;
        this.vendor = vendor;
        this.model = model;
        this.cacheSize = cacheSize;
    }

}

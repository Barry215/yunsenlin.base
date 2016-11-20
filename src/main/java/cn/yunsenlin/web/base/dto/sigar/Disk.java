package cn.yunsenlin.web.base.dto.sigar;

public class Disk {
    private String devName;
    private String dirName;
    private Long flags;
    private String sysTypeName;
    private String typeName;
    private int type;
    private Long total;
    private Long used;
    private Long free;
    private Long avail;
    private double percent;
    private Long diskReads;
    private Long diskWrites;

    public Disk(String devName, String dirName, Long flags, String sysTypeName, String typeName, int type) {
        this.devName = devName;
        this.dirName = dirName;
        this.flags = flags;
        this.sysTypeName = sysTypeName;
        this.typeName = typeName;
        this.type = type;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public Long getFlags() {
        return flags;
    }

    public void setFlags(Long flags) {
        this.flags = flags;
    }

    public String getSysTypeName() {
        return sysTypeName;
    }

    public void setSysTypeName(String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;
    }

    public Long getFree() {
        return free;
    }

    public void setFree(Long free) {
        this.free = free;
    }

    public Long getAvail() {
        return avail;
    }

    public void setAvail(Long avail) {
        this.avail = avail;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Long getDiskReads() {
        return diskReads;
    }

    public void setDiskReads(Long diskReads) {
        this.diskReads = diskReads;
    }

    public Long getDiskWrites() {
        return diskWrites;
    }

    public void setDiskWrites(Long diskWrites) {
        this.diskWrites = diskWrites;
    }

}

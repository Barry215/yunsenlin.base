package cn.yunsenlin.web.base.dto.sigar;

public class Os {
    private String arch;
    private String cpuEndian;
    private String dataModel;
    private String description;
    private String name;
    private String patchLevel;
    private String vendor;
    private String vendorCodeName;
    private String vendorName;
    private String vendorVersion;
    private String version;

    public Os(String arch, String cpuEndian, String dataModel, String description, String name, String patchLevel, String vendor, String vendorCodeName, String vendorName, String vendorVersion, String version) {
        this.arch = arch;
        this.cpuEndian = cpuEndian;
        this.dataModel = dataModel;
        this.description = description;
        this.name = name;
        this.patchLevel = patchLevel;
        this.vendor = vendor;
        this.vendorCodeName = vendorCodeName;
        this.vendorName = vendorName;
        this.vendorVersion = vendorVersion;
        this.version = version;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getCpuEndian() {
        return cpuEndian;
    }

    public void setCpuEndian(String cpuEndian) {
        this.cpuEndian = cpuEndian;
    }

    public String getDataModel() {
        return dataModel;
    }

    public void setDataModel(String dataModel) {
        this.dataModel = dataModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatchLevel() {
        return patchLevel;
    }

    public void setPatchLevel(String patchLevel) {
        this.patchLevel = patchLevel;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorCodeName() {
        return vendorCodeName;
    }

    public void setVendorCodeName(String vendorCodeName) {
        this.vendorCodeName = vendorCodeName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorVersion() {
        return vendorVersion;
    }

    public void setVendorVersion(String vendorVersion) {
        this.vendorVersion = vendorVersion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

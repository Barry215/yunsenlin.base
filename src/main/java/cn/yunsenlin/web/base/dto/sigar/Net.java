package cn.yunsenlin.web.base.dto.sigar;

public class Net {
    private String name;
    private String address;
    private String netMask;
    private Long rxPackets;
    private Long txPackets;
    private Long rxBytes;
    private Long txBytes;
    private Long rxErrors;
    private Long txErrors;
    private Long rxDropped;
    private Long txDropped;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNetMask() {
        return netMask;
    }

    public void setNetMask(String netMask) {
        this.netMask = netMask;
    }

    public Long getRxPackets() {
        return rxPackets;
    }

    public void setRxPackets(Long rxPackets) {
        this.rxPackets = rxPackets;
    }

    public Long getTxPackets() {
        return txPackets;
    }

    public void setTxPackets(Long txPackets) {
        this.txPackets = txPackets;
    }

    public Long getRxBytes() {
        return rxBytes;
    }

    public void setRxBytes(Long rxBytes) {
        this.rxBytes = rxBytes;
    }

    public Long getTxBytes() {
        return txBytes;
    }

    public void setTxBytes(Long txBytes) {
        this.txBytes = txBytes;
    }

    public Long getRxErrors() {
        return rxErrors;
    }

    public void setRxErrors(Long rxErrors) {
        this.rxErrors = rxErrors;
    }

    public Long getTxErrors() {
        return txErrors;
    }

    public void setTxErrors(Long txErrors) {
        this.txErrors = txErrors;
    }

    public Long getRxDropped() {
        return rxDropped;
    }

    public void setRxDropped(Long rxDropped) {
        this.rxDropped = rxDropped;
    }

    public Long getTxDropped() {
        return txDropped;
    }

    public void setTxDropped(Long txDropped) {
        this.txDropped = txDropped;
    }

    public Net(String name, String address, String netMask) {
        this.name = name;
        this.address = address;
        this.netMask = netMask;
    }
}

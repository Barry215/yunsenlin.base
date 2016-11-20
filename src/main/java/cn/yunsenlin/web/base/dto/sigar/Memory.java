package cn.yunsenlin.web.base.dto.sigar;


public class Memory {
    private Long total;
    private Long used;
    private Long free;
    private Long swapTotal;
    private Long swapUsed;
    private Long swapFree;

    public Memory(Long total, Long used, Long free, Long swapTotal, Long swapUsed, Long swapFree) {
        this.total = total;
        this.used = used;
        this.free = free;
        this.swapTotal = swapTotal;
        this.swapUsed = swapUsed;
        this.swapFree = swapFree;
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

    public Long getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(Long swapTotal) {
        this.swapTotal = swapTotal;
    }

    public Long getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(Long swapUsed) {
        this.swapUsed = swapUsed;
    }

    public Long getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(Long swapFree) {
        this.swapFree = swapFree;
    }
}

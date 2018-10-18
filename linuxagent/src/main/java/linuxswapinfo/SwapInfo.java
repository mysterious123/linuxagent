package linuxswapinfo;

public class SwapInfo {
    String allocatedSwapSize;
    String usedSwapSize;
    String freeSwapSize;

    public String getAllocatedSwapSize()
    {
        return this.allocatedSwapSize;
    }

    public void setAllocatedSwapSize(String allocatedSwapSize)
    {
        this.allocatedSwapSize = allocatedSwapSize;
    }

    public String getUsedSwapSize()
    {
        return this.usedSwapSize;
    }

    public void setUsedSwapSize(String usedSwapSize)
    {
        this.usedSwapSize = usedSwapSize;
    }

    public String getFreeSwapSize()
    {
        return this.freeSwapSize;
    }

    public void setFreeSwapSize(String freeSwapSize)
    {
        this.freeSwapSize = freeSwapSize;
    }

    public String toString()
    {
        return "SwapInfo{allocatedSwapSize='" + this.allocatedSwapSize + '\'' + ", usedSwapSize='" + this.usedSwapSize + '\'' + ", freeSwapSize='" + this.freeSwapSize + '\'' + '}';
    }
}

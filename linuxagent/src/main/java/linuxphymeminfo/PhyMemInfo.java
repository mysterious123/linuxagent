package linuxphymeminfo;

public class PhyMemInfo {
    String freePhysicalMBytes;
    String usedPhsicalMBytes;
    String TotalPhysicalMBytes;
    String buffers;
    String cached;
    String free;
    String used;

    public String getFreePhysicalMBytes()
    {
        return this.freePhysicalMBytes;
    }

    public void setFreePhysicalMBytes(String freePhysicalMBytes)
    {
        this.freePhysicalMBytes = freePhysicalMBytes;
    }

    public String getUsedPhsicalMBytes()
    {
        return this.usedPhsicalMBytes;
    }

    public void setUsedPhsicalMBytes(String usedPhsicalMBytes)
    {
        this.usedPhsicalMBytes = usedPhsicalMBytes;
    }

    public String getTotalPhysicalMBytes()
    {
        return this.TotalPhysicalMBytes;
    }

    public void setTotalPhysicalMBytes(String totalPhysicalMBytes)
    {
        this.TotalPhysicalMBytes = totalPhysicalMBytes;
    }

    public String getBuffers()
    {
        return this.buffers;
    }

    public void setBuffers(String buffers)
    {
        this.buffers = buffers;
    }

    public String getCached()
    {
        return this.cached;
    }

    public void setCached(String cached)
    {
        this.cached = cached;
    }

    public String getFree()
    {
        return this.free;
    }

    public void setFree(String free)
    {
        this.free = free;
    }

    public String getUsed()
    {
        return this.used;
    }

    public void setUsed(String used)
    {
        this.used = used;
    }

    public String toString()
    {
        return "PhyMemInfo{freePhysicalMBytes='" + this.freePhysicalMBytes + '\'' + ", usedPhsicalMBytes='" + this.usedPhsicalMBytes + '\'' + ", TotalPhysicalMBytes='" + this.TotalPhysicalMBytes + '\'' + ", buffers='" + this.buffers + '\'' + ", cached='" + this.cached + '\'' + ", free='" + this.free + '\'' + ", used='" + this.used + '\'' + '}';
    }
}

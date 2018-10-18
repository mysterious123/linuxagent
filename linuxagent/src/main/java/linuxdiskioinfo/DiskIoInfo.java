package linuxdiskioinfo;

public class DiskIoInfo {
    String DeviceName;
    String DeviceTPS;
    String DiskReadKBytesPersec;
    String DiskWriteKBytesPersec;
    String DiskReadKBytes;
    String DiskWriteKBytes;

    public String toString()
    {
        return "DiskObject [DeviceName=" + this.DeviceName + ", DeviceTPS=" + this.DeviceTPS + ", DiskReadKBytesPersec=" + this.DiskReadKBytesPersec + ", DiskWriteKBytesPersec=" + this.DiskWriteKBytesPersec + ", DiskReadKBytes=" + this.DiskReadKBytes + ", DiskWriteKBytes=" + this.DiskWriteKBytes + "]";
    }

    public String getDeviceName()
    {
        return this.DeviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.DeviceName = deviceName;
    }

    public String getDeviceTPS()
    {
        return this.DeviceTPS;
    }

    public void setDeviceTPS(String deviceTPS)
    {
        this.DeviceTPS = deviceTPS;
    }

    public String getDiskReadKBytesPersec()
    {
        return this.DiskReadKBytesPersec;
    }

    public void setDiskReadKBytesPersec(String diskReadKBytesPersec)
    {
        this.DiskReadKBytesPersec = diskReadKBytesPersec;
    }

    public String getDiskWriteKBytesPersec()
    {
        return this.DiskWriteKBytesPersec;
    }

    public void setDiskWriteKBytesPersec(String diskWriteKBytesPersec)
    {
        this.DiskWriteKBytesPersec = diskWriteKBytesPersec;
    }

    public String getDiskReadKBytes()
    {
        return this.DiskReadKBytes;
    }

    public void setDiskReadKBytes(String diskReadKBytes)
    {
        this.DiskReadKBytes = diskReadKBytes;
    }

    public String getDiskWriteKBytes()
    {
        return this.DiskWriteKBytes;
    }

    public void setDiskWriteKBytes(String diskWriteKBytes)
    {
        this.DiskWriteKBytes = diskWriteKBytes;
    }
}

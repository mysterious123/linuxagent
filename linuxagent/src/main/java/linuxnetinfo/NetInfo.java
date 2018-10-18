package linuxnetinfo;

public class NetInfo {
    String netName;
    String ipAddress;
    String macAddress;
    String bytesReceivedPersec;
    String bytesSentPersec;
    String speed;

    public String toString()
    {
        return "NetInfo{netName='" + this.netName + '\'' + ", ipAddress='" + this.ipAddress + '\'' + ", macAddress='" + this.macAddress + '\'' + ", bytesReceivedPersec='" + this.bytesReceivedPersec + '\'' + ", bytesSentPersec='" + this.bytesSentPersec + '\'' + ", speed='" + this.speed + '\'' + '}';
    }

    public String getSpeed()
    {
        return this.speed;
    }

    public void setSpeed(String speed)
    {
        this.speed = speed;
    }

    public String getNetName()
    {
        return this.netName;
    }

    public void setNetName(String netName)
    {
        this.netName = netName;
    }

    public String getIpAddress()
    {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress()
    {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getBytesReceivedPersec()
    {
        return this.bytesReceivedPersec;
    }

    public void setBytesReceivedPersec(String bytesReceivedPersec)
    {
        this.bytesReceivedPersec = bytesReceivedPersec;
    }

    public String getBytesSentPersec()
    {
        return this.bytesSentPersec;
    }

    public void setBytesSentPersec(String bytesSentPersec)
    {
        this.bytesSentPersec = bytesSentPersec;
    }
}

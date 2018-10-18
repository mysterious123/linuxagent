package linuxsysteminfo;

public class SystemInfo {
    String caption;
    String sysupTime;
    String cSName;
    String coreVersion;
    String oSArchitecture;

    public String toString()
    {
        return "SystemInfo{caption='" + this.caption + '\'' + ", sysupTime='" + this.sysupTime + '\'' + ", cSName='" + this.cSName + '\'' + ", coreVersion='" + this.coreVersion + '\'' + ", oSArchitecture='" + this.oSArchitecture + '\'' + '}';
    }

    public String getCaption()
    {
        return this.caption;
    }

    public void setCaption(String caption)
    {
        this.caption = caption;
    }

    public String getSysupTime()
    {
        return this.sysupTime;
    }

    public void setSysupTime(String sysupTime)
    {
        this.sysupTime = sysupTime;
    }

    public String getcSName()
    {
        return this.cSName;
    }

    public void setcSName(String cSName)
    {
        this.cSName = cSName;
    }

    public String getCoreVersion()
    {
        return this.coreVersion;
    }

    public void setCoreVersion(String coreVersion)
    {
        this.coreVersion = coreVersion;
    }

    public String getoSArchitecture()
    {
        return this.oSArchitecture;
    }

    public void setoSArchitecture(String oSArchitecture)
    {
        this.oSArchitecture = oSArchitecture;
    }
}

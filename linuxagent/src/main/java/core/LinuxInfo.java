package core;

import java.util.ArrayList;
import linuxcpu.CpuInfo;
import linuxdiskinfo.DiskInfo;
import linuxdiskioinfo.DiskIoInfo;
import linuxnetinfo.NetInfo;
import linuxphymeminfo.PhyMemInfo;
import linuxprocessinfo.ProcessInfo;
import linuxswapinfo.SwapInfo;
import linuxsysteminfo.SystemInfo;
import linuxuserinfo.UserInfo;

public class LinuxInfo {
    CpuInfo cpuInfo;
    ArrayList<DiskInfo> disklnfos;
    ArrayList<DiskIoInfo> diskIoInfos;
    ArrayList<UserInfo> userInfos;
    SwapInfo swapInfo;
    PhyMemInfo phyMemInfo;
    ArrayList<ProcessInfo> processInfos;
    ArrayList<SystemInfo> SystemInfo;
    String host;
    String time;
    ArrayList<NetInfo> netInfos;

    public CpuInfo getCpuInfo()
    {
        return this.cpuInfo;
    }

    public void setCpuInfo(CpuInfo cpuInfo)
    {
        this.cpuInfo = cpuInfo;
    }

    public ArrayList<DiskInfo> getDisklnfos()
    {
        return this.disklnfos;
    }

    public void setDisklnfos(ArrayList<DiskInfo> disklnfos)
    {
        this.disklnfos = disklnfos;
    }

    public ArrayList<DiskIoInfo> getDiskIoInfos()
    {
        return this.diskIoInfos;
    }

    public void setDiskIoInfos(ArrayList<DiskIoInfo> diskIoInfos)
    {
        this.diskIoInfos = diskIoInfos;
    }

    public ArrayList<UserInfo> getUserInfos()
    {
        return this.userInfos;
    }

    public void setUserInfos(ArrayList<UserInfo> userInfos)
    {
        this.userInfos = userInfos;
    }

    public SwapInfo getSwapInfo()
    {
        return this.swapInfo;
    }

    public void setSwapInfo(SwapInfo swapInfo)
    {
        this.swapInfo = swapInfo;
    }

    public PhyMemInfo getPhyMemInfo()
    {
        return this.phyMemInfo;
    }

    public void setPhyMemInfo(PhyMemInfo phyMemInfo)
    {
        this.phyMemInfo = phyMemInfo;
    }

    public ArrayList<ProcessInfo> getProcessInfos()
    {
        return this.processInfos;
    }

    public void setProcessInfos(ArrayList<ProcessInfo> processInfos)
    {
        this.processInfos = processInfos;
    }

    public ArrayList<SystemInfo> getSystemInfo()
    {
        return this.SystemInfo;
    }

    public void setSystemInfo(ArrayList<SystemInfo> systemInfo)
    {
        this.SystemInfo = systemInfo;
    }

    public String getHost()
    {
        return this.host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getTime()
    {
        return this.time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public ArrayList<NetInfo> getNetInfos()
    {
        return this.netInfos;
    }

    public void setNetInfos(ArrayList<NetInfo> netInfos)
    {
        this.netInfos = netInfos;
    }

    public String toString()
    {
        return "LinuxInfo{cpuInfo=" + this.cpuInfo + ", disklnfos=" + this.disklnfos + ", diskIoInfos=" + this.diskIoInfos + ", userInfos=" + this.userInfos + ", swapInfo=" + this.swapInfo + ", phyMemInfo=" + this.phyMemInfo + ", processInfos=" + this.processInfos + ", SystemInfo=" + this.SystemInfo + ", host='" + this.host + '\'' + ", time='" + this.time + '\'' + ", netInfos=" + this.netInfos + '}';
    }
}

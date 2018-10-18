package core;


import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import linuxcpu.CpuInfoToPick;
import linuxdiskinfo.DiskInfoToPick;
import linuxdiskioinfo.DiskIoInfoToPick;
import linuxnetinfo.NetInfo;
import linuxnetinfo.NetInfoToPick;
import linuxphymeminfo.PhymemInfoToPick;
import linuxprocessinfo.ProcessInfoToPick;
import linuxsysteminfo.SysInfoToPick;
import linuxuserinfo.UserInfoToPick;

public class AllJsonIndexPick {
    public String getJsonData()
    {
        long curren = System.currentTimeMillis();
        Date da = new Date(curren);
        LinuxInfo linuxInfo = new LinuxInfo();
        Gson gson = new Gson();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String sampletime = dateFormat.format(da);

        linuxInfo.setTime(sampletime);

        PhymemInfoToPick phymemInfoTest = new PhymemInfoToPick();
        linuxInfo.setSwapInfo(phymemInfoTest.getSwapInfo());
        linuxInfo.setPhyMemInfo(phymemInfoTest.getPhyMemInfo());

        ProcessInfoToPick ProcessInfoTest = new ProcessInfoToPick();
        linuxInfo.setProcessInfos(ProcessInfoTest.getProcessInfo());

        SysInfoToPick SysInfoTest = new SysInfoToPick();
        linuxInfo.setSystemInfo(SysInfoTest.readFromFile());

        UserInfoToPick userInfoTest = new UserInfoToPick();
        linuxInfo.setUserInfos(userInfoTest.getUserInfo());

        NetInfoToPick netInfoTest = new NetInfoToPick();
        linuxInfo.setNetInfos(netInfoTest.getInfo());
        for (NetInfo netInfo : netInfoTest.getInfo()) {
            if (netInfo.getNetName() != "lo") {
                linuxInfo.setHost(netInfo.getIpAddress());
            }
        }
        DiskInfoToPick diskInfoTest = new DiskInfoToPick();
        try
        {
            linuxInfo.setDisklnfos(diskInfoTest.getDiskInfo());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        DiskIoInfoToPick diskIoTest = new DiskIoInfoToPick();
        try
        {
            linuxInfo.setDiskIoInfos(diskIoTest.getDiskIoInfo());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        CpuInfoToPick cpuInfoTest = new CpuInfoToPick();
        try
        {
            linuxInfo.setCpuInfo(cpuInfoTest.getInfo());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String agentInfo = gson.toJson(linuxInfo);
        return agentInfo;
}

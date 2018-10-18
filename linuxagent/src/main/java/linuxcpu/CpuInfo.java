package linuxcpu;

public class CpuInfo {
        String cpuUsage;
        String cpuidel;
        String cpubit;
        String cpuname;
        String cpucores;
        String cpus;
        String cpuMhz;
        String us;
        String sy;
        String id;
        String wa;
        String hi;
        String si;
        String st;
    public String getCpuUsage()
    {
        return this.cpuUsage;
    }

    public void setCpuUsage(String cpuUsage)
    {
        this.cpuUsage = cpuUsage;
    }

    public String getCpuidel()
    {
        return this.cpuidel;
    }

    public void setCpuidel(String cpuidel)
    {
        this.cpuidel = cpuidel;
    }

    /**
     * @return
     */
    public String getCpubit()
    {
        return this.cpubit;
    }

    public void setCpubit(String cpubit)
    {
        this.cpubit = cpubit;
    }

    public String getCpuname()
    {
        return this.cpuname;
    }

    public void setCpuname(String cpuname)
    {
        this.cpuname = cpuname;
    }

    public String getCpucores()
    {
        return this.cpucores;
    }

    public void setCpucores(String cpucores)
    {
        this.cpucores = cpucores;
    }

    public String getCpus()
    {
        return this.cpus;
    }

    public void setCpus(String cpus)
    {
        this.cpus = cpus;
    }

    public String getCpuMhz()
    {
        return this.cpuMhz;
    }

    public void setCpuMhz(String cpuMhz)
    {
        this.cpuMhz = cpuMhz;
    }

    public String getUs()
    {
        return this.us;
    }

    public void setUs(String us)
    {
        this.us = us;
    }

    public String getSy()
    {
        return this.sy;
    }

    public void setSy(String sy)
    {
        this.sy = sy;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getWa()
    {
        return this.wa;
    }

    public void setWa(String wa)
    {
        this.wa = wa;
    }

    public String getHi()
    {
        return this.hi;
    }

    public void setHi(String hi)
    {
        this.hi = hi;
    }

    public String getSi()
    {
        return this.si;
    }

    public void setSi(String si)
    {
        this.si = si;
    }

    public String getSt()
    {
        return this.st;
    }

    public void setSt(String st)
    {
        this.st = st;
    }

    public String toString()
    {
        return "CpuInfo{cpuUsage='" + this.cpuUsage + '\'' + ", cpuidel='" + this.cpuidel + '\'' + ", cpubit='" + this.cpubit + '\'' + ", cpuname='" + this.cpuname + '\'' + ", cpucores='" + this.cpucores + '\'' + ", cpus='" + this.cpus + '\'' + ", cpuMhz='" + this.cpuMhz + '\'' + ", us='" + this.us + '\'' + ", sy='" + this.sy + '\'' + ", id='" + this.id + '\'' + ", wa='" + this.wa + '\'' + ", hi='" + this.hi + '\'' + ", si='" + this.si + '\'' + ", st='" + this.st + '\'' + '}';
    }
}

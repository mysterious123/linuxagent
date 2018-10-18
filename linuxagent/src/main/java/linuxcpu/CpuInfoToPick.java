package linuxcpu;

import java.io.LineNumberReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class CpuInfoToPick {
    public CpuInfo getInfo()
            throws IOException
    {
        LineNumberReader lineNumberReader = null;
        String[] cmd = { "/bin/sh", "-c", "cat /proc/cpuinfo | grep flags | grep 'lm' | wc -l && cat /proc/cpuinfo | grep name | cut -f2 -d: | uniq -c && cat /proc/cpuinfo && top -b -n 1" };
        InputStream in = null;
        Process pro = Runtime.getRuntime().exec(cmd);
        try
        {
            pro.waitFor();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        in = pro.getInputStream();
        lineNumberReader = new LineNumberReader(new InputStreamReader(in));
        String line = null;
        int cpu = 0;
        CpuInfo cpuInfo = new CpuInfo();
        while ((line = lineNumberReader.readLine()) != null) {
            if (lineNumberReader.getLineNumber() == 1)
            {
                if (Integer.parseInt(line.trim()) > 0) {
                    cpuInfo.setCpubit("64");
                } else {
                    cpuInfo.setCpubit("32");
                }
            }
            else if (lineNumberReader.getLineNumber() == 2)
            {
                String[] cpuData = line.split("  ");
                for (int h = 0; h < cpuData.length; h++) {
                    if ((cpuData[h].length() > 0) && (cpuData[h].length() < 2)) {
                        cpuInfo.setCpus(cpuData[h]);
                    } else if (cpuData[h].length() > 3) {
                        cpuInfo.setCpuname(cpuData[h]);
                    }
                }
            }
            else if (line.contains("cpu MHz"))
            {
                String[] cpu_mHz = line.split(":");
                cpuInfo.setCpuMhz(cpu_mHz[1]);
            }
            else if (line.contains("cpu cores"))
            {
                String[] split = line.split(":");
                int cpuCore = 0;
                if (split[1].length() > 0) {
                    cpuCore = Integer.parseInt(split[1].trim());
                }
                cpu += cpuCore;
            }
            else if (line.contains("Cpu(s):"))
            {
                String[] split = line.split(" ");
                for (int n = 0; n < split.length; n++) {
                    if (split[n].contains("us"))
                    {
                        String usData = split[n].replace("%us,", "");
                        cpuInfo.setUs(usData);
                    }
                    else if (split[n].contains("id"))
                    {
                        String idData = split[n].replace("%id,", "");
                        cpuInfo.setId(idData);
                        cpuInfo.setCpuidel(idData);
                    }
                    else if (split[n].contains("sy"))
                    {
                        String syData = split[n].replace("%sy,", "");
                        cpuInfo.setSy(syData);
                    }
                    else if (split[n].contains("wa"))
                    {
                        String waData = split[n].replace("%wa,", "");
                        cpuInfo.setWa(waData);
                    }
                    else if (split[n].contains("hi"))
                    {
                        String hiData = split[n].replace("%hi,", "");
                        cpuInfo.setHi(hiData);
                    }
                    else if (split[n].contains("si"))
                    {
                        String siData = split[n].replace("%si,", "");
                        cpuInfo.setSi(siData);
                    }
                    else if (split[n].contains("st"))
                    {
                        String stData = split[n].replace("%st", "");
                        cpuInfo.setSt(stData);
                    }
                }
                double d = Double.valueOf(cpuInfo.getUs().trim()).doubleValue();
                double a = Double.valueOf(cpuInfo.getSy().trim()).doubleValue();
                double c = Double.valueOf(cpuInfo.getWa().trim()).doubleValue();
                double e = Double.valueOf(cpuInfo.getHi().trim()).doubleValue();
                double f = Double.valueOf(cpuInfo.getSi().trim()).doubleValue();
                double g = Double.valueOf(cpuInfo.getSt().trim()).doubleValue();
                DecimalFormat df = new DecimalFormat("0.0");
                cpuInfo.setCpuUsage(df.format(d + a + c + e + f + g));
            }
        }
        cpuInfo.setCpucores(String.valueOf(cpu));
        return cpuInfo;
    }

    public static void main(String[] args)
    {
        CpuInfoToPick cpuInfoTest = new CpuInfoToPick();
        try
        {
            CpuInfo localCpuInfo = cpuInfoTest.getInfo();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

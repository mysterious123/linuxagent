package linuxphymeminfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import linuxswapinfo.SwapInfo;
public class PhymemInfoToPick {
    public ArrayList<String> listData(String args, String reader)
    {
        ArrayList<String> stringList = new ArrayList();
        if (reader.contains(args))
        {
            String[] string = reader.split("  ");
            for (int j = 0; j < string.length; j++) {
                if (string[j].length() > 0) {
                    stringList.add(string[j]);
                }
            }
        }
        return stringList;
    }

    public PhyMemInfo getPhyMemInfo()
    {
        LineNumberReader lineNumberReader = null;
        PhyMemInfo phyMemInfo = new PhyMemInfo();
        String[] cmd = { "/bin/sh", "-c", "free -m" };
        InputStream in = null;
        try {
        Process pro = null;
            pro = Runtime.getRuntime().exec(cmd);
        pro.waitFor();
            in = pro.getInputStream();
            lineNumberReader = new LineNumberReader(new InputStreamReader(in));
            String line = null;
            while ((line = lineNumberReader.readLine()) != null)
            {
                ArrayList<String> memInfoStrings = listData("Mem:", line);
                for (int n = 0; n < memInfoStrings.size(); n++) {
                    if (n == 1) {
                        phyMemInfo.setTotalPhysicalMBytes(((String)memInfoStrings.get(n)).trim());
                    } else if (n == 2) {
                        phyMemInfo.setUsed(((String)memInfoStrings.get(n)).trim());
                    } else if (n == 3) {
                        phyMemInfo.setFree(((String)memInfoStrings.get(n)).trim());
                    } else if (n == 5) {
                        phyMemInfo.setBuffers(((String)memInfoStrings.get(n)).trim());
                    } else if (n == 6) {
                        phyMemInfo.setCached(((String)memInfoStrings.get(n)).trim());
                    }
                }
            }
            int free = Integer.parseInt(phyMemInfo.getFree().trim());
            int buffers = Integer.parseInt(phyMemInfo.getBuffers().trim());
            int cached = Integer.parseInt(phyMemInfo.getCached().trim());
            int used = Integer.parseInt(phyMemInfo.getUsed().trim());
            String freePhysicalMBytes = String.valueOf(buffers + cached + free);
            String usedPhsicalMBytes = String.valueOf(used - cached - free);
            phyMemInfo.setFreePhysicalMBytes(freePhysicalMBytes);
            phyMemInfo.setUsedPhsicalMBytes(usedPhsicalMBytes);
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return phyMemInfo;
    }

    public SwapInfo getSwapInfo()
    {
        LineNumberReader lineNumberReader = null;
        SwapInfo swapInfo = new SwapInfo();
        String[] cmd = { "/bin/sh", "-c", "free -m" };
        InputStream in = null;
        try {
        Process pro = null;
            pro = Runtime.getRuntime().exec(cmd);
        pro.waitFor();
            in = pro.getInputStream();
            lineNumberReader = new LineNumberReader(new InputStreamReader(in));
            String line = null;
            while ((line = lineNumberReader.readLine()) != null)
            {
                ArrayList<String> swapStrings = listData("Swap:", line);
                for (int m = 0; m < swapStrings.size(); m++) {
                    if (m == 1) {
                        swapInfo.setAllocatedSwapSize(((String)swapStrings.get(m)).trim());
                    } else if (m == 2) {
                        swapInfo.setUsedSwapSize(((String)swapStrings.get(m)).trim());
                    } else if (m == 3) {
                        swapInfo.setFreeSwapSize(((String)swapStrings.get(m)).trim());
                    }
                }
            }
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return swapInfo;
      }
}

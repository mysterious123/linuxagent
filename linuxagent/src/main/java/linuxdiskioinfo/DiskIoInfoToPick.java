package linuxdiskioinfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class DiskIoInfoToPick {
    public ArrayList<DiskIoInfo> getDiskIoInfo()
            throws IOException
    {
        String[] cmd = { "/bin/sh", "-c", "iostat -d -k 1 1" };
        LineNumberReader lineNumberReader = null;
        InputStream in = null;
        Process pro = null;
        pro = Runtime.getRuntime().exec(cmd);
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
        ArrayList<DiskIoInfo> diskIoIfoArrayList = new ArrayList();
        String line = null;
        while ((line = lineNumberReader.readLine()) != null)
        {
            ArrayList<Object> arrayList = new ArrayList();
            DiskIoInfo diskInfo = new DiskIoInfo();
            if (lineNumberReader.getLineNumber() > 3)
            {
                String[] str = line.split(" ");
                for (int n = 0; n < str.length; n++) {
                    if (str[n].length() > 0) {
                        arrayList.add(str[n]);
                    }
                }
                for (int m = 0; m < arrayList.size(); m++) {
                    if ((m == 0) && (arrayList.get(m).toString() != null)) {
                        diskInfo.setDeviceName(arrayList.get(m).toString());
                    } else if ((m == 1) && (arrayList.get(m).toString() != null)) {
                        diskInfo.setDeviceTPS(arrayList.get(m).toString());
                    } else if ((m == 2) && (arrayList.get(m).toString() != null)) {
                        diskInfo.setDiskReadKBytesPersec(arrayList.get(m).toString());
                    } else if ((m == 3) && (arrayList.get(m).toString() != null)) {
                        diskInfo.setDiskWriteKBytesPersec(arrayList.get(m).toString());
                    } else if ((m == 4) && (arrayList.get(m).toString() != null)) {
                        diskInfo.setDiskReadKBytes(arrayList.get(m).toString());
                    } else if ((m == 5) && (arrayList.get(m).toString() != null)) {
                        diskInfo.setDiskWriteKBytes(arrayList.get(m).toString());
                    }
                }
                if (diskInfo.getDeviceName() != null) {
                    diskIoIfoArrayList.add(diskInfo);
                }
            }
        }
        return diskIoIfoArrayList;
    }

    public static void main(String[] args)
    {
        DiskIoInfoToPick test = new DiskIoInfoToPick();
        try
        {
            ArrayList<DiskIoInfo> list = test.getDiskIoInfo();
            for (DiskIoInfo d : list) {
                System.out.println(d);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

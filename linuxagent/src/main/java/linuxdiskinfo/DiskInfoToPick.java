package linuxdiskinfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class DiskInfoToPick {
    public ArrayList<DiskInfo> getDiskInfo()
            throws IOException
    {
        LineNumberReader lineNumberReader = null;
        String[] cmd = { "/bin/sh", "-c", "df -m" };
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
        DiskInfo preDiskInfo = new DiskInfo();
        ArrayList<DiskInfo> List = new ArrayList();
        while ((line = lineNumberReader.readLine()) != null)
        {
            ArrayList<Object> arrayList = new ArrayList();
            ArrayList<String> preList = new ArrayList();
            if (lineNumberReader.getLineNumber() == 2)
            {
                preDiskInfo.setUsedFS(line);
            }
            else if (lineNumberReader.getLineNumber() == 3)
            {
                String[] data = line.split(" ");
                for (String result : data) {
                    if (result.length() > 0) {
                        preList.add(result);
                    }
                }
                for (int m = 0; m < preList.size(); m++) {
                    if (m == 3) {
                        preDiskInfo.setFileSystemSize((String)preList.get(m));
                    } else if (m == 4) {
                        preDiskInfo.setFileSystem((String)preList.get(m));
                    }
                }
            }
            if (lineNumberReader.getLineNumber() > 3)
            {
                DiskInfo diskInfo = new DiskInfo();
                String[] str = line.split(" ");
                for (int n = 0; n < str.length; n++) {
                    if (str[n].length() > 0) {
                        arrayList.add(str[n]);
                    }
                }
                for (int m = 0; m < arrayList.size(); m++) {
                    if (m == 2) {
                        diskInfo.setUsedFS(arrayList.get(m).toString());
                    } else if (m == 4) {
                        diskInfo.setFileSystemSize(arrayList.get(m).toString());
                    } else if (m == 5) {
                        diskInfo.setFileSystem(arrayList.get(m).toString());
                    }
                }
                List.add(diskInfo);
            }
        }
        List.add(preDiskInfo);
        return List;
    }

    public static void main(String[] args)
    {
        DiskInfoToPick test = new DiskInfoToPick();
        try
        {
            test.getDiskInfo();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

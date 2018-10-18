package linuxsysteminfo;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SysInfoToPick {
    public ArrayList<SystemInfo> readFromFile() {
        long curren = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        LineNumberReader lineNumberReader = null;
        ArrayList systemList = new ArrayList();
        String width = null;
        try {
            String[] cmd = {"/bin/sh", "-c", "cat /etc/redhat-release && cat /proc/uptime && hostname && uname -r && uname -a"};
            InputStream in = null;
        Process pro = null;
            pro = Runtime.getRuntime().exec(cmd);
        pro.waitFor();
            in = pro.getInputStream();
            lineNumberReader = new LineNumberReader(new InputStreamReader(in));
            String line = null;
            SystemInfo systemInfo = new SystemInfo();
            while ((line = lineNumberReader.readLine()) != null) {
                if (lineNumberReader.getLineNumber() == 1) {
                    systemInfo.setCaption(line);
                } else if (lineNumberReader.getLineNumber() == 2) {
                    String[] restult = line.split(" ");
                    String test = restult[0];
                    String replace = test.replace(".", "");
                    long time = Long.parseLong(replace);
                    Date da = new Date(curren - time);
                    String sampletime = dateFormat.format(da);
                    systemInfo.setSysupTime(sampletime);
                } else if (lineNumberReader.getLineNumber() == 3) {
                    systemInfo.setcSName(line);
                } else if (lineNumberReader.getLineNumber() == 4) {
                    systemInfo.setCoreVersion(line);
                } else if (lineNumberReader.getLineNumber() == 5) {
                    if (line.contains("x86_64")) {
                        width = "64";
                    } else if (line.contains("i386")) {
                        width = "32";
                    }
                    systemInfo.setoSArchitecture(width);
                }
            }
            systemList.add(systemInfo);
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return systemList;
    }
}

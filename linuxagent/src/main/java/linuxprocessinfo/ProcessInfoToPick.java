package linuxprocessinfo;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import java.util.ArrayList;
public class ProcessInfoToPick {
    public ArrayList<ProcessInfo> getProcessInfo() {
        LineNumberReader lineNumberReader = null;
        ArrayList processInfoArrayList = new ArrayList();
        try {
            String[] cmd = {"/bin/sh", "-c", "ps aux"};
            InputStream in = null;
            Process pro = null;
            pro = Runtime.getRuntime().exec(cmd);
            pro.waitFor();
            in = pro.getInputStream();
            lineNumberReader = new LineNumberReader(new InputStreamReader(in));
            String line = null;
            while ((line = lineNumberReader.readLine()) != null) {
                if (lineNumberReader.getLineNumber() > 1) {
                    ArrayList<Object> arrayList = new ArrayList();
                    String[] result = line.split(" ");
                    for (int n = 0; n < result.length; n++) {
                        if (result[n].length() > 0) {
                            arrayList.add(result[n]);
                        }
                    }
                    ProcessInfo processInfo = new ProcessInfo();
                    ThreadCountToPick threadCountToPick = new ThreadCountToPick();
                    for (int m = 0; m < arrayList.size(); m++) {
                        if (m == 0) {
                            processInfo.setProcessName(arrayList.get(m).toString());
                        } else if (m == 1) {
                            processInfo.setProcessId(arrayList.get(m).toString());
                            if (arrayList.get(m).toString() != null) {
                                processInfo.setThreadCount(threadCountToPick.getThreadCount(arrayList.get(m).toString()));
                            }
                        } else if (m == 2) {
                            processInfo.setPercentProcessorTime(arrayList.get(m).toString());
                        } else if (m == 3) {
                            processInfo.setWorkingSet(arrayList.get(m).toString());
                        } else if (m == 7) {
                            processInfo.setProcessStatus(arrayList.get(m).toString());
                        } else if (m == 9) {
                            processInfo.setCreationDate(arrayList.get(m).toString());
                        } else if (m == 10) {
                            processInfo.setProcessCommand(arrayList.get(m).toString());
                        }
                    }
                    processInfoArrayList.add(processInfo);
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
        return processInfoArrayList;
    }
}

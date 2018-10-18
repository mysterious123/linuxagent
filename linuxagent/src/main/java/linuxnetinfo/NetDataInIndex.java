package linuxnetinfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class NetDataInIndex {
    public ArrayList<String> getindex() {
        LineNumberReader lineNumberReader = null;
        ArrayList arrayList = new ArrayList();
        try {
            String[] cmd = {"/bin/sh", "-c", "cat /proc/net/dev"};
            InputStream in = null;
            Process pro = Runtime.getRuntime().exec(cmd);
            pro.waitFor();
            in = pro.getInputStream();
            lineNumberReader = new LineNumberReader(new InputStreamReader(in));
            String line = null;
            while ((line = lineNumberReader.readLine()) != null) {
                if (lineNumberReader.getLineNumber() > 2) {
                    String[] result = line.split(":");
                    arrayList.add(result[0]);
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return arrayList;
    }
}

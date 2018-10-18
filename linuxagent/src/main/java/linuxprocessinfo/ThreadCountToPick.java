package linuxprocessinfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ThreadCountToPick {
    public String getThreadCount(String number)
    {
        String data = null;
        LineNumberReader lineNumberReader = null;
        String shell = "ps -Lf " + number + " | wc -l";
        String[] cmd = { "/bin/sh", "-c", shell };
        InputStream in = null;
        Process pro = null;
        try
        {
            pro = Runtime.getRuntime().exec(cmd);
            pro.waitFor();
            in = pro.getInputStream();
            lineNumberReader = new LineNumberReader(new InputStreamReader(in));
            String line = null;
            while ((line = lineNumberReader.readLine()) != null) {
                data = line;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return data;
    }
}

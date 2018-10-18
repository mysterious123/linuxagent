package linuxnetinfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;

public class NetInfoToPick {
    public Integer number(String args, String reader, int lindNumber)
    {
        int number = 0;
        if (reader.contains(args)) {
            number = lindNumber;
        }
        return Integer.valueOf(number);
    }

    public String getindex(String args, String text)
    {
        String index = null;
        if (text.contains(args))
        {
            String[] data = text.split(":");
            index = data[1];
        }
        return index;
    }

    public ArrayList<NetInfo> getInfo()
    {
        NetDataInIndex netliuxinfoTest = new NetDataInIndex();
        ArrayList<String> getindex = netliuxinfoTest.getindex();
        ArrayList<NetInfo> netInfosList = new ArrayList();
        Iterator localIterator = getindex.iterator();
        for (;;)
        {
            if (localIterator.hasNext())
            {
                String index = (String)localIterator.next();
                LineNumberReader lineNumberReader = null;
                try
                {
                    String[] cmd = { "/bin/sh", "-c", "ifconfig -a" };
                    InputStream in = null;
                    Process pro = Runtime.getRuntime().exec(cmd);
                    pro.waitFor();
                    in = pro.getInputStream();
                    lineNumberReader = new LineNumberReader(new InputStreamReader(in));
                    String line = null;
                    int local = 0;
                    NetInfo netInfo = new NetInfo();
                    while ((line = lineNumberReader.readLine()) != null)
                    {
                        if (line.contains(index.trim()))
                        {
                            netInfo.setNetName(index.trim());
                            local = lineNumberReader.getLineNumber();
                        }
                        else if (line.contains("media:"))
                        {
                            String[] media = line.split(" ");
                            for (int n = 0; n < media.length; n++) {
                                if ((media.length > 0) && (media[n].contains("baseTx-FD")))
                                {
                                    String replace = media[n].replace("baseTx-FD,", "");
                                    netInfo.setSpeed(replace);
                                }
                            }
                        }
                        if ((lineNumberReader.getLineNumber() != local) && (lineNumberReader.getLineNumber() == local + 1))
                        {
                            String[] ip = line.split("  ");
                            for (int n = 0; n < ip.length; n++) {
                                if (ip[n].length() > 0) {
                                    if (ip[n].contains("addr:"))
                                    {
                                        String[] data = ip[n].split(":");
                                        netInfo.setIpAddress(data[1]);
                                    }
                                    else if (ip[n].contains("Mask:"))
                                    {
                                        String[] data = ip[n].split(":");
                                        netInfo.setMacAddress(data[1]);
                                    }
                                }
                            }
                        }
                        if ((line.contains("RX packets")) && (lineNumberReader.getLineNumber() == local + 4))
                        {
                            String[] split = line.split(" ");
                            for (int n = 0; n < split.length; n++) {
                                if ((split[n].length() > 1) && (split[n].contains("packets:")))
                                {
                                    String[] rxPackets = split[n].split(":");
                                    netInfo.setBytesReceivedPersec(rxPackets[1]);
                                }
                            }
                        }
                        else if ((line.contains("TX packets")) && (lineNumberReader.getLineNumber() == local + 5))
                        {
                            String[] split = line.split(" ");
                            for (int n = 0; n < split.length; n++) {
                                if ((split[n].length() > 1) && (split[n].contains("packets:")))
                                {
                                    String[] rxPackets = split[n].split(":");
                                    netInfo.setBytesSentPersec(rxPackets[1]);
                                }
                            }
                        }
                    }
                    netInfosList.add(netInfo);
                    try
                    {
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }
                catch (FileNotFoundException ex)
                {
                    ex.printStackTrace();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
            return netInfosList;
        }

    }

    public static void main(String[] args)
    {
        NetInfoToPick diskIoTest = new NetInfoToPick();
        ArrayList<NetInfo> info = diskIoTest.getInfo();
        for (NetInfo d : info) {
            System.out.println(d);
        }
    }
}

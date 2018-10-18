package linuxuserinfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import java.util.ArrayList;

public class UserInfoToPick {
    public ArrayList<UserInfo> getUserInfo() {
        LineNumberReader lineNumberReader = null;
        ArrayList arrayList = new ArrayList();
        try {
        String[] cmd = {"/bin/sh", "-c", "cat /etc/passwd"};
        InputStream in = null;
        Process pro = null;
            pro = Runtime.getRuntime().exec(cmd);
        pro.waitFor();
        in = pro.getInputStream();
        lineNumberReader = new LineNumberReader(new InputStreamReader(in));
        String line = null;
        while ((line = lineNumberReader.readLine()) != null) {
            UserInfo userInfo = new UserInfo();
            String[] result = line.split(":");
            for (int i = 0; i < result.length; i++) {
                if (i == 0) {
                    if (result[i].length() > 0) {
                        userInfo.setUserName(result[i]);
                    }
                } else if (i == 2) {
                    if (result[i].length() > 0) {
                        userInfo.setUserID(result[i]);
                    }
                } else if ((i == 3) &&
                        (result[i].length() > 0)) {
                    userInfo.setGroupID(result[i]);
                }
            }
            arrayList.add(userInfo);
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    }

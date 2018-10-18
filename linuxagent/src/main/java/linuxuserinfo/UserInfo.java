package linuxuserinfo;

public class UserInfo {
    String userName;
    String userID;
    String groupID;

    public String toString()
    {
        return "UserInfo{userName='" + this.userName + '\'' + ", userID='" + this.userID + '\'' + ", groupID='" + this.groupID + '\'' + '}';
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserID()
    {
        return this.userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getGroupID()
    {
        return this.groupID;
    }

    public void setGroupID(String groupID)
    {
        this.groupID = groupID;
    }
}

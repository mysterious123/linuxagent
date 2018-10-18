package linuxprocessinfo;

public class ProcessInfo {
    String processName;
    String processId;
    String creationDate;
    String percentProcessorTime;
    String workingSet;
    String processStatus;
    String processCommand;
    String threadCount;

    public String getProcessName()
    {
        return this.processName;
    }

    public void setProcessName(String processName)
    {
        this.processName = processName;
    }

    public String getProcessId()
    {
        return this.processId;
    }

    public void setProcessId(String processId)
    {
        this.processId = processId;
    }

    public String getCreationDate()
    {
        return this.creationDate;
    }

    public void setCreationDate(String creationDate)
    {
        this.creationDate = creationDate;
    }

    public String getPercentProcessorTime()
    {
        return this.percentProcessorTime;
    }

    public void setPercentProcessorTime(String percentProcessorTime)
    {
        this.percentProcessorTime = percentProcessorTime;
    }

    public String getWorkingSet()
    {
        return this.workingSet;
    }

    public void setWorkingSet(String workingSet)
    {
        this.workingSet = workingSet;
    }

    public String getProcessStatus()
    {
        return this.processStatus;
    }

    public void setProcessStatus(String processStatus)
    {
        this.processStatus = processStatus;
    }

    public String getProcessCommand()
    {
        return this.processCommand;
    }

    public void setProcessCommand(String processCommand)
    {
        this.processCommand = processCommand;
    }

    public String getThreadCount()
    {
        return this.threadCount;
    }

    public void setThreadCount(String threadCount)
    {
        this.threadCount = threadCount;
    }

    public String toString()
    {
        return "ProcessInfo{processName='" + this.processName + '\'' + ", processId='" + this.processId + '\'' + ", creationDate='" + this.creationDate + '\'' + ", percentProcessorTime='" + this.percentProcessorTime + '\'' + ", workingSet='" + this.workingSet + '\'' + ", processStatus='" + this.processStatus + '\'' + ", processCommand='" + this.processCommand + '\'' + ", threadCount='" + this.threadCount + '\'' + '}';
    }
}

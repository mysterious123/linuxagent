package linuxdiskinfo;

public class DiskInfo {
    String fileSystem;
    String usedFS;
    String fileSystemSize;

    public String toString()
    {
        return "DiskInfo{fileSystem='" + this.fileSystem + '\'' + ", usedFS='" + this.usedFS + '\'' + ", fileSystemSize='" + this.fileSystemSize + '\'' + '}';
    }

    public String getFileSystem()
    {
        return this.fileSystem;
    }

    public void setFileSystem(String fileSystem)
    {
        this.fileSystem = fileSystem;
    }

    public String getUsedFS()
    {
        return this.usedFS;
    }

    public void setUsedFS(String usedFS)
    {
        this.usedFS = usedFS;
    }

    public String getFileSystemSize()
    {
        return this.fileSystemSize;
    }

    public void setFileSystemSize(String fileSystemSize)
    {
        this.fileSystemSize = fileSystemSize;
    }
}

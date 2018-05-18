package online.zhaopei.myproject.dtos;

public class ArchiveQuery {
    private String refStart;
    private String refEnd;
    private String archiveNum;
    private String  owner;
    private String user;
    private String   status;
    private String  returnStart;
    private String  returnEnd;

    public String getRefStart() {
        return refStart;
    }

    public String getRefEnd() {
        return refEnd;
    }

    public String getArchiveNum() {
        return archiveNum;
    }

    public String getOwner() {
        return owner;
    }

    public String getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public String getReturnStart() {
        return returnStart;
    }

    public String getReturnEnd() {
        return returnEnd;
    }

    public void setRefStart(String refStart) {
        this.refStart = refStart;
    }

    public void setRefEnd(String refEnd) {
        this.refEnd = refEnd;
    }

    public void setArchiveNum(String archiveNum) {
        this.archiveNum = archiveNum;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReturnStart(String returnStart) {
        this.returnStart = returnStart;
    }

    public void setReturnEnd(String returnEnd) {
        this.returnEnd = returnEnd;
    }
}

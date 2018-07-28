package online.zhaopei.myproject.domain;

import java.io.Serializable;
import java.util.Date;

public class ArchiveRecordHistory implements Serializable {
    private int id;
    private Date referdate;
    private String archiveNum;
    private String owner;
    private String user;
    private String status;
    private Date returndate;

    public int getId() {
        return id;
    }

    public Date getReferdate() {
        return referdate;
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

    public Date getReturndate() {
        return returndate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReferdate(Date referdate) {
        this.referdate = referdate;
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

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    @Override
    public String toString() {
        return this.getArchiveNum() + "," + this.getOwner() + "," +
                this.getStatus() + "," + this.getUser();
    }
}
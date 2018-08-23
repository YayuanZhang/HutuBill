// 
// Decompiled by Procyon v0.5.30
// 

package entity;

import java.util.Date;

public class Record
{
    public int spend;
    public int id;
    public int cid;
    public String comment;
    public Date date;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getCid() {
        return this.cid;
    }
    
    public void setCid(final int cid) {
        this.cid = cid;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(final String comment) {
        this.comment = comment;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(final Date date) {
        this.date = date;
    }
    
    public int getSpend() {
        return this.spend;
    }
    
    public void setSpend(final int spend) {
        this.spend = spend;
    }
}

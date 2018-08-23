// 
// Decompiled by Procyon v0.5.30
// 

package service;

import entity.Record;
import java.util.Date;
import entity.Category;
import dao.RecordDAO;

public class RecordService
{
    RecordDAO recordDao;
    
    public RecordService() {
        this.recordDao = new RecordDAO();
    }
    
    public void add(final int spend, final Category c, final String comment, final Date date) {
        final Record r = new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;
        this.recordDao.add(r);
    }
}

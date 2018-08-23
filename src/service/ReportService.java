// 
// Decompiled by Procyon v0.5.30
// 

package service;

import java.util.Calendar;
import util.DateUtil;
import java.util.ArrayList;
import dao.RecordDAO;
import java.util.Iterator;
import entity.Record;
import java.util.List;
import java.util.Date;

public class ReportService
{
    public int getDaySpend(final Date d, final List<Record> monthRawData) {
        int daySpend = 0;
        for (final Record record : monthRawData) {
            if (record.date.equals(d)) {
                daySpend += record.spend;
            }
        }
        return daySpend;
    }
    
    public List<Record> listThisMonthRecords() {
        final RecordDAO dao = new RecordDAO();
        final List<Record> monthRawData = dao.listThisMonth();
        final List<Record> result = new ArrayList<Record>();
        final Date monthBegin = DateUtil.monthBegin();
        final int monthTotalDay = DateUtil.thisMonthTotalDay();
        final Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; ++i) {
            final Record r = new Record();
            c.setTime(monthBegin);
            c.add(5, i);
            final Date eachDayOfThisMonth = c.getTime();
            final int daySpend = this.getDaySpend(eachDayOfThisMonth, monthRawData);
            r.spend = daySpend;
            result.add(r);
        }
        return result;
    }
}

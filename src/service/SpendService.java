
package service;

import java.util.Iterator;
import java.util.List;
import entity.Record;
import util.DateUtil;
import dao.RecordDAO;
import gui.page.SpendPage;

public class SpendService
{
    public SpendPage getSpendPage() {
        final RecordDAO dao = new RecordDAO();
        final List<Record> thisMonthRecords = dao.listThisMonth();
        final List<Record> toDayRecords = dao.listToday();
        final int thisMonthTotalDay = DateUtil.thisMonthTotalDay();
        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;
        final int monthBudget = new ConfigService().getIntBudget();
        for (final Record record : thisMonthRecords) {
            monthSpend += record.getSpend();
        }
        for (final Record record : toDayRecords) {
            todaySpend += record.getSpend();
        }
        avgSpendPerDay = monthSpend / thisMonthTotalDay;
        monthAvailable = monthBudget - monthSpend;
        monthLeftDay = DateUtil.thisMonthLeftDay();
        dayAvgAvailable = monthAvailable / monthLeftDay;
        usagePercentage = monthSpend * 100 / monthBudget;
        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay, usagePercentage);
    }
}

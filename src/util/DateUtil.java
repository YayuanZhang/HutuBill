
package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
    static long millisecondsOfOneDay;
    
    static {
        DateUtil.millisecondsOfOneDay = 86400000L;
    }
    
    public static java.sql.Date util2sql(final Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    public static Date today() {
        final Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(10, 0);
        c.set(12, 0);
        c.set(13, 0);
        return c.getTime();
    }
    
    public static Date monthBegin() {
        final Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(5, 1);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }
    
    public static Date monthEnd() {
        final Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(10, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(5, 1);
        c.add(2, 1);
        c.add(5, -1);
        return c.getTime();
    }
    
    public static int thisMonthTotalDay() {
        final long lastDayMilliSeconds = monthEnd().getTime();
        final long firstDayMilliSeconds = monthBegin().getTime();
        return (int)((lastDayMilliSeconds - firstDayMilliSeconds) / DateUtil.millisecondsOfOneDay) + 1;
    }
    
    public static int thisMonthLeftDay() {
        final long lastDayMilliSeconds = monthEnd().getTime();
        final long toDayMilliSeconds = today().getTime();
        return (int)((lastDayMilliSeconds - toDayMilliSeconds) / DateUtil.millisecondsOfOneDay) + 1;
    }
    
    public static void main(final String[] args) {
        System.out.println(today());
        System.out.println(monthBegin());
        System.out.println(monthEnd());
        System.out.println(thisMonthLeftDay());
        System.out.println(thisMonthTotalDay());
    }
}

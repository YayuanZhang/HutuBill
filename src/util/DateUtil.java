
package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
    static long millisecondsOfOneDay;
    
    static {
        DateUtil.millisecondsOfOneDay = 1000*60*60*24;
    }
    
    public static java.sql.Date util2sql(final Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    public static Date today() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }
    
    public static Date monthBegin() {
         Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONDAY, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }
    
    public static int thisMonthTotalDay() {
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();
        return (int)((lastDayMilliSeconds - firstDayMilliSeconds) / DateUtil.millisecondsOfOneDay) + 1;
    }
    
    public static int thisMonthLeftDay() {
        final long lastDayMilliSeconds = monthEnd().getTime();
        final long toDayMilliSeconds = today().getTime();
        return (int)((lastDayMilliSeconds - toDayMilliSeconds) / DateUtil.millisecondsOfOneDay) + 1;
    }
    
    public static void main(final String[] args) {
        System.out.println(DateUtil.today());
        System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthEnd());
        System.out.println(thisMonthLeftDay());
        System.out.println(thisMonthTotalDay());
    }
}

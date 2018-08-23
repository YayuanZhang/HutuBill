// 
// Decompiled by Procyon v0.5.30
// 

package gui.page;

public class SpendPage
{
    public String monthSpend;
    public String todaySpend;
    public String avgSpendPerDay;
    public String monthAvailable;
    public String dayAvgAvailable;
    public String monthLeftDay;
    public int usagePercentage;
    public boolean isOverSpend;
    
    public SpendPage(final int monthSpend, final int todaySpend, final int avgSpendPerDay, final int monthAvailable, final int dayAvgAvailable, final int monthLeftDay, final int usagePercentage) {
        this.isOverSpend = false;
        this.monthSpend = "\uffe5" + monthSpend;
        this.todaySpend = "\uffe5" + todaySpend;
        this.avgSpendPerDay = "\uffe5" + avgSpendPerDay;
        if (monthAvailable < 0) {
            this.isOverSpend = true;
        }
        if (!this.isOverSpend) {
            this.monthAvailable = "\uffe5" + monthAvailable;
            this.dayAvgAvailable = "\uffe5" + dayAvgAvailable;
        }
        else {
            this.monthAvailable = "\u8d85\u652f" + (0 - monthAvailable);
            this.dayAvgAvailable = "\uffe50";
        }
        this.monthLeftDay = String.valueOf(monthLeftDay) + "\u5929";
        this.usagePercentage = usagePercentage;
    }
}

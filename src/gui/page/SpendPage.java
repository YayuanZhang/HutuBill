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
        this.monthSpend = "￥" + monthSpend;
        this.todaySpend = "￥" + todaySpend;
        this.avgSpendPerDay = "￥" + avgSpendPerDay;
        if (monthAvailable < 0) {
            this.isOverSpend = true;
        }
        if (!this.isOverSpend) {
            this.monthAvailable = "￥" + monthAvailable;
            this.dayAvgAvailable = "￥" + dayAvgAvailable;
        }
        else {
            this.monthAvailable = "超支" + (0 - monthAvailable);
            this.dayAvgAvailable = "￥0";
        }
        this.monthLeftDay = String.valueOf(monthLeftDay) + "天";
        this.usagePercentage = usagePercentage;
    }
}

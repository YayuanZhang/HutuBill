// 
// Decompiled by Procyon v0.5.30
// 

package gui.panel;

import gui.page.SpendPage;
import service.SpendService;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Font;
import util.GUIUtil;
import javax.swing.JComponent;
import util.ColorUtil;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import util.CircleProgressBar;
import javax.swing.JLabel;

public class SpendPanel extends WorkingPanel
{
    public static SpendPanel instance;
    JLabel lMonthSpend;
    JLabel lTodaySpend;
    JLabel lAvgSpendPerDay;
    JLabel lMonthLeft;
    JLabel lDayAvgAvailable;
    JLabel lMonthLeftDay;
    JLabel vMonthSpend;
    JLabel vTodaySpend;
    JLabel vAvgSpendPerDay;
    JLabel vMonthAvailable;
    JLabel vDayAvgAvailable;
    JLabel vMonthLeftDay;
    CircleProgressBar bar;
    
    static {
        SpendPanel.instance = new SpendPanel();
    }
    
    public SpendPanel() {
        this.lMonthSpend = new JLabel("\u672c\u6708\u6d88\u8d39");
        this.lTodaySpend = new JLabel("\u4eca\u65e5\u6d88\u8d39");
        this.lAvgSpendPerDay = new JLabel("\u65e5\u5747\u6d88\u8d39");
        this.lMonthLeft = new JLabel("\u672c\u6708\u5269\u4f59");
        this.lDayAvgAvailable = new JLabel("\u65e5\u5747\u53ef\u7528");
        this.lMonthLeftDay = new JLabel("\u8ddd\u79bb\u6708\u672b");
        this.vMonthSpend = new JLabel("\uffe52300");
        this.vTodaySpend = new JLabel("\uffe525");
        this.vAvgSpendPerDay = new JLabel("\uffe5120");
        this.vMonthAvailable = new JLabel("\uffe52084");
        this.vDayAvgAvailable = new JLabel("\uffe5389");
        this.vMonthLeftDay = new JLabel("15\u5929");
        this.setLayout(new BorderLayout());
        (this.bar = new CircleProgressBar()).setBackgroundColor(ColorUtil.blueColor);
        GUIUtil.setColor(ColorUtil.grayColor, this.lMonthSpend, this.lTodaySpend, this.lAvgSpendPerDay, this.lMonthLeft, this.lDayAvgAvailable, this.lMonthLeftDay, this.vAvgSpendPerDay, this.vMonthAvailable, this.vDayAvgAvailable, this.vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, this.vMonthSpend, this.vTodaySpend);
        this.vMonthSpend.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", 1, 23));
        this.vTodaySpend.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", 1, 23));
        this.add(this.center(), "Center");
        this.add(this.south(), "South");
    }
    
    private JPanel center() {
        final JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(this.west(), "West");
        p.add(this.east());
        return p;
    }
    
    private Component east() {
        return this.bar;
    }
    
    private Component west() {
        final JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(this.lMonthSpend);
        p.add(this.vMonthSpend);
        p.add(this.lTodaySpend);
        p.add(this.vTodaySpend);
        return p;
    }
    
    private JPanel south() {
        final JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));
        p.add(this.lAvgSpendPerDay);
        p.add(this.lMonthLeft);
        p.add(this.lDayAvgAvailable);
        p.add(this.lMonthLeftDay);
        p.add(this.vAvgSpendPerDay);
        p.add(this.vMonthAvailable);
        p.add(this.vDayAvgAvailable);
        p.add(this.vMonthLeftDay);
        return p;
    }
    
    public static void main(final String[] args) {
        GUIUtil.showPanel(SpendPanel.instance);
    }
    
    @Override
    public void updateData() {
        final SpendPage spend = new SpendService().getSpendPage();
        this.vMonthSpend.setText(spend.monthSpend);
        this.vTodaySpend.setText(spend.todaySpend);
        this.vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        this.vMonthAvailable.setText(spend.monthAvailable);
        this.vDayAvgAvailable.setText(spend.dayAvgAvailable);
        this.vMonthLeftDay.setText(spend.monthLeftDay);
        this.bar.setProgress(spend.usagePercentage);
        if (spend.isOverSpend) {
            this.vMonthAvailable.setForeground(ColorUtil.warningColor);
            this.vMonthSpend.setForeground(ColorUtil.warningColor);
            this.vTodaySpend.setForeground(ColorUtil.warningColor);
        }
        else {
            this.vMonthAvailable.setForeground(ColorUtil.grayColor);
            this.vMonthSpend.setForeground(ColorUtil.blueColor);
            this.vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        this.bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
        this.addListener();
    }
    
    @Override
    public void addListener() {
    }
}

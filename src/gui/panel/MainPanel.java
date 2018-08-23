 package gui.panel;

import java.awt.event.ActionListener;
import gui.listener.ToolBarListener;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Component;
import util.GUIUtil;
import util.CenterPanel;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JPanel;

public class MainPanel extends JPanel
{
    public static MainPanel instance;
    public JToolBar tb;
    public JButton bSpend;
    public JButton bRecord;
    public JButton bCategory;
    public JButton bReport;
    public JButton bConfig;
    public JButton bBackup;
    public JButton bRecover;
    public CenterPanel workingPanel;
    
    static {
        GUIUtil.useLNF();
        MainPanel.instance = new MainPanel();
    }
    
    private MainPanel() {
        this.tb = new JToolBar();
        this.bSpend = new JButton();
        this.bRecord = new JButton();
        this.bCategory = new JButton();
        this.bReport = new JButton();
        this.bConfig = new JButton();
        this.bBackup = new JButton();
        this.bRecover = new JButton();
        GUIUtil.setImageIcon(this.bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(this.bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(this.bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(this.bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(this.bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(this.bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(this.bRecover, "restore.png", "恢复");
        this.tb.add(this.bSpend);
        this.tb.add(this.bRecord);
        this.tb.add(this.bCategory);
        this.tb.add(this.bReport);
        this.tb.add(this.bConfig);
        this.tb.add(this.bBackup);
        this.tb.add(this.bRecover);
        this.tb.setFloatable(false);
        this.workingPanel = new CenterPanel(0.8);
        this.setLayout(new BorderLayout());
        this.add(this.tb, BorderLayout.NORTH);
        this.add(this.workingPanel, BorderLayout.CENTER);
        this.addListener();
    }
    
    private void addListener() {
        final ToolBarListener listener = new ToolBarListener();
        this.bSpend.addActionListener(listener);
        this.bRecord.addActionListener(listener);
        this.bCategory.addActionListener(listener);
        this.bReport.addActionListener(listener);
        this.bConfig.addActionListener(listener);
        this.bBackup.addActionListener(listener);
        this.bRecover.addActionListener(listener);
    }
    
    public static void main(final String[] args) {
        GUIUtil.showPanel(MainPanel.instance, 1);
    }
}

// 
// Decompiled by Procyon v0.5.30
// 

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
        GUIUtil.setImageIcon(this.bSpend, "home.png", "\u6d88\u8d39\u4e00\u89c8");
        GUIUtil.setImageIcon(this.bRecord, "record.png", "\u8bb0\u4e00\u7b14");
        GUIUtil.setImageIcon(this.bCategory, "category2.png", "\u6d88\u8d39\u5206\u7c7b");
        GUIUtil.setImageIcon(this.bReport, "report.png", "\u6708\u6d88\u8d39\u62a5\u8868");
        GUIUtil.setImageIcon(this.bConfig, "config.png", "\u8bbe\u7f6e");
        GUIUtil.setImageIcon(this.bBackup, "backup.png", "\u5907\u4efd");
        GUIUtil.setImageIcon(this.bRecover, "restore.png", "\u6062\u590d");
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
        this.add(this.tb, "North");
        this.add(this.workingPanel, "Center");
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
        GUIUtil.showPanel(MainPanel.instance, 1.0);
    }
}

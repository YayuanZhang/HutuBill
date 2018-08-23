// 
// Decompiled by Procyon v0.5.30
// 

package gui.panel;

import service.ConfigService;
import java.awt.event.ActionListener;
import gui.listener.ConfigListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JComponent;
import util.ColorUtil;
import util.GUIUtil;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ConfigPanel extends WorkingPanel
{
    public static ConfigPanel instance;
    JLabel lBudget;
    public JTextField tfBudget;
    JLabel lMysql;
    public JTextField tfMysqlPath;
    JButton bSubmit;
    
    static {
        GUIUtil.useLNF();
        ConfigPanel.instance = new ConfigPanel();
    }
    
    public ConfigPanel() {
        this.lBudget = new JLabel("本月预算(￥)");
        this.tfBudget = new JTextField("0");
        this.lMysql = new JLabel("Mysql安装目录");
        this.tfMysqlPath = new JTextField("");
        this.bSubmit = new JButton("更新");
        GUIUtil.setColor(ColorUtil.grayColor, this.lBudget, this.lMysql);
        GUIUtil.setColor(ColorUtil.blueColor, this.bSubmit);
        final JPanel pInput = new JPanel();
        final JPanel pSubmit = new JPanel();
        final int gap = 40;
        pInput.setLayout(new GridLayout(4, 1, gap, gap));
        pInput.add(this.lBudget);
        pInput.add(this.tfBudget);
        pInput.add(this.lMysql);
        pInput.add(this.tfMysqlPath);
        pSubmit.add(this.bSubmit);
        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);
        this.add(pSubmit, BorderLayout.CENTER);
        this.addListener();
    }
    
    public static void main(final String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
    
    @Override
    public void addListener() {
        final ConfigListener l = new ConfigListener();
        this.bSubmit.addActionListener(l);
    }
    
    @Override
    public void updateData() {
        final String budget = new ConfigService().get(ConfigService.budget);
        final String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        this.tfBudget.setText(budget);
        this.tfMysqlPath.setText(mysqlPath);
        this.tfBudget.grabFocus();
    }
}

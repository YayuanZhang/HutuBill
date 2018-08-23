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
        this.lBudget = new JLabel("\u672c\u6708\u9884\u7b97(\uffe5)");
        this.tfBudget = new JTextField("0");
        this.lMysql = new JLabel("Mysql\u5b89\u88c5\u76ee\u5f55");
        this.tfMysqlPath = new JTextField("");
        this.bSubmit = new JButton("\u66f4\u65b0");
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
        this.add(pInput, "North");
        this.add(pSubmit, "Center");
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
        final String budget = new ConfigService().get("budget");
        final String mysqlPath = new ConfigService().get("mysqlPath");
        this.tfBudget.setText(budget);
        this.tfMysqlPath.setText(mysqlPath);
        this.tfBudget.grabFocus();
    }
}

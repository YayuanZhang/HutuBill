// 
// Decompiled by Procyon v0.5.30
// 

package gui.listener;

import service.ConfigService;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.io.File;
import util.GUIUtil;
import gui.panel.ConfigPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigListener implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        final ConfigPanel p = ConfigPanel.instance;
        if (!GUIUtil.checkNumber(p.tfBudget, "本月预算")) {
            return;
        }
        final String mysqlPath = p.tfMysqlPath.getText();
        if (mysqlPath.length() != 0) {
            final File commandFile = new File(mysqlPath, "bin/mysql.exe");
            if (!commandFile.exists()) {
                JOptionPane.showMessageDialog(p, "路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }
        final ConfigService cs = new ConfigService();
        cs.update("budget", p.tfBudget.getText());
        cs.update("mysqlPath", mysqlPath);
        JOptionPane.showMessageDialog(p, "修改成功");
    }
}

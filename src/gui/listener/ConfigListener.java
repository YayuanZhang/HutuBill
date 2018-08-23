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
        if (!GUIUtil.checkNumber(p.tfBudget, "\u672c\u6708\u9884\u7b97")) {
            return;
        }
        final String mysqlPath = p.tfMysqlPath.getText();
        if (mysqlPath.length() != 0) {
            final File commandFile = new File(mysqlPath, "bin/mysql.exe");
            if (!commandFile.exists()) {
                JOptionPane.showMessageDialog(p, "Mysql\u8def\u5f84\u4e0d\u6b63\u786e");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }
        final ConfigService cs = new ConfigService();
        cs.update("budget", p.tfBudget.getText());
        cs.update("mysqlPath", mysqlPath);
        JOptionPane.showMessageDialog(p, "\u8bbe\u7f6e\u4fee\u6539\u6210\u529f");
    }
}

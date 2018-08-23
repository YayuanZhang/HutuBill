// 
// Decompiled by Procyon v0.5.30
// 

package gui.listener;

import util.MysqlUtil;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JComponent;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import java.awt.Component;
import javax.swing.JOptionPane;
import service.ConfigService;
import gui.panel.BackupPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackupListener implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        final BackupPanel p = BackupPanel.instance;
        final String mysqlPath = new ConfigService().get("mysqlPath");
        if (mysqlPath.length() == 0) {
            JOptionPane.showMessageDialog(p, "\u5907\u4efd\u524d\u8bf7\u4e8b\u5148\u914d\u7f6emysql\u7684\u8def\u5f84");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return;
        }
        final JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return ".sql";
            }
            
            @Override
            public boolean accept(final File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });
        final int returnVal = fc.showSaveDialog(p);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if (returnVal == 0) {
            System.out.println(file);
            if (!file.getName().toLowerCase().endsWith(".sql")) {
                file = new File(file.getParent(), String.valueOf(file.getName()) + ".sql");
            }
            System.out.println(file);
            try {
                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(p, "\u5907\u4efd\u6210\u529f,\u5907\u4efd\u6587\u4ef6\u4f4d\u4e8e:\r\n" + file.getAbsolutePath());
            }
            catch (Exception e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(p, "\u5907\u4efd\u5931\u8d25\r\n,\u9519\u8bef:\r\n" + e2.getMessage());
            }
        }
    }
}

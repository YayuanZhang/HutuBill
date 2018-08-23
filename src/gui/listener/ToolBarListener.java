// 
// Decompiled by Procyon v0.5.30
// 

package gui.listener;

import gui.panel.RecoverPanel;
import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import gui.panel.CategoryPanel;
import javax.swing.JComponent;
import gui.panel.ReportPanel;
import javax.swing.JButton;
import gui.panel.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        final MainPanel p = MainPanel.instance;
        final JButton b = (JButton)e.getSource();
        if (b == p.bReport) {
            p.workingPanel.show(ReportPanel.instance);
        }
        if (b == p.bCategory) {
            p.workingPanel.show(CategoryPanel.instance);
        }
        if (b == p.bSpend) {
            p.workingPanel.show(SpendPanel.instance);
        }
        if (b == p.bRecord) {
            p.workingPanel.show(RecordPanel.instance);
        }
        if (b == p.bConfig) {
            p.workingPanel.show(ConfigPanel.instance);
        }
        if (b == p.bBackup) {
            p.workingPanel.show(BackupPanel.instance);
        }
        if (b == p.bRecover) {
            p.workingPanel.show(RecoverPanel.instance);
        }
    }
}

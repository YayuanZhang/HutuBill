// 
// Decompiled by Procyon v0.5.30
// 

package gui.listener;

import java.util.Date;
import entity.Category;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;
import javax.swing.JComponent;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import java.awt.Component;
import javax.swing.JOptionPane;
import gui.panel.RecordPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordListener implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        final RecordPanel p = RecordPanel.instance;
        if (p.cbModel.cs.size() == 0) {
            JOptionPane.showMessageDialog(p, "\u6682\u65e0\u6d88\u8d39\u5206\u7c7b\uff0c\u65e0\u6cd5\u6dfb\u52a0\uff0c\u8bf7\u5148\u589e\u52a0\u6d88\u8d39\u5206\u7c7b");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
        if (!GUIUtil.checkZero(p.tfSpend, "\u82b1\u8d39\u91d1\u989d")) {
            return;
        }
        final int spend = Integer.parseInt(p.tfSpend.getText());
        final Category c = p.getSelectedCategory();
        final String comment = p.tfComment.getText();
        final Date d = p.datepick.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(p, "\u6dfb\u52a0\u6210\u529f");
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}

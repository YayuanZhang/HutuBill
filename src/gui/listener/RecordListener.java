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
            JOptionPane.showMessageDialog(p, "暂无消费分类，无法添加，请先增加消费分类");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
        if (!GUIUtil.checkZero(p.tfSpend, "花费金额")) {
            return;
        }
        final int spend = Integer.parseInt(p.tfSpend.getText());
        final Category c = p.getSelectedCategory();
        final String comment = p.tfComment.getText();
        final Date d = p.datepick.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(p, "添加成功");
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}

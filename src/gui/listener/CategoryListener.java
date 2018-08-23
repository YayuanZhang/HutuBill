// 
// Decompiled by Procyon v0.5.30
// 

package gui.listener;

import entity.Category;
import service.CategoryService;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import gui.panel.CategoryPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener
{
    @Override
    public void actionPerformed(final ActionEvent e) {
        final CategoryPanel p = CategoryPanel.instance;
        final JButton b = (JButton)e.getSource();
        if (b == p.bAdd) {
            final String name = JOptionPane.showInputDialog(null);
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(p, "\u5206\u7c7b\u540d\u79f0\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
            new CategoryService().add(name);
        }
        if (b == p.bEdit) {
            final Category c = p.getSelectedCategory();
            final int id = c.id;
            final String name2 = JOptionPane.showInputDialog("\u4fee\u6539\u5206\u7c7b\u540d\u79f0", c.name);
            if (name2.length() == 0) {
                JOptionPane.showMessageDialog(p, "\u5206\u7c7b\u540d\u79f0\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
            new CategoryService().update(id, name2);
        }
        if (b == p.bDelete) {
            final Category c = p.getSelectedCategory();
            if (c.recordNumber != 0) {
                JOptionPane.showMessageDialog(p, "\u672c\u5206\u7c7b\u4e0b\u6709\u6d88\u8d39\u8bb0\u5f55\u5b58\u5728\uff0c\u4e0d\u80fd\u5220\u9664");
                return;
            }
            if (JOptionPane.showConfirmDialog(p, "\u786e\u8ba4\u8981\u5220\u9664\uff1f") != 0) {
                return;
            }
            final int id = c.id;
            new CategoryService().delete(id);
        }
        p.updateData();
    }
}

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
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
            new CategoryService().add(name);
        }
        if (b == p.bEdit) {
            final Category c = p.getSelectedCategory();
            final int id = c.id;
            final String name2 = JOptionPane.showInputDialog("修改分类名称", c.name);
            if (name2.length() == 0) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
            new CategoryService().update(id, name2);
        }
        if (b == p.bDelete) {
            final Category c = p.getSelectedCategory();
            if (c.recordNumber != 0) {
                JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
                return;
            }
            if (JOptionPane.showConfirmDialog(p, "确定要删除？") != 0) {
                return;
            }
            final int id = c.id;
            new CategoryService().delete(id);
        }
        p.updateData();
    }
}

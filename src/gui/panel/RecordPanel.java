// 
// Decompiled by Procyon v0.5.30
// 

package gui.panel;

import java.awt.event.ActionListener;
import gui.listener.RecordListener;
import service.CategoryService;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JComponent;
import util.ColorUtil;
import java.util.Date;
import javax.swing.ComboBoxModel;
import util.GUIUtil;
import javax.swing.JButton;
import org.jdesktop.swingx.JXDatePicker;
import entity.Category;
import javax.swing.JComboBox;
import gui.model.CategoryComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class RecordPanel extends WorkingPanel
{
    public static RecordPanel instance;
    JLabel lSpend;
    JLabel lCategory;
    JLabel lComment;
    JLabel lDate;
    public JTextField tfSpend;
    public CategoryComboBoxModel cbModel;
    public JComboBox<Category> cbCategory;
    public JTextField tfComment;
    public JXDatePicker datepick;
    JButton bSubmit;
    
    static {
        GUIUtil.useLNF();
        RecordPanel.instance = new RecordPanel();
    }
    
    public RecordPanel() {
        this.lSpend = new JLabel("\u82b1\u8d39(\uffe5)");
        this.lCategory = new JLabel("\u5206\u7c7b");
        this.lComment = new JLabel("\u5907\u6ce8");
        this.lDate = new JLabel("\u65e5\u671f");
        this.tfSpend = new JTextField("0");
        this.cbModel = new CategoryComboBoxModel();
        this.cbCategory = new JComboBox<Category>(this.cbModel);
        this.tfComment = new JTextField();
        this.datepick = new JXDatePicker(new Date());
        this.bSubmit = new JButton("\u8bb0\u4e00\u7b14");
        GUIUtil.setColor(ColorUtil.grayColor, this.lSpend, this.lCategory, this.lComment, this.lDate);
        GUIUtil.setColor(ColorUtil.blueColor, this.bSubmit);
        final JPanel pInput = new JPanel();
        final JPanel pSubmit = new JPanel();
        final int gap = 40;
        pInput.setLayout(new GridLayout(4, 2, gap, gap));
        pInput.add(this.lSpend);
        pInput.add(this.tfSpend);
        pInput.add(this.lCategory);
        pInput.add(this.cbCategory);
        pInput.add(this.lComment);
        pInput.add(this.tfComment);
        pInput.add(this.lDate);
        pInput.add(this.datepick);
        pSubmit.add(this.bSubmit);
        this.setLayout(new BorderLayout());
        this.add(pInput, "North");
        this.add(pSubmit, "Center");
        this.addListener();
    }
    
    public static void main(final String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }
    
    public Category getSelectedCategory() {
        return (Category)this.cbCategory.getSelectedItem();
    }
    
    @Override
    public void updateData() {
        this.cbModel.cs = new CategoryService().list();
        this.cbCategory.updateUI();
        this.resetInput();
        this.tfSpend.grabFocus();
    }
    
    public void resetInput() {
        this.tfSpend.setText("0");
        this.tfComment.setText("");
        if (this.cbModel.cs.size() != 0) {
            this.cbCategory.setSelectedIndex(0);
        }
        this.datepick.setDate(new Date());
    }
    
    @Override
    public void addListener() {
        final RecordListener listener = new RecordListener();
        this.bSubmit.addActionListener(listener);
    }
}

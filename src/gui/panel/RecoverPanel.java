package gui.panel;

import java.awt.event.ActionListener;
import gui.listener.RecoverListener;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JComponent;
import util.ColorUtil;
import util.GUIUtil;
import javax.swing.JButton;

public class RecoverPanel extends WorkingPanel
{
    public static RecoverPanel instance;
    JButton bRecover;
    
    static {
        GUIUtil.useLNF();
        RecoverPanel.instance = new RecoverPanel();
    }
    
    public RecoverPanel() {
        this.bRecover = new JButton("恢复");
        GUIUtil.setColor(ColorUtil.blueColor, this.bRecover);
        this.add(this.bRecover);
        this.addListener();
    }
    
    public static void main(final String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }
    
    @Override
    public void updateData() {
    }
    
    @Override
    public void addListener() {
        final RecoverListener listener = new RecoverListener();
        this.bRecover.addActionListener(listener);
    }
}

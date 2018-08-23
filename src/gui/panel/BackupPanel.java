// 
// Decompiled by Procyon v0.5.30
// 

package gui.panel;

import java.awt.event.ActionListener;
import gui.listener.BackupListener;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JComponent;
import util.ColorUtil;
import util.GUIUtil;
import javax.swing.JButton;

public class BackupPanel extends WorkingPanel
{
    public static BackupPanel instance;
    JButton bBackup;
    
    static {
        GUIUtil.useLNF();
        BackupPanel.instance = new BackupPanel();
    }
    
    public BackupPanel() {
        this.bBackup = new JButton("\u5907\u4efd");
        GUIUtil.setColor(ColorUtil.blueColor, this.bBackup);
        this.add(this.bBackup);
        this.addListener();
    }
    
    public static void main(final String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }
    
    @Override
    public void updateData() {
    }
    
    @Override
    public void addListener() {
        final BackupListener listener = new BackupListener();
        this.bBackup.addActionListener(listener);
    }
}

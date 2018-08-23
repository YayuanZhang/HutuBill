// 
// Decompiled by Procyon v0.5.30
// 

package gui.panel;

import javax.swing.JPanel;
import util.GUIUtil;
import java.awt.Image;
import entity.Record;
import java.util.List;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import util.ChartUtil;
import service.ReportService;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class ReportPanel extends WorkingPanel
{
    public static ReportPanel instance;
    JLabel l;
    
    static {
        ReportPanel.instance = new ReportPanel();
    }
    
    public ReportPanel() {
        this.l = new JLabel();
        this.setLayout(new BorderLayout());
        final List<Record> rs = new ReportService().listThisMonthRecords();
        final Image i = ChartUtil.getImage(rs, 400, 300);
        final ImageIcon icon = new ImageIcon(i);
        this.l.setIcon(icon);
        this.add(this.l);
        this.addListener();
    }
    
    public static void main(final String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }
    
    @Override
    public void updateData() {
        final List<Record> rs = new ReportService().listThisMonthRecords();
        final Image i = ChartUtil.getImage(rs, 350, 250);
        final ImageIcon icon = new ImageIcon(i);
        this.l.setIcon(icon);
    }
    
    @Override
    public void addListener() {
    }
}

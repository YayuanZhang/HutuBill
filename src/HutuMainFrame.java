import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.30
// 

class HutuMainFrame
{
    public static void main(final String[] args) {
        final JFrame f = new JFrame();
        f.setSize(500, 450);
        f.setTitle("\u4e00\u672c\u7cca\u6d82\u8d26");
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(3);
        final JToolBar tb = new JToolBar();
        final JButton bSpend = new JButton("\u6d88\u8d39\u4e00\u89c8");
        final JButton bRecord = new JButton("\u8bb0\u4e00\u7b14");
        final JButton bCategory = new JButton("\u6d88\u8d39\u5206\u7c7b");
        final JButton bReport = new JButton("\u6708\u6d88\u8d39\u62a5\u8868");
        final JButton bConfig = new JButton("\u8bbe\u7f6e");
        final JButton bBackup = new JButton("\u5907\u4efd");
        final JButton bRecover = new JButton("\u6062\u590d");
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        f.setLayout(new BorderLayout());
        f.add(tb, "North");
        f.add(new JPanel(), "Center");
        f.setVisible(true);
        bSpend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });
        bRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });
        bCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });
        bConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });
        bBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });
        bRecover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });
    }
}

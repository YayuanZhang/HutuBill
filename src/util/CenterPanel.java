package util;

import javax.swing.JButton;
import java.awt.Container;
import javax.swing.JFrame;
import gui.panel.WorkingPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class CenterPanel extends JPanel
{
    private double rate;
    private JComponent c;
    private boolean strech;
    
    public CenterPanel(final double rate, final boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }
    
    public CenterPanel(final double rate) {
        this(rate, true);
    }
    
    @Override
    public void repaint() {
        if (this.c != null) {
            final Dimension containerSize = this.getSize();
            final Dimension componentSize = this.c.getPreferredSize();
            if (this.strech) {
                this.c.setSize((int)(containerSize.width * this.rate), (int)(containerSize.height * this.rate));
            }
            else {
                this.c.setSize(componentSize);
            }
            this.c.setLocation(containerSize.width / 2 - this.c.getSize().width / 2, containerSize.height / 2 - this.c.getSize().height / 2);
        }
        super.repaint();
    }
    
    public void show(final JComponent p) {
        this.c = p;
        final Component[] cs = this.getComponents();
        Component[] array;
        for (int length = (array = cs).length, i = 0; i < length; ++i) {
            final Component c = array[i];
            this.remove(c);
        }
        this.add(p);
        if (p instanceof WorkingPanel) {
            ((WorkingPanel)p).updateData();
        }
        this.updateUI();
    }
    
    public static void main(final String[] args) {
        final JFrame f = new JFrame();
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);
        final CenterPanel cp = new CenterPanel(0.85, true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
        final JButton b = new JButton("abc");
        cp.show(b);
    }
}

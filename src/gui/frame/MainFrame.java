
package gui.frame;

import java.awt.Component;
import java.awt.Container;
import gui.panel.MainPanel;
import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    public static MainFrame instance;
    
    static {
        MainFrame.instance = new MainFrame();
    }
    
    private MainFrame() {
        this.setSize(500, 450);
        this.setTitle("\u4e00\u672c\u7cca\u6d82\u8d26");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
    }
    
    public static void main(final String[] args) {
        MainFrame.instance.setVisible(true);
    }
}

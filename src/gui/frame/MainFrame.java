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
        this.setSize(425, 500);
        this.setTitle("一本糊涂帐");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(final String[] args) {
        MainFrame.instance.setVisible(true);
    }
}

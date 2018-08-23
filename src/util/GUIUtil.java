package util;

import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;
import java.net.URL;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.io.File;
import javax.swing.JButton;

public class GUIUtil
{
    private static String imageFolder;
    
    static {
        GUIUtil.imageFolder = "/home/luviszero/eclipse-workspace/HutuBill/img/";
    }
    
    public static void setImageIcon(JButton b, String fileName,  String tip) {
        File f = new File(GUIUtil.imageFolder, fileName);
        ImageIcon i = null;
        if (f.exists()) {
            i = new ImageIcon(f.getAbsolutePath());
        }
        else {
            URL u = ClassLoader.getSystemResource("img/"+fileName);
            System.out.println(u);
            i = new ImageIcon(u);
        }
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(3);
        b.setHorizontalTextPosition(0);
        b.setText(tip);
    }
    
    public static void setColor( Color color, JComponent... cs) {
        for (final JComponent c : cs) {
            c.setForeground(color);
        }
    }
    
    public static void showPanel(JPanel p,  double strechRate) {
        useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strechRate);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
        cp.show(p);
    }
    
    public static void showPanel( JPanel p) {
        showPanel(p, 0.85);
    }
    
    public static boolean checkNumber(JTextField tf, String input) {
        if (!checkEmpty(tf, input)) {
            return false;
        }
        final String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        }
        catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, String.valueOf(input) + " \u9700\u8981\u662f\u6574\u6570");
            tf.grabFocus();
            return false;
        }
    }
    
    public static boolean checkZero(final JTextField tf, final String input) {
        if (!checkNumber(tf, input)) {
            return false;
        }
        final String text = tf.getText().trim();
        if (Integer.parseInt(text) == 0) {
            JOptionPane.showMessageDialog(null, String.valueOf(input) + " \u4e0d\u80fd\u4e3a\u96f6");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    
    public static boolean checkEmpty(final JTextField tf, final String input) {
        final String text = tf.getText().trim();
        if (text.length() == 0) {
            JOptionPane.showMessageDialog(null, String.valueOf(input) + " \u4e0d\u80fd\u4e3a\u7a7a");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    
    public static int getInt(final JTextField tf) {
        return Integer.parseInt(tf.getText());
    }
    
    public static void useLNF() {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

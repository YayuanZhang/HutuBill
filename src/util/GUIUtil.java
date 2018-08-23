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
    private static String imageFolder = "/home/luviszero/eclipse-workspace/HutuBill/img";
  
    
    public static void setImageIcon(JButton b, String fileName,  String tip) {
    	ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 105));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
    
    public static void setColor( Color color, JComponent... cs) {
        for (final JComponent c : cs) {
            c.setForeground(color);
        }
    }
    
    public static void showPanel(JPanel p,  double strechRate) {
    	GUIUtil.useLNF();
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
        String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        }
        catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, String.valueOf(input) + "  需要是整数");
            tf.grabFocus();
            return false;
        }
    }
    
    public static boolean checkZero(JTextField tf, String input) {
        if (!checkNumber(tf, input)) {
            return false;
        }
        String text = tf.getText().trim();
        if (Integer.parseInt(text) == 0) {
            JOptionPane.showMessageDialog(null, String.valueOf(input) + " 不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    
    public static boolean checkEmpty(JTextField tf, String input) {
        String text = tf.getText().trim();
        if (text.length() == 0) {
            JOptionPane.showMessageDialog(null, String.valueOf(input) + " 不能为空");
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

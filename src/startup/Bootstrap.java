
package startup;

import javax.swing.SwingUtilities;
import javax.swing.JComponent;
import gui.panel.SpendPanel;
import gui.panel.MainPanel;
import gui.frame.MainFrame;
import util.GUIUtil;

public class Bootstrap
{
    public static void main(String[] args) throws Exception {
        GUIUtil.useLNF();
        //
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}

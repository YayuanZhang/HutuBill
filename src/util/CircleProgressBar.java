package util;

import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class CircleProgressBar extends JPanel
{
    private int minimumProgress;
    private int maximumProgress;
    private int progress;
    private String progressText;
    private Color backgroundColor;
    private Color foregroundColor;
    
    public CircleProgressBar() {
        this.minimumProgress = 0;
        this.maximumProgress = 100;
        this.progressText = "0%";
    }
    
    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        final Graphics2D graphics2d = (Graphics2D)g;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int fontSize = 0;
        if (this.getWidth() >= this.getHeight()) {
            x = (this.getWidth() - this.getHeight()) / 2 + 25;
            y = 25;
            width = this.getHeight() - 50;
            height = this.getHeight() - 50;
            fontSize = this.getWidth() / 8;
        }
        else {
            x = 25;
            y = (this.getHeight() - this.getWidth()) / 2 + 25;
            width = this.getWidth() - 50;
            height = this.getWidth() - 50;
            fontSize = this.getHeight() / 8;
        }
        graphics2d.setStroke(new BasicStroke(20.0f));
        graphics2d.setColor(this.backgroundColor);
        graphics2d.drawArc(x, y, width, height, 0, 360);
        graphics2d.setColor(this.foregroundColor);
        graphics2d.drawArc(x, y, width, height, 90, -(int)(360.0 * (this.progress * 1.0 / (this.maximumProgress - this.minimumProgress))));
        graphics2d.setFont(new Font("\u9ed1\u4f53", 1, fontSize));
        final FontMetrics fontMetrics = graphics2d.getFontMetrics();
        final int digitalWidth = fontMetrics.stringWidth(this.progressText);
        final int digitalAscent = fontMetrics.getAscent();
        graphics2d.setColor(this.foregroundColor);
        graphics2d.drawString(this.progressText, this.getWidth() / 2 - digitalWidth / 2, this.getHeight() / 2 + digitalAscent / 2);
    }
    
    public int getProgress() {
        return this.progress;
    }
    
    public void setProgress(final int progress) {
        if (progress >= this.minimumProgress && progress <= this.maximumProgress) {
            this.progress = progress;
        }
        if (progress > this.maximumProgress) {
            this.progress = this.maximumProgress;
        }
        this.progressText = String.valueOf(String.valueOf(progress) + "%");
        this.repaint();
    }
    
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }
    
    public void setBackgroundColor(final Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }
    
    public Color getForegroundColor() {
        return this.foregroundColor;
    }
    
    public void setForegroundColor(final Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        this.repaint();
    }
}

// 
// Decompiled by Procyon v0.5.30
// 

package util;

import java.awt.Color;

public class ColorUtil
{
    public static Color blueColor;
    public static Color grayColor;
    public static Color backgroundColor;
    public static Color warningColor;
    
    static {
        ColorUtil.blueColor = Color.decode("#3399FF");
        ColorUtil.grayColor = Color.decode("#999999");
        ColorUtil.backgroundColor = Color.decode("#eeeeee");
        ColorUtil.warningColor = Color.decode("#FF3333");
    }
    
    public static Color getByPercentage(int per) {
        if (per > 100) {
            per = 100;
        }
        int r = 51;
        int g = 255;
        final int b = 51;
        final float rate = per / 100.0f;
        r = (int)(204.0f * rate + 51.0f);
        g = 255 - r + 51;
        final Color color = new Color(r, g, b);
        return color;
    }
}

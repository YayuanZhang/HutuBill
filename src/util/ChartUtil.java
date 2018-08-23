package util;

import javax.swing.Icon;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import com.objectplanet.chart.BarChart;
import java.awt.Color;
import java.awt.Image;
import entity.Record;
import java.util.List;

public class ChartUtil
{
    private static String[] sampleLabels(final List<Record> rs) {
        final String[] sampleLabels = new String[rs.size()];
        for (int i = 0; i < sampleLabels.length; ++i) {
            if (i % 5 == 0) {
                sampleLabels[i] = String.valueOf(String.valueOf(i + 1) + "\u65e5");
            }
        }
        return sampleLabels;
    }
    
    public static double[] sampleValues(final List<Record> rs) {
        final double[] sampleValues = new double[rs.size()];
        for (int i = 0; i < sampleValues.length; ++i) {
            sampleValues[i] = rs.get(i).spend;
        }
        return sampleValues;
    }
    
    public static Image getImage(final List<Record> rs, final int width, final int height) {
        final double[] sampleValues = sampleValues(rs);
        final String[] sampleLabels = sampleLabels(rs);
        final int max = max(sampleValues);
        final Color[] sampleColors = { ColorUtil.blueColor };
        final BarChart chart = new BarChart();
        chart.setSampleCount(sampleValues.length);
        chart.setSampleValues(0, sampleValues);
        chart.setSampleLabels(sampleLabels);
        chart.setSampleColors(sampleColors);
        chart.setRange(0, max * 1.2);
        chart.setValueLinesOn(true);
        chart.setSampleLabelsOn(true);
        chart.setSampleLabelStyle(2);
        chart.setFont("rangeLabelFont", new Font("Arial", 1, 12));
        chart.setLegendOn(true);
        chart.setLegendPosition(0);
        chart.setLegendLabels(new String[] { "\u6708\u6d88\u8d39\u62a5\u8868" });
        chart.setFont("legendFont", new Font("Dialog", 1, 13));
        chart.setFont("sampleLabelFont", new Font("Dialog", 1, 13));
        chart.setChartBackground(Color.white);
        chart.setBackground(ColorUtil.backgroundColor);
        final Image im = chart.getImage(width, height);
        return im;
    }
    
    public static int max(final double[] sampleValues) {
        int max = 0;
        for (final double v : sampleValues) {
            if (v > max) {
                max = (int)v;
            }
        }
        return max;
    }
    
    private static String[] sampleLabels() {
        final String[] sampleLabels = new String[30];
        for (int i = 0; i < sampleLabels.length; ++i) {
            if (i % 5 == 0) {
                sampleLabels[i] = String.valueOf(String.valueOf(i + 1) + "\u65e5");
            }
        }
        return sampleLabels;
    }
    
    public static Image getImage(final int width, final int height) {
        final double[] sampleValues = sampleValues();
        final String[] sampleLabels = sampleLabels();
        final int max = max(sampleValues);
        final Color[] sampleColors = { ColorUtil.blueColor };
        final BarChart chart = new BarChart();
        chart.setSampleCount(sampleValues.length);
        chart.setSampleValues(0, sampleValues);
        chart.setSampleLabels(sampleLabels);
        chart.setSampleColors(sampleColors);
        chart.setRange(0, max * 1.2);
        chart.setValueLinesOn(true);
        chart.setSampleLabelsOn(true);
        chart.setSampleLabelStyle(2);
        chart.setFont("rangeLabelFont", new Font("Arial", 1, 12));
        chart.setLegendOn(true);
        chart.setLegendPosition(0);
        chart.setLegendLabels(new String[] { "\u6708\u6d88\u8d39\u62a5\u8868" });
        chart.setFont("legendFont", new Font("Dialog", 1, 13));
        chart.setFont("sampleLabelFont", new Font("Dialog", 1, 13));
        chart.setChartBackground(Color.white);
        chart.setBackground(ColorUtil.backgroundColor);
        final Image im = chart.getImage(width, height);
        return im;
    }
    
    private static double[] sampleValues() {
        final double[] result = new double[30];
        for (int i = 0; i < result.length; ++i) {
            result[i] = (int)(Math.random() * 300.0);
        }
        return result;
    }
    
    public static void main(final String[] args) {
        final JPanel p = new JPanel();
        final JLabel l = new JLabel();
        final Image img = getImage(400, 300);
        final Icon icon = new ImageIcon(img);
        l.setIcon(icon);
        p.add(l);
        GUIUtil.showPanel(p);
    }
}

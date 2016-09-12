/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 */
package org.sample.tradeprocessor;

import java.awt.Color;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeChartServlet
extends HttpServlet {
    private static final long serialVersionUID = 1;
    public static int EN = 1;
    public static int US = 1;
    public static int FR = 1;
    public static int DE = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        ServletOutputStream os = response.getOutputStream();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue((Number)new Integer(EN), (Comparable)((Object)"Values"), (Comparable)((Object)"EN"));
        dataset.setValue((Number)new Integer(US), (Comparable)((Object)"Values"), (Comparable)((Object)"US"));
        dataset.setValue((Number)new Integer(FR), (Comparable)((Object)"Values"), (Comparable)((Object)"FR"));
        dataset.setValue((Number)new Integer(DE), (Comparable)((Object)"Values"), (Comparable)((Object)"DE"));
        JFreeChart chart = ChartFactory.createLineChart((String)"Trades by Originating Country", (String)"Originating Countries", (String)"Trades", (CategoryDataset)dataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)true);
        chart.setBorderPaint((Paint)Color.YELLOW);
        chart.getTitle().setPaint((Paint)Color.RED);
        BufferedImage chartImage = chart.createBufferedImage(700, 500);
        ImageIO.write((RenderedImage)chartImage, "png", (OutputStream)os);
        os.flush();
        os.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

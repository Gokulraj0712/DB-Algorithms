package com.exercise2.Gokulraj.Venugopal;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLogExercise extends ApplicationFrame{

	   
	    public XYLogExercise(final String title) {

	        super(title);

	        final XYSeries s1 = new XYSeries("Prefix Average 1"); //Used for plotting prefixAverage1
	        final XYSeries s2 = new XYSeries("Prefix Average 2"); //Used for plotting prefixAverage2
	        
	        int n=10;
	        for (int i = 1; i <= 5; i++) //Executes 6 times
	        {	//executes 5 times
	        	//Elapsed time for executing prefixAverage1 function is added to s1
	            s1.add(Math.pow(n, i), PrefixAverage.PreAvgTime1( Math.pow(n, i)));
	          //Elapsed time for executing prefixAverage2 function is added to s2
	            s2.add(Math.pow(n, i), PrefixAverage.PreAvgTime2( Math.pow(n, i)) );
	        }

	        //XYSeriesCollection is declared and the XYSeries s1 and s2 is added
	        final XYSeriesCollection ds = new XYSeriesCollection();
	        ds.addSeries(s1);
	        ds.addSeries(s2);

	        //JFreeChart is declared and the Title,x-axis label, y-axis label and data is defined
	        final JFreeChart chart = ChartFactory.createXYLineChart(
	            "Prefix Average Exercise",     // chart title 
	            "Category",               // domain axis label
	            "Value",                  // range axis label
	            ds,                  // data
	            PlotOrientation.VERTICAL,
	            true,                     
	            true,
	            false
	        );

	        //Plot Declaration and adding X and Y axis display names
	        final XYPlot graph = chart.getXYPlot();
	        final NumberAxis domainAxis = new LogarithmicAxis("Log(N) (Array Size)");
	        final NumberAxis rangeAxis = new LogarithmicAxis("Log(Time) (Elapsed Time)");
	        graph.setDomainAxis(domainAxis);
	        graph.setRangeAxis(rangeAxis);
	        
	        //Setting background and outline color for the chart
	        chart.setBackgroundPaint(Color.lightGray);
	        graph.setOutlinePaint(Color.white);
	        
	        //Plotting in chart and dimension declaration for the window
	        final ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
	        setContentPane(chartPanel);
	    }
	    
	    /** 
		 *************************************************
		 *****************Main Method*********************
		 *************************************************
		 *
		 *
		 *************************************************
		 ********Student Name: Gokulraj Venugopal*********
		 ********Student ID: 301202722********************
		 *  **********************************************
		 *
		 **/
	    public static void main(final String[] args) {
	    	System.gc();
	    	//Initializing class Object
	        final XYLogExercise ex = new XYLogExercise("XY Log Axes Exercise");
	        ex.pack();
	        RefineryUtilities.centerFrameOnScreen(ex);
	        ex.setVisible(true);
	    }
	}


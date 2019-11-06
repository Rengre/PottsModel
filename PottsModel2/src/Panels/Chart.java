package Panels;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Chart extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static XYSeries series1 = new XYSeries("Magnetization");
	public static XYSeriesCollection dataset1= new XYSeriesCollection(series1);
	public JFreeChart charts1= ChartFactory.createXYLineChart("Magnetization", "","", dataset1);
	
	public static XYSeries series2 = new XYSeries("Energy");
	public static XYSeriesCollection dataset2= new XYSeriesCollection(series2);
	public JFreeChart charts2= ChartFactory.createXYLineChart("Energy", "","", dataset2);
	

	public Chart() {
		charts1.removeLegend();
		charts2.removeLegend();
	}
	  
}

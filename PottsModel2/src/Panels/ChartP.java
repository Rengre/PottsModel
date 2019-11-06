package Panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

public class ChartP extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Chart chart1 = new Chart();
	private Chart chart2 = new Chart();
	
	public ChartP() {
		setLayout(new GridLayout(2,1));
		add(new ChartPanel(chart1.charts1));
		add(new ChartPanel(chart2.charts2));
	}
}

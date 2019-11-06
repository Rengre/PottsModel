package Panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;



public class LeftPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//private RandomButton random = new RandomButton();
	private ControlPanel controls = new ControlPanel();
	Menu menu = new Menu();
	private ChartP chart12 = new ChartP();
	
	public LeftPanel() {

	setLayout(new BorderLayout());
	add(menu,BorderLayout.NORTH);
	add(chart12,BorderLayout.CENTER);
	add(controls,BorderLayout.SOUTH);
	
	setBackground(Color.WHITE);
	}

}

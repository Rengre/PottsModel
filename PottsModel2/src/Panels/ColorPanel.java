package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import Mechanics.Potts;

public class ColorPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private double xgap = 1;
	private double ygap = 1;
	
	private double x = 500/Potts.GetSizeX();
	private double y = 500/Potts.GetSizeY();
	private double w = 500/Potts.GetSizeX();
	private double h = 500/Potts.GetSizeY();
	
	Rectangle2D.Double[][] rect;
	
	public ColorPanel() {
		rect =  new Rectangle2D.Double[Potts.GetSizeX()][Potts.GetSizeY()];
	}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    
	    for(int i = 0; i < Potts.GetSizeX(); i++) {
	    for(int j = 0; j < Potts.GetSizeY(); j++) {
	    rect[i][j] = new Rectangle2D.Double(x * i , y * j , w - xgap, h - ygap);
	    g2.draw(rect[i][j]);
	    }}
	    
	    
	    for(int i = 0; i < Potts.GetSizeX(); i++) {
			for(int j = 0; j < Potts.GetSizeY(); j++) {
				
				if(NodesPanel.tab[i][j]==1) {
					g2.setPaint(Color.BLUE);
				    g2.fill(rect[i][j]);
				};
				if(NodesPanel.tab[i][j]==2) {
					g2.setPaint(Color.GREEN);
				    g2.fill(rect[i][j]);
				};
				if(NodesPanel.tab[i][j]==3) {
					g2.setPaint(Color.YELLOW);
				    g2.fill(rect[i][j]);
				};
				if(NodesPanel.tab[i][j]==4) {
					g2.setPaint(Color.RED);
				    g2.fill(rect[i][j]);
				};
				if(NodesPanel.tab[i][j]==5) {
					g2.setPaint(Color.CYAN);
				    g2.fill(rect[i][j]);
				};
				if(NodesPanel.tab[i][j]==6) {
					g2.setPaint(Color.PINK);
				    g2.fill(rect[i][j]);
				};
			}}
	
	}

}
	


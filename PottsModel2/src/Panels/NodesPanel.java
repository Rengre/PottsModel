package Panels;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

import Mechanics.Potts;

public class NodesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	static Potts potts = new Potts();
	
	private static int x = Potts.GetSizeX();
	private static int y = Potts.GetSizeY();
	private static Random rand = new Random();
	
	public static int[][] array = new int [x][y];
	public static int[][] tab = losowanie(Potts.Getq(),array);
	
	static ColorPanel color = new ColorPanel();
	
	public static int[][] GetNodesRandTab(){
		return tab;
	}
	
	public static void SetNodesRandTab(int [][]array){
		tab = losowanie(Potts.Getq(),array);
	}
	
	public static int[][] GetNodesArray(){
		return array;
	}
	
	public static void NodesPanelSetColor(ColorPanel c) {
		color = c;
	}
	
	public static ColorPanel NodesPanelGetColor() {
		return color;
	}
	
	
	
	public NodesPanel() {
		
	this.setLayout(new GridLayout(1,1));;
	this.add(color);
	
	}
	
	public static int[][] losowanie(int stany, int[][] wezly) {
		for(int i = 0; i<x; i++)
			for(int j = 0; j<y; j++)
				wezly[i][j] = rand.nextInt(stany)+1;
		return wezly;
	}
	
}

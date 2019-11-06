package Mechanics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Panels.Chart;
import Panels.ColorPanel;
import Panels.NodesPanel;

public class Potts extends Thread implements Runnable{

	private static Random rand = new Random();
	private static int sizex;
	private static int sizey;
	private static int q;
	private static double T;
	private static int time;
	private static int N;
	private static int l;
	private static int symtime;
	private static double Mmax;
	private static double Emin;
	private static double dT;
	private static double Tmax;
	public static int[][] tab = NodesPanel.GetNodesRandTab();
	private static ColorPanel color = NodesPanel.NodesPanelGetColor();
	private static Magnetization Mag = new Magnetization();
	private static Energy Ene = new Energy();
	private static Links L = new Links();
	public static List<Double> listM = new ArrayList<>();
	public static List<Double> listE = new ArrayList<>();
	public static List<Double> listA = new ArrayList<>();
	
	
	public Potts() {
		sizex = 100;
		sizey = 100;
		q = 2;
		T = 0.81;
		dT = 0.01;
		Tmax = 0.9;
		N = sizex * sizey;
		l = 0;
		time = 0;
		symtime = 20000;
		Mmax = 2*N*(1-1/q);
		Emin = 2*N;
	}
	
	public static void SetSizeX(int x) {
		sizex = x;
	}
	
	public static void SetSizeY(int y) {
		sizey = y;
	}
	
	public static void Setq(int s) {
		q = s;
	}
	
	public static void SetT(double t) {
		T = t;
	}
	
	public static int GetSizeX() {
		return sizex;
	}
	
	public static int GetSizeY() {
		return sizey;
	}
	
	public static int Getq() {
		return q;
	}
	
	public static double Getqd() {
		return q;
	}
	
	public static double GetT() {
		return T;
	}
	
public void PottsSim() {
	
		color.repaint();
	
		int x = rand.nextInt(sizex);
		int y = rand.nextInt(sizey);
		
		final double k = 1.38064852 * Math.pow(10,-23);
		final double J = k;
		
		boolean xp , xl, yg , yd , xp2 , xl2 , yg2 , yd2;
		
		int x1 = x+1 , x2 = x-1 , y1 = y+1 , y2 = y-1;
		
		double p = 0;
		
		if(x+1 > sizex-1) x1 = 0;
		if(x-1 < 0) x2 = sizex-1;
		if(y+1 > sizey-1) y1 = 0;
		if(y-1 < 0) y2 = sizey-1;

		xp = (tab[x1][y] == tab[x][y]);
		xl = (tab[x2][y] == tab[x][y]);
		yg = (tab[x][y1] == tab[x][y]);
		yd = (tab[x][y2] == tab[x][y]);
		xp2 = (tab[x1][y] == tab[x][y]);
		xl2 = (tab[x2][y] == tab[x][y]);
		yg2 = (tab[x][y1] == tab[x][y]);
		yd2 = (tab[x][y2] == tab[x][y]);
		
		double h1 = -J*((xp ? 1 : 0) + (xl ? 1 : 0) + (yg ? 1 : 0) + (yd ? 1 : 0));
		int ns;
		
		do
		{
			ns = rand.nextInt(q)+1;
		}while(ns == tab[x][y]);
		
		xp2 = (tab[x1][y] == ns);
		xl2 = (tab[x2][y] == ns);
		yg2 = (tab[x][y1] == ns);
		yd2 = (tab[x][y2] == ns);
		
		double h2 = -J*((xp2 ? 1 : 0) + (xl2 ? 1 : 0) + (yg2 ? 1 : 0) + (yd2 ? 1 : 0));
		
		double dE = h2 - h1;
		
		if(dE < 0) {
			tab[x][y] = ns;
		}
		
		if(dE > 0) {
			if(T == 0) p = 0;
			if(T != 0) p = Math.exp(-dE/(k*T));	
			
			if(rand.nextDouble() < p)
				tab[x][y] = ns;
			
		}
		
		}

	@Override
	public synchronized void run() {
		
		FileWriter outM = null;
		FileWriter outE = null;
		FileWriter outA = null;
		
		while(true) {
			PottsSim();
			l++;
			if(l == N) {
					l = 0;
					Chart.series1.add(time,Magnetization.GetMag()/Mmax);
					Chart.series2.add(time,Energy.getEnergy()/Emin);
					listM.add(Magnetization.GetMag()/Mmax);
					listE.add(Energy.getEnergy()/Emin);
					listA.add(Links.getLinks());
					time++;
					
					if(time==1) {
						try {
							outM = new FileWriter("M"+"q"+q+"_T"+T+"_"+"P"+".txt",true);
							outE = new FileWriter("E"+"q"+q+"_T"+T+"_"+"P"+".txt",true);
							outA = new FileWriter("A"+"q"+q+"_T"+T+"_"+"P"+".txt",true);
						} catch (IOException e) {}
					}
					
					if(listM.size() == 5000) {
						try {
							for (Double element : Potts.listM)				
								outM.write(Double.toString(element)+" \r\n");
							for (Double element : Potts.listE)
								outE.write(Double.toString(element)+" \r\n");
							for (Double element : Potts.listA)				
								outA.write(Double.toString(element)+" \r\n");
						} catch (IOException e) {}
						listM.clear();
						listE.clear();
						listA.clear();
					}
					
					if(time==symtime) {
						try {
							outM.close();
							outE.close();
							outA.close();
							}
						catch (IOException d) {}
						
						Chart.series1.clear();
						Chart.series2.clear();
						
						NodesPanel.SetNodesRandTab(NodesPanel.array);
						
						time=0;
						Potts.SetT(T+dT);
						
						if(T>Tmax) {
							System.exit(0);
						}
						
			}
			};
			
		}
	}

}

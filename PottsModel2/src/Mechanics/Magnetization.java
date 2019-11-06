package Mechanics;
import Panels.NodesPanel;

public class Magnetization extends Thread implements Runnable{
	
	//private double magnet[] = new double[Potts.GetSizeX() * Potts.GetSizeY()];
	public static double[] mag;
	private static double mag2;
	private static double N = Potts.GetSizeX()*Potts.GetSizeY();
	private static double[] xs;
	//public static List<Double> listM = new ArrayList<>();
	public Magnetization() {
		mag2 = 0;
		mag = new double [Potts.GetSizeX()*Potts.GetSizeY()];
		N = Potts.GetSizeX()*Potts.GetSizeY();
		xs = new double [6];
		for(int i = 0; i<Potts.Getq(); i++)
			xs[i] = 0.0;
		//for(int ii=0;ii<N;ii++) 
			//listM.add(GetMag());
			//mag[i]=GetMag();
		}
	
	public static double[] Getxs() {
		for(int i = 0; i<Potts.Getq(); i++)
			xs[i] = 0.0;
		
		for(int i = 0; i<Potts.GetSizeX();i++)
			for(int j = 0; j<Potts.GetSizeY();j++)
				xs[NodesPanel.tab[i][j]-1]++;
		return xs;
	}
	
	public static double GetMag() {
		mag2 = 0;
		for(int i = 0; i < Potts.Getq(); i++)
			mag2 += Math.abs(Getxs()[i] - N/Potts.Getqd()); 
      
		return mag2;
	}
	
}

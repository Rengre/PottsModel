package Mechanics;

public class Energy {

	private static double E = 0;
	//private static double N = Potts.GetSizeX()*Potts.GetSizeY();
	static final double k = 1.38064852 * Math.pow(10,-23);
	static boolean xp , xl, yg , yd;
	static int x1 , x2 , y1 , y2;
	static int x = 0, y = 0;
	
	public Energy() {
		
	}
	
	public static double getEnergy() {
		
		E = 0;
		
		for(x=0 ; x < Potts.GetSizeX(); x++) {
			for(y=0 ; y < Potts.GetSizeY(); y++) {
				x1 = x+1 ; x2 = x-1 ; y1 = y+1 ; y2 = y-1;
				if(x+1 > Potts.GetSizeX()-1) x1 = 0;
				if(x-1 < 0) x2 = Potts.GetSizeX()-1;
				if(y+1 > Potts.GetSizeY()-1) y1 = 0;
				if(y-1 < 0) y2 = Potts.GetSizeY()-1;
				
				xp = (Potts.tab[x1][y] == Potts.tab[x][y]);
				xl = (Potts.tab[x2][y] == Potts.tab[x][y]);
				yd = (Potts.tab[x][y1] == Potts.tab[x][y]);
				yg = (Potts.tab[x][y2] == Potts.tab[x][y]);
				
				E += -((xp ? 1 : 0) + (xl ? 1 : 0) + (yg ? 1 : 0) + (yd ? 1 : 0));
				
			}
		}	
		return E;
			
	}
	
}

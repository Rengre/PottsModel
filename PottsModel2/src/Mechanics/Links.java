package Mechanics;

public class Links {

	private static double A = 0;
	static boolean xp , yd;
	static int x1 , y1;
	static int x = 0, y = 0;
	
	public Links() {
		
	}
	
	public static double getLinks() {
	
		A=0;
		for(x=0 ; x < Potts.GetSizeX(); x++) {
			for(y=0 ; y < Potts.GetSizeY(); y++) {
				x1 = x+1 ; y1 = y+1;
				if(x+1 > Potts.GetSizeX()-1) x1 = 0;
				if(y+1 > Potts.GetSizeY()-1) y1 = 0;
				
				xp = (Potts.tab[x1][y] == Potts.tab[x][y]);
				yd = (Potts.tab[x][y1] == Potts.tab[x][y]);
				
				A += ((xp ? 0 : 1) + (yd ? 0 : 1));
		
			}}
		return A;
	}
	
}

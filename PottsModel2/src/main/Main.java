package main;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Mechanics.Potts;
import Panels.LeftPanel;
import Panels.NodesPanel;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	NodesPanel nodes = new NodesPanel();
	LeftPanel left = new LeftPanel();
	//Menu menu = new Menu();
	static Potts potts = new Potts();
	//static Magnetization mag = new Magnetization();
	
	public Main() {
		super("Potts Model");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1016, 539);
		setLayout(new GridLayout(1,2));
		
		add(left);
		add(nodes);
	//	left.add(menu);
		
		potts.start();
		//mag.start();
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public synchronized void run() {
				JFrame f = new Main();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				
			}
		});
		
		}
	
}



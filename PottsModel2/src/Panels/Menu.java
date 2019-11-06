package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Mechanics.Potts;

public class Menu extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	private JMenuItem ustawienia = new JMenuItem("Ustawienia parametrów");
	private JMenuItem wykres = new JMenuItem("Wykresy");
	private JMenu opcje = new JMenu("Opcje");
	private JMenuItem zapiszM = new JMenuItem("Zapisz magnetyzacje");
	private JMenuItem zapiszE = new JMenuItem("Zapisz energie");
	//private static int time=0;	
	
	public Menu() {
		//add(ustawienia);
		//add(wykres);
		add(opcje);
		opcje.add(zapiszM);
		opcje.add(zapiszE);
		
		ustawienia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new ParametersFrame();
				
			}
			});
		/*wykres.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread() {
					@Override
					public void run() {
						
						Chart.series.add(time,Magnetization.GetMag());
					}
				};
				time++;
				thread.start();
				
			}
		
			});*/
		zapiszM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			//	int odpowiedz = jFileChooserZapiszPlik.showSaveDialog(pole);
			//	if (odpowiedz == JFileChooser.APPROVE_OPTION) {
				chooser.setDialogTitle("Zapisz plik");

				int result = chooser.showDialog(null, "Save");
				@SuppressWarnings("unused")
				File file;
				if (JFileChooser.APPROVE_OPTION == result) {

					if (result != JFileChooser.APPROVE_OPTION) {
						return;
					}			

					try {
						file = chooser.getSelectedFile();
						FileWriter out = new FileWriter(file + ".txt");
			
							for (Double element : Potts.listM)				
							out.write(Double.toString(element)+" \r\n");
						
                        out.close();
					} catch (IOException d) {

		
				}
			}}
		});
		
		zapiszE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Zapisz plik");

				int result = chooser.showDialog(null, "Save");
				@SuppressWarnings("unused")
				File file;
				if (JFileChooser.APPROVE_OPTION == result) {

					if (result != JFileChooser.APPROVE_OPTION) {
						return;
					}			

					try {
						file = chooser.getSelectedFile();
						FileWriter out = new FileWriter(file + ".txt");
			
							for (Double element : Potts.listE)				
							out.write(Double.toString(element)+" \r\n");
						
                        out.close();
					} catch (IOException d) {

		
				}
			}}
		});
	
	}
}

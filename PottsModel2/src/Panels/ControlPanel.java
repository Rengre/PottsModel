package Panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Mechanics.Potts;
import main.RandomButton;

public class ControlPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private RandomButton random = new RandomButton();
	private static JSlider sliderQ = new JSlider(JSlider.HORIZONTAL,2,6,2);
	private static JSlider sliderT = new JSlider(JSlider.HORIZONTAL,0,100,0);
	private JLabel labelQ = new JLabel();
	private JLabel labelT = new JLabel();
	private JPanel P1 = new JPanel();
	
	public ControlPanel() {
		setLayout(new GridLayout(3,2));
		
		add(random);
		add(P1);
		
		add(sliderQ);
		add(labelQ);
		
		add(sliderT);
		add(labelT);
		
		sliderQ.addChangeListener((ChangeListener) new SliderChangeListener1());
		sliderT.addChangeListener((ChangeListener) new SliderChangeListener2());
		labelQ.setText("q = " + Potts.Getq());
		labelT.setText("T = " + Potts.GetT());
		
	}
	
	public class SliderChangeListener1 implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			Potts.Setq(sliderQ.getValue());
			labelQ.setText("q = " + Potts.Getq());
			NodesPanel.tab = NodesPanel.losowanie(Potts.Getq(),NodesPanel.array);
		}
}
	
	public class SliderChangeListener2 implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			Potts.SetT(sliderT.getValue()/10.0);
			labelT.setText("T = " + Potts.GetT());
		}
}
	
}

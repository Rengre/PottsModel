package Panels;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Mechanics.Potts;

public class ParametersFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private static JSlider sliderQ = new JSlider(JSlider.HORIZONTAL,2,6,2);
	private static JSlider sliderT = new JSlider(JSlider.HORIZONTAL,0,100,0);
	private JLabel labelQ = new JLabel();
	private JLabel labelT = new JLabel();
	
	public ParametersFrame() {
		super("Ustawienia parametrów");
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 100);
		
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
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Panels.NodesPanel;

public class RandomButton extends JButton{

	private static final long serialVersionUID = 1L;

	public RandomButton() {
		super("Random");
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				NodesPanel.SetNodesRandTab(NodesPanel.array);
			}
			});
		
	}
}

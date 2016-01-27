package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TestCreator extends JFrame{
	private static final long serialVersionUID = 1L;
	public TestCreator(String name){
		//Construct a JFrame		
		super(name);
		setSize(830,512);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JTextField title = new JTextField(100);
		add(title);
		setVisible(true);
	}
}

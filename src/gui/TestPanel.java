package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JTextField title;
	public TestPanel(){
		title = new JTextField(100);
		add(title);
		setSize(830,512);
		setVisible(true);
	}
}

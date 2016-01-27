package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.json.JSONException;

import FileOutput.CreateFile;
import FileOutput.JSONTest;
import components.Question;
import components.Test;

public class TestCreator extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField txtTitle;
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel;
	private final JLabel lblNewLabel = new JLabel("Test title:");
	Test test;
	public TestCreator(String name){
		//Construct a JFrame		
		super(name);
		TestCreator window = this;
		setSize(830,512);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		txtTitle = new JTextField();
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtTitle);
		txtTitle.setColumns(30);
		
		JButton btnCreate = new JButton("Create");
		getContentPane().add(btnCreate, BorderLayout.SOUTH);
		btnCreate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				test.setName(txtTitle.getText());
				
				try {
					CreateFile.createFile(JSONTest.createJSONObject(test).toString(10));
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				window.dispose();
				
			}
			
		});
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Questions:");
		panel_1.add(lblNewLabel_1);
		
		listModel = new DefaultListModel<String>();
		@SuppressWarnings("unchecked")
		JList<String> list = new JList<String>(listModel);
		panel_1.add(list);
		list.setToolTipText("Questions:");
		
		JButton btnAddNewQuestion = new JButton("Add New Question");
		btnAddNewQuestion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new QuestionCreator(test, new Question(), window);
				
			}
			
		});
		panel_1.add(btnAddNewQuestion);
		setVisible(true);
		
		test = new Test();
	}
}

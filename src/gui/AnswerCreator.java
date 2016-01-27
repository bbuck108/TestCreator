package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import components.Answer;
import components.Question;

public class AnswerCreator extends JFrame{
	private boolean correct = false;
	public AnswerCreator(Question question, Answer answer, QuestionCreator window2) {
		//Construct a JFrame		
		super("New Answer");
		AnswerCreator window = this;
		
		setSize(830,512);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblQuestion = new JLabel("Answer:");
		lblQuestion.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblQuestion);
		
		JTextPane textPane = new JTextPane();
		textPane.setPreferredSize(new Dimension(256, 128));
		textPane.setMaximumSize(new Dimension(256, 128));
		textPane.setMinimumSize(new Dimension(256, 128));
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(textPane);
		
		JButton btnCreate = new JButton("Create");
		getContentPane().add(btnCreate, BorderLayout.SOUTH);
		btnCreate.addActionListener(new ActionListener(){

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				answer.setAnswer(textPane.getText());
				answer.setLetter(textField.getText());
				answer.setCorrect(correct);
				answer.setQuestion(question);
				question.addtoAList(answer);
				
				window2.listModel.addElement(answer.getLetter()+") "+answer.getAnswer());
				
				window.dispose();
			}
			
		});
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JLabel lblAnswerLetter = new JLabel("Answer letter:");
		panel_1.add(lblAnswerLetter);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		
		JLabel lblCorrect = new JLabel("This answer choice is:");
		panel_2.add(lblCorrect);
		
		ButtonGroup isCorrect = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Correct");
		panel_2.add(rdbtnNewRadioButton);
		isCorrect.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				correct = true;
			}
			
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Incorrect");
		panel_2.add(rdbtnNewRadioButton_1);
		isCorrect.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				correct = false;
			}
			
		});
		
		setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

}

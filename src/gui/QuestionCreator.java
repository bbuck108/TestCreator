package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import components.Answer;
import components.Question;
import components.Test;

public class QuestionCreator extends JFrame{
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel;

	public QuestionCreator(Test test, Question question, TestCreator window2) {
		//Construct a JFrame		
		super("New Question");
		QuestionCreator window = this;
		setSize(830,512);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblQuestion = new JLabel("Question:");
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
			public void actionPerformed(ActionEvent arg0) {
				question.setQuestion(textPane.getText());
				question.setTest(test);
				question.setNumber(test.getQList().size()+1);
				test.addtoQList(question);
				
				window2.listModel.addElement(question.getNumber()+". "+question.getQuestion());
				window.dispose();
				
			}
			
		});
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblAnswers = new JLabel("Answers:");
		panel_1.add(lblAnswers);
		
		listModel = new DefaultListModel<String>();
		@SuppressWarnings("unchecked")
		JList<DefaultListModel<String>> list = new JList<DefaultListModel<String>>(listModel);

		panel_1.add(list);
		
		JButton btnCreateNewAnswer = new JButton("Create New Answer");
		panel_1.add(btnCreateNewAnswer);
		btnCreateNewAnswer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new AnswerCreator(question, new Answer(), window);
				
			}
			
		});
		
		
		
		setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

package components;

import org.json.JSONObject;

/**
 * 
 * @author Benjamin Buck
 * @see Test
 * @see Question
 */
public class Answer {
	//Fields
	
	/**
	 * The question that the Answer belongs to.
	 */
	private Question question;
	
	/**
	 * The String containing the answer.
	 */
	private String answer;
	
	/**
	 * The letter of the answer choice.
	 */
	private String letter;
	
	/**
	 * True if this is the correct answer.
	 */
	private boolean correct;
	
	
	
	
	//Constructors
	
	/**
	 * Construct an Answer from a valid JSONObject
	 * @param p_1 A valid JSONObject
	 * @param p_2 The parent Question
	 */
	public Answer(JSONObject p_1, Question p_2) {
		setQuestion(p_2);
		setAnswer(p_1.getString("text"));
		setLetter(p_1.getString("letter"));
		setCorrect(p_1.getBoolean("correct"));
	}
	
	
	
	
	
	//Accessor methods
	
	public Answer() {
		// TODO Auto-generated constructor stub
	}





	/**
	 * Gets the answer.
	 * @return The answer
	 */
	public String getAnswer(){
		return answer;
	}
	
	/**
	 * Gets the letter of the answer.
	 * @return The letter
	 */
	public String getLetter(){
		return letter;
	}





	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}





	/**
	 * @param letter the letter to set
	 */
	public void setLetter(String letter) {
		this.letter = letter;
	}





	/**
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}





	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}





	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}





	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
}

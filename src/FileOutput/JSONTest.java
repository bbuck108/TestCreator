package FileOutput;

import org.json.JSONArray;
import org.json.JSONObject;

import components.Answer;
import components.Question;
import components.Test;

public class JSONTest {
	public static JSONObject createJSONObject(Test p_1){
		JSONObject json = new JSONObject();
		json.put("name", p_1.getName());
		
		JSONArray questions = new JSONArray();
		for(Question t_1 : p_1.getQList()){
			JSONObject t_2 = new JSONObject();
			
			t_2.put("number", t_1.getNumber());
			t_2.put("text", t_1.getQuestion());
			
			JSONArray t_3 = new JSONArray();
			for(Answer t_4 : t_1.getAList()){
				JSONObject t_5 = new JSONObject();
				
				t_5.put("letter", t_4.getLetter());
				t_5.put("text", t_4.getAnswer());
				t_5.put("correct", t_4.isCorrect());
				
				t_3.put(t_5);
			}
			t_2.put("answers", t_3);
			
			questions.put(t_2);
		}
		
		json.put("questions", questions);
		
		return json;
	}
}

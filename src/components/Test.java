package components;

import java.util.ArrayList;

public class Test {
	ArrayList<Question> qlist;
	int totalPoints;
	int testKey;
	
	public boolean isFinished(){
		boolean t_1 = true;
		for(Question t_2 : qlist){
			if(!t_2.answered){
				t_1 = false;
			}
		}
		return t_1;
	}
	public void addToQList(Question p_1){
		qlist.add(p_1);
	}
}

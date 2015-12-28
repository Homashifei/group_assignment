package solve.quiz;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class QuestionManager {
	
	private Set<Question> questions = new HashSet<Question>();
	Connection conn = null;
	Statement stmt = null;
	
	public Set<Question> buildQuestions(int quizId, int numOfQuestions){
		try {
        String url = "jdbc:mysql://localhost:3306/quizzes";
        conn = DriverManager.getConnection(url,"root","execombat");
        stmt = conn.createStatement();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        for(int i=1; i<=numOfQuestions; i++){
			questions.add(buildQuestion(quizId, i));
		}
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions;
	}

	public int getQuestionsAmount(int quizID) {
		int result=0;
		try {
	        String url = "jdbc:mysql://localhost:3306/quizzes";
	        conn = DriverManager.getConnection(url,"root","execombat");
	        stmt = conn.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery("SELECT COUNT(*) as C FROM QUESTIONS"
            		+ " WHERE QUIZ_ID = "+quizID+";");
            while ( rs.next() ) {
        		result = rs.getInt("C");
            }
			conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
		
		return result;
	}
	
	public boolean checkAnswer(Set<Question> questions, int questNum, int answer) {
		boolean result = false;
		for(Question q: questions){
			if((q.getOrder()==questNum)&(q.getCorrect()==answer)) {
				result=true;
			}
		}

		return result;
	}
	
	private Question buildQuestion(int quizID, int questNum){
		String quest="",opt_a="",opt_b="",opt_c="";
		int correct=-1;
		try {
            ResultSet rs;
            
            rs = stmt.executeQuery("SELECT QUESTION, ANSWER_A, ANSWER_B, ANSWER_C, CORRECT FROM QUESTIONS"
            		+ " WHERE QUIZ_ID = "+quizID+" AND ORDER_NUM = "+questNum+";");
            while ( rs.next() ) {
        		quest = rs.getString("QUESTION");
        		opt_a = rs.getString("ANSWER_A");
        		opt_b = rs.getString("ANSWER_B");
        		opt_c = rs.getString("ANSWER_C");
        		correct = rs.getInt("CORRECT");
            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }         
		return new Question(quest,opt_a,opt_b,opt_c,correct,questNum);
	}
}

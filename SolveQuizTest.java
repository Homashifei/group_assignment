package solve.quiz;

import static org.junit.Assert.*;
import java.util.Set;

import org.junit.Test;

public class SolveQuizTest {

	@Test
	public void testQuestionObjectsAmount() {
		int count=0;
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 5);
		for(Question q: setOfQuestions){
			count++;
		}
		assertTrue(count==5);

	}

	@Test
	public void testQuestionObjectsQuestion() {
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 1);
		for(Question q: setOfQuestions){
			assertTrue(q.getQuest().equals("First question"));
		}

	}

	@Test
	public void testQuestionObjectsOptionA() {
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 1);
		for(Question q: setOfQuestions){
			assertTrue(q.getOpt_a().equals("First answer"));
		}

	}

	@Test
	public void testQuestionObjectsOptionB() {
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 1);
		for(Question q: setOfQuestions){
			assertTrue(q.getOpt_b().equals("Second answer"));
		}

	}

	@Test
	public void testQuestionObjectsOptionC() {
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 1);
		for(Question q: setOfQuestions){
			assertTrue(q.getOpt_c().equals("Third answer"));
		}

	}

	@Test
	public void testQuestionObjectsCorrect() {
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 1);
		for(Question q: setOfQuestions){
			assertTrue(q.getCorrect()==0);
		}

	}

	@Test
	public void testFindQuestionAmount() {
		QuestionManager qm =  new QuestionManager();
		int count = qm.getQuestionsAmount(1);
		assertTrue(count==5);

	}

	@Test
	public void testCheckCorrectAnswer() {
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 1);
		assertTrue(qm.checkAnswer(setOfQuestions,1,0));

	}

	@Test
	public void testCheckWrongAnswer() {
		QuestionManager qm =  new QuestionManager();
		Set<Question> setOfQuestions = qm.buildQuestions(1, 1);
		assertFalse(qm.checkAnswer(setOfQuestions,1,1));

	}

}

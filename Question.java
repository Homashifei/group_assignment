package solve.quiz;

public class Question {
	private String quest;
	private String opt_a;
	private String opt_b;
	private String opt_c;
	private int correct;
	private int order;
	
	Question(String quest, String opt_a, String opt_b, String opt_c, int correct, int order) {
		this.setQuest(quest);
		this.setOpt_a(opt_a);
		this.setOpt_b(opt_b);
		this.setOpt_c(opt_c);
		this.setCorrect(correct);
		this.setOrder(order);
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	public String getOpt_a() {
		return opt_a;
	}

	public void setOpt_a(String opt_a) {
		this.opt_a = opt_a;
	}

	public String getOpt_b() {
		return opt_b;
	}

	public void setOpt_b(String opt_b) {
		this.opt_b = opt_b;
	}

	public String getOpt_c() {
		return opt_c;
	}

	public void setOpt_c(String opt_c) {
		this.opt_c = opt_c;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}

package com.oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerA {

	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private QuestionA question;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionA getQuestion() {
		return question;
	}

	public void setQuestion(QuestionA question) {
		this.question = question;
	}

	public AnswerA(int answerId, String answer, QuestionA question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}

	public AnswerA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

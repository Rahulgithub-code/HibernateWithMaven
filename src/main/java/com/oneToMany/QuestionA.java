package com.oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.*;

@Entity
public class QuestionA {
	
	@Id
	@Column(name = "question_id")
	private int questionId;
	
	private String question;
	
	@OneToMany(mappedBy = "question")
	private List<AnswerA> answers;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerA> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerA> answers) {
		this.answers = answers;
	}

	public QuestionA(int questionId, String question, List<AnswerA> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public QuestionA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

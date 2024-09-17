package com.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	
	@Id
	@Column(name="answer_id")
	private int answerId;
	
	private String answer;
	
	@OneToOne(mappedBy="answer")	// mappedBy property will not create column for foreign key in this table
	@JoinColumn(name="q_id")
	private Question question;

	public Answer() {
		super();
	}
	
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	
	public int getAnswerId() {
		return answerId;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}

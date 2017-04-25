package com.kdy.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	long ano;
	String content;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_answer_to_board"))
	private Board board;
	
	public long getAno() {
		return ano;
	}
	public void setAno(long ano) {
		this.ano = ano;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void update(Answer answer){
		this.content = answer.content;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	

}

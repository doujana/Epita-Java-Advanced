package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPTIONS")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "ISCORRECT")
	private boolean iscorrect;

	public Option(int id, String content, boolean iscorrect) {
		super();

		this.id = id;
		this.content = content;
		this.iscorrect = iscorrect;
	}

	public Option(String content, boolean isocrrect) {
		super();
		;

		this.content = content;
		this.iscorrect = iscorrect;
	}

	public boolean getisIscorrect() {
		return iscorrect;
	}

	public void setIscorrect(boolean iscorrect) {
		this.iscorrect = iscorrect;
	}

	public Option(String content) {
		this.content = content;
	}

	public Option() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

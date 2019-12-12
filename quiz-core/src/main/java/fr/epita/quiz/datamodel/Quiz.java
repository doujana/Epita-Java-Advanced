package fr.epita.quiz.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Quizzes")
public class Quiz {

	@ManyToOne
	private Professor professor;
	@ManyToOne
	private Student student;
	@Column(name = "MARK")
	private int mark;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Quiz(String quizname) {
		this.QuizeName = quizname;
	}

	@OneToMany
	@JoinTable(name = "Quiz_Question", joinColumns = @JoinColumn(name = "Quiz_ID"), inverseJoinColumns = @JoinColumn(name = "Question_ID"))
	private List<Question> questions = new ArrayList<Question>();

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "Name")
	private String QuizeName;

	public Quiz(int id, String quizeName) {
		super();
		this.id = id;
		QuizeName = quizeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuizeName() {
		return QuizeName;
	}

	public void setQuizeName(String quizeName) {
		QuizeName = quizeName;
	}

	public void Quiz() {

	}

}

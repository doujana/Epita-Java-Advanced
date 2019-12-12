package fr.epita.quiz.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="PROFESSORS")
public class Professor {
	
	@OneToMany
	@JoinTable(name = "Professor_Quiz" , joinColumns = @JoinColumn(name ="Professor_ID"),
	inverseJoinColumns =@JoinColumn(name ="Quiz_ID")
	)
	private List<Quiz> quizzes = new ArrayList<Quiz>();
	
	
	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	public Professor(String name)
	{
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name ="PASSWORD")
	private String password;

	public int getId() {
		return id;
	}

	public Professor(String name , String email, String password)
	{
		this.name =name;
		this.email = email;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Professor(List<Quiz> quizzes, int id, String name, String email, String password) {
		super();
		this.quizzes = quizzes;
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Professor()
	{
		
	}

	
	

}

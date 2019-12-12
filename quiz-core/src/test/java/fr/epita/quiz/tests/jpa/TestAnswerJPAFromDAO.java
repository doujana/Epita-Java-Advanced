package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.services.AnswerDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestAnswerJPAFromDAO {
	@Inject
	AnswerDAO answerDAO;
	
//	@Inject
//	SessionFactory sf;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void testCreate() {
		
		//test
		//given
		Answer answer = new Answer("spring is for ...");
		
		// 
		//when
		answerDAO.create(answer);
		
		
		//then
		
		Assert.assertNotNull(em.find(Answer.class, answer.getId()));
		
		
		
	}
	@Test
	public void testDelete() {
		
		//test
		//given
		Answer answer = new Answer("What is ...?");
		
		
		//when
		answerDAO.delete(answer);
		
		
		//then
		
		Assert.assertNull(em.find(Answer.class, answer.getId()));
		
		
		
	}
	@Test
	public void testfindbyId() {
		
		//test
		//given
		Answer answer = new Answer("  Dependency Injection ");
		
		
		
		//when
		
		
		
		//then
		
		Assert.assertNull(em.find(Answer.class, answer.getId()));
		
		
		
	}
	@Test
	public void testUpdate() {
		
		//test
		//given
		Answer answer = new Answer(" Dependency Injection... ");
				String answermodified="qqq" ;
		
		//QuestionDAO questionDAO = new QuestionDAO();
		//when
		answerDAO.update(answer);
		
		
		//then
		
		Assert.assertEquals(answermodified,em.find(Answer.class, answer.getId()));
		
		
		
	}
	
	
	


}

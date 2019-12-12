package fr.epita.quiz.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Quiz;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestQuizJPAEM {

	@PersistenceContext
	EntityManager em;
	@Test
	@Transactional
	public void testEM() {
		String quizContent = "java";
		Quiz quiz = new Quiz(quizContent);

		persistQuiz(quiz);
		
		Quiz retrievedQuiz = em.find(Quiz.class, quiz.getId());
		
		Assert.assertNotNull(retrievedQuiz);
		Assert.assertEquals(quizContent, retrievedQuiz.getQuizeName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void persistQuiz(Quiz quiz) {
		em.persist(quiz);
	}
	
	////////////////////////////////test delete
	
	@Test
	@Transactional
	public void testDeleteEM() {
		String quizContent = "ALGO";
		Quiz quiz = new Quiz(quizContent);

		deleteQuiz(quiz);
		
		Quiz retrievedQuiz = em.find(Quiz.class, quiz.getId());
		
		Assert.assertNull(retrievedQuiz);
		
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void deleteQuiz(Quiz quiz) {
		em.remove(quiz);
	}
	/////////////////////////////////////test update
	@Test
	@Transactional
	public void testUpdateEM() {
		String quizContent = "web-dev ?";
		Quiz quiz = new Quiz(quizContent);

		updateQuiz(quiz);
		
		Quiz retrievedQuiz = em.find(Quiz.class, quiz.getId());
		
		Assert.assertNotNull(retrievedQuiz);
		Assert.assertEquals(quizContent, retrievedQuiz.getQuizeName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void updateQuiz(Quiz quiz) {
		em.merge(quiz);
	}
	//////////////////////////test getbyid
	@Test
	@Transactional
	public void testgetByIDEM() {
		String quizContent = "What is Dependency Injection ?";
		Quiz quiz = new Quiz(quizContent);

		searchQuiz(quiz);
		
		Quiz retrievedQuiz = em.find(Quiz.class, quiz.getId());
		
		Assert.assertNotNull(retrievedQuiz);
		Assert.assertEquals(quizContent, retrievedQuiz.getQuestions());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void searchQuiz(Quiz quiz) {
	
		em.find(Quiz.class ,3);
	}

}

package fr.epita.quiz.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Question;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPAEM {

	@PersistenceContext
	EntityManager em;
	
	
	@Test
	@Transactional
	public void testEM() {
		String questionContent = "What is Dependency Injection ?";
		Question question = new Question(questionContent);

		persistQuestion(question);
		
		Question retrievedQuestion = em.find(Question.class, question.getId());
		
		Assert.assertNotNull(retrievedQuestion);
		Assert.assertEquals(questionContent, retrievedQuestion.getQuestionContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void persistQuestion(Question question) {
		em.persist(question);
	}
	
	////////////////////////////////test delete
	
	@Test
	@Transactional
	public void testDeleteEM() {
		String questionContent = "What is Dependency Injection ?";
		Question question = new Question(questionContent);

		deleteQuestion(question);
		
		Question retrievedQuestion = em.find(Question.class, question.getId());
		
		Assert.assertNull(retrievedQuestion);
		
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void deleteQuestion(Question question) {
		em.remove(question);
	}
	/////////////////////////////////////test update
	@Test
	@Transactional
	public void testUpdateEM() {
		String questionContent = "What is Dependency ?? ?";
		Question question = new Question(questionContent);

		updateQuestion(question);
		
		Question retrievedQuestion = em.find(Question.class, question.getId());
		
		Assert.assertNotNull(retrievedQuestion);
		Assert.assertEquals(questionContent, retrievedQuestion.getQuestionContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void updateQuestion(Question question) {
		em.merge(question);
	}
	//////////////////////////test getbyid
	@Test
	@Transactional
	public void testgetByIDEM() {
		String questionContent = "What is Dependency Injection ?";
		Question question = new Question(questionContent);

		searchQuestion(question);
		
		Question retrievedQuestion = em.find(Question.class, question.getId());
		
		Assert.assertNotNull(retrievedQuestion);
		Assert.assertEquals(questionContent, retrievedQuestion.getQuestionContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void searchQuestion(Question question) {
	
		///em.find(Question q ,question);
	}
}

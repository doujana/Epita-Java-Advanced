package fr.epita.quiz.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Answer;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestAnswerJPAEM {
	@PersistenceContext
	EntityManager em;
	@Test
	@Transactional
	public void testEM() {
		String answerContent = "What ? ?";
		Answer answer = new Answer(answerContent);

		persistAnswer(answer);
		
		Answer retrievedAnswer = em.find(Answer.class, answer.getId());
		
		Assert.assertNotNull(retrievedAnswer);
		Assert.assertEquals(answerContent, retrievedAnswer.getContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void persistAnswer(Answer answer) {
		em.persist(answer);
	}
	
	////////////////////////////////test delete
	
	@Test
	@Transactional
	public void testDeleteEM() {
		String answerContent = "spring is .....";
		Answer answer = new Answer(answerContent);

		deleteAnswer(answer);
		
		Answer retrievedAnswer = em.find(Answer.class, answer.getId());
		
		Assert.assertNull(retrievedAnswer);
		
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void deleteAnswer(Answer answer) {
		em.remove(answer);
	}
	/////////////////////////////////////test update
	@Test
	@Transactional
	public void testUpdateEM() {
		String answerContent = " Dependency ....";
		Answer answer = new Answer(answerContent);

		updateAnswer(answer);
		
		Answer retrievedAnswer = em.find(Answer.class, answer.getId());
		
		Assert.assertNotNull(retrievedAnswer);
		Assert.assertEquals(answerContent, retrievedAnswer.getContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void updateAnswer(Answer answer) {
		em.merge(answer);
	}
	//////////////////////////test getbyid
	@Test
	@Transactional
	public void testgetByIDEM() {
		String answerContent = "injection ---";
		Answer answer = new Answer(answerContent);

		searchAnswer(answer);
		
		Answer retrievedAnswer = em.find(Answer.class, answer.getId());
		
		Assert.assertNotNull(retrievedAnswer);
		Assert.assertEquals(answerContent, retrievedAnswer.getContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void searchAnswer(Answer answer) {
	
		em.find(Answer.class ,2);
	}


}

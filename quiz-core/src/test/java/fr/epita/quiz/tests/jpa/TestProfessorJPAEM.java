package fr.epita.quiz.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Professor;
import fr.epita.quiz.datamodel.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestProfessorJPAEM {
	
	@PersistenceContext
	EntityManager em;
	@Test
	@Transactional
	public void testEM() {
		String profName = "JALA";
		Professor prof = new Professor(profName);

		persistProfessor(prof);
		
		Professor retrievedProf = em.find(Professor.class, prof.getId());
		
		Assert.assertNotNull(retrievedProf);
		Assert.assertEquals(profName, retrievedProf.getName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void persistProfessor(Professor prof) {
		em.persist(prof);
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
		String profname = "laplasse";
		Professor prof = new Professor(profname);

		updateProfessor(prof);
		
		Professor retrievedProfessor = em.find(Professor.class, prof.getId());
		
		Assert.assertNotNull(retrievedProfessor);
		Assert.assertEquals(profname, retrievedProfessor.getName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void updateProfessor(Professor prof) {
		em.merge(prof);
	}
	//////////////////////////test getbyid
	@Test
	@Transactional
	public void testgetByIDEM() {
		String professorName= "osman";
		Professor prof = new Professor(professorName);

		searchProfessor(prof);
		
		Professor retrievedProfessor = em.find(Professor.class, prof.getId());
		
		Assert.assertNotNull(retrievedProfessor);
		Assert.assertEquals(professorName, retrievedProfessor.getName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void searchProfessor(Professor prof) {
	
		em.find(Professor.class ,1);
	}


}

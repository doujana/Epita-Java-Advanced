package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Quiz;
import fr.epita.quiz.services.QuizDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestQuizJPAFromDAO {

	@Inject
	QuizDAO quizDAO;

//	@Inject
//	SessionFactory sf;

	@PersistenceContext
	EntityManager em;

	@Test
	public void testCreate() {

		// test
		// given
		Quiz quiz = new Quiz("A- aaa");

		// when
		quizDAO.create(quiz);

		// then

		Assert.assertNotNull(em.find(Quiz.class, quiz.getId()));

	}

	@Test
	public void testDelete() {

		// test
		// given
		Quiz quiz = new Quiz("A- nn");

		// when
		quizDAO.delete(quiz);

		// then

		Assert.assertNull(em.find(Quiz.class, quiz.getId()));

	}

	@Test
	public void testfindbyId() {

		// test
		// given
		Quiz quiz = new Quiz("A- bbb");

		// when

		// then

		Assert.assertNull(em.find(Quiz.class, quiz.getId()));

	}

	@Test
	public void testUpdate() {

		// test
		// given
		Quiz quiz = new Quiz("A- bb");
		String quizmodified = "qqq";

		// when
		quizDAO.update(quiz);

		// then

		Assert.assertEquals(quizmodified, em.find(Quiz.class, quiz.getId()));

	}

}

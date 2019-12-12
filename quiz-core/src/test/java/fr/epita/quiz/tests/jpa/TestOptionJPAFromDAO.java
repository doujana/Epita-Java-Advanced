package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Option;
import fr.epita.quiz.services.OptionDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestOptionJPAFromDAO {
	
	
	@Inject
	OptionDAO optionDAO;
	
//	@Inject
//	SessionFactory sf;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void testCreate() {
		
		//test
		//given
		Option option = new Option("A- aaa");
		
		//QuestionDAO questionDAO = new QuestionDAO();
		//when
		optionDAO.create(option);
		
		
		//then
		
		Assert.assertNotNull(em.find(Option.class, option.getId()));
		
		
		
	}
	@Test
	public void testDelete() {
		
		//test
		//given
		Option option = new Option("A- nn");
		
		//QuestionDAO questionDAO = new QuestionDAO();
		//when
		optionDAO.delete(option);
		
		
		//then
		
		Assert.assertNull(em.find(Option.class, option.getId()));
		
		
		
	}
	@Test
	public void testfindbyId() {
		
		//test
		//given
		Option option = new Option("A- bbb");
		int id=1;
		
		//QuestionDAO questionDAO = new QuestionDAO();
		//when
		//questionDAO.getById(id,class<Question>);
		
		
		//then
		
		Assert.assertNull(em.find(Option.class, option.getId()));
		
		
		
	}
	@Test
	public void testUpdate() {
		
		//test
		//given
		Option option = new Option("A- bb");
				String optionmodified="qqq" ;
		Option option1 = new Option(optionmodified);
		
		//QuestionDAO questionDAO = new QuestionDAO();
		//when
		optionDAO.update(option1);
		
		
		//then
		
		Assert.assertEquals(option1.getContent(),em.find(Option.class, option1.getId()));
		
		
		
	}
	
	
	


}

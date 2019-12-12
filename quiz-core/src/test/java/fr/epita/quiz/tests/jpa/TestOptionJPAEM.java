package fr.epita.quiz.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Option;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestOptionJPAEM {
	
	@PersistenceContext
	EntityManager em;
	
	
	@Test
	@Transactional
	public void testEM() {
		String optionContent = "A-What is Dependency Injection ?";
		Option option = new Option(optionContent);

		persistOption(option);
		
		Option retrievedOption = em.find(Option.class, option.getId());
		
		Assert.assertNotNull(retrievedOption);
		Assert.assertEquals(optionContent, retrievedOption.getContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void persistOption(Option option) {
		em.persist(option);
	}
	
	////////////////////////////////test delete
	
	@Test
	@Transactional
	public void testDeleteEM() {
		String optionContent = "B-hipernate";
		Option option = new Option(optionContent);

		deleteOption(option);
		
		Option retrievedOption = em.find(Option.class, option.getId());
		
		Assert.assertNull(retrievedOption);
		
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void deleteOption(Option option) {
		em.remove(option);
	}
	/////////////////////////////////////test update
	@Test
	@Transactional
	public void testUpdateEM() {
		String optionContent = "A- 4.4 ";
		Option option = new Option(optionContent);

		updateOption(option);
		
		Option retrievedOption = em.find(Option.class, option.getId());
		
		Assert.assertNotNull(retrievedOption);
		Assert.assertEquals(optionContent, retrievedOption.getContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void updateOption(Option option) {
		em.merge(option);
	}
	//////////////////////////test getbyid
	@Test
	@Transactional
	public void testgetByIDEM() {
		String optionContent = "What is Dependency Injection ?";
		Option option = new Option(optionContent);

		searchOption(option);
		
		Option retrievedOption = em.find(Option.class, option.getId());
		
		Assert.assertNotNull(retrievedOption);
		Assert.assertEquals(optionContent, retrievedOption.getContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void searchOption(Option option) {
	
		em.find(Option.class,2);
	}


}

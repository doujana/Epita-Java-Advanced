package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Professor;
import fr.epita.quiz.services.ProfessorDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestProfessorJPAFromDAO {
	
	

	@Inject
	ProfessorDAO professorDAO;
	
//	@Inject
//	SessionFactory sf;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void testCreate() {
		
		//test
		//given
		Professor prof = new Professor("Jalal");
		
		
		//when
		professorDAO.create(prof);
		
		
		//then
		
		Assert.assertNotNull(em.find(Professor.class, prof.getId()));
		
		
		
	}
	@Test
	public void testDelete() {
		
		//test
		//given
		Professor prof = new Professor("maher");
		
		
		//when
		professorDAO.delete(prof);
		
		
		//then
		
		Assert.assertNull(em.find(Professor.class, prof.getId()));
		
		
		
	}
	@Test
	public void testfindbyId() {
		
		//test
		//given
		Professor prof = new Professor("maher");
		
		
		
		//when
		
		
		
		//then
		
		Assert.assertNull(em.find(Professor.class, prof.getId()));
		
		
		
	}
	@Test
	public void testUpdate() {
		
		//test
		//given
		Professor prof = new Professor("lana");
				String profnmodified="luna" ;
		
		professorDAO.update(prof);
		
		
		//then
		
		Assert.assertEquals(profnmodified,em.find(Professor.class, prof.getId()));
		
		
		
	}
	

}

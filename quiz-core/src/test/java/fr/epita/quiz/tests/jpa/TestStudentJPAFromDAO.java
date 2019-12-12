package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.services.StudentDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")

public class TestStudentJPAFromDAO {
	@Inject
	StudentDAO studentDAO;
	
//	@Inject
//	SessionFactory sf;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void testCreate() {
		
		//test
		//given
		Student std = new Student("doujana");
		
		
		//when
		studentDAO.create(std);
		
		
		//then
		
		Assert.assertNotNull(em.find(Student.class, std.getId()));
		
		
		
	}
	@Test
	public void testDelete() {
		
		//test
		//given
		Student std = new Student("ayla");
		
		
		//when
		studentDAO.delete(std);
		
		
		//then
		
		Assert.assertNull(em.find(Student.class, std.getId()));
		
		
		
	}
	@Test
	public void testfindbyId() {
		
		//test
		//given
		 Student std = new Student("sam");
		
	
		
		
		//then
		
		Assert.assertNull(em.find(Student.class, std.getId()));
		
		
		
	}
	@Test
	public void testUpdate() {
		
		//test
		//given
		Student std = new Student("lana");
				String questionmodified="qqq" ;
		
		//when
		studentDAO.update(std);
		
		
		//then
		
		Assert.assertEquals(std.getName(),em.find(Student.class, std.getId()));
		
		
		
	}
	
	
	


}

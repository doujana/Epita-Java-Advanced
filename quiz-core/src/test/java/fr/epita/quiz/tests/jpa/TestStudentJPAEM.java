package fr.epita.quiz.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Student;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")

public class TestStudentJPAEM {
	@PersistenceContext
	EntityManager em;
	@Test
	@Transactional
	public void testEM() {
		String studentname = "doujana";
		Student std = new Student(studentname);

		persistStudent(std);
		
		Student retrievedStudent = em.find(Student.class, std.getId());
		
		Assert.assertNotNull(retrievedStudent);
		Assert.assertEquals(studentname, retrievedStudent.getName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void persistStudent(Student student) {
		em.persist(student);
	}
	
	////////////////////////////////test delete
	
	@Test
	@Transactional
	public void testDeleteEM() {
		String studentName = "ayla";
		Student student = new Student(studentName);

		deleteStudent(student);
		
		Student retrievedStudent = em.find(Student.class, student.getId());
		
		Assert.assertNull(retrievedStudent);
		
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void deleteStudent(Student std) {
		em.remove(std);
	}
	/////////////////////////////////////test update
	@Test
	@Transactional
	public void testUpdateEM() {
		String studentName = "layal";
		Student std = new Student(studentName);

		updateStudent(std);
		
		Student retrievedStudent = em.find(Student.class, std.getId());
		
		Assert.assertNotNull(retrievedStudent);
		Assert.assertEquals(studentName, retrievedStudent.getName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void updateStudent(Student std) {
		em.merge(std);
	}
	//////////////////////////test getbyid
	@Test
	@Transactional
	public void testgetByIDEM() {
		String studentName = "doujan";
		Student std = new Student(studentName);

		searchStudent(std);
		
		Student retrievedstd = em.find(Student.class, std.getId());
		
		Assert.assertNotNull(retrievedstd);
		Assert.assertEquals(retrievedstd, retrievedstd.getName());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void searchStudent(Student std) {
	
		em.find(Student.class ,1);
	}


}

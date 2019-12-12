package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.services.StudentDAO;



@Path("/students/")
public class StudentResource {
	
	
	
	

	
	@Inject
	StudentDAO dao;
	private static final Logger LOGGER = LogManager.getLogger(StudentResource.class);
	
	
	@POST
	@Path("/create/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createOption(@RequestBody Student student) throws URISyntaxException {
		LOGGER.debug("entering => createstudent() with parameters : {} ", student);
		//create a student 
		System.out.println("In Create : " + student.getName());
		dao.create(student);
		LOGGER.info("received creation order for student : {}",  student);
		return Response.created(new URI("students/"  + String.valueOf(student.getId()))).build();
	}
	//////////////////////////////////
	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@RequestBody Student student) throws URISyntaxException {
		LOGGER.debug("entering => deleteOption() with parameters : {} ", student);
		//delete a option 
		System.out.println("In Delete : " + student.getName());
		dao.delete(student);
		LOGGER.info("received delete order for student : {}",  student);
		return Response.created(new URI("students/"  + String.valueOf(student.getId()))).build();
	}
	
	////////////////////////////////
	//////////////////////////////
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudent(@RequestBody Student student) throws URISyntaxException {
		LOGGER.debug("entering => updatestudent() with parameters : {} ", student);
		//create a student 
		System.out.println("In update : " + student.getName());
		dao.update(student);
		LOGGER.info("received updating order for student : {}",  student);
		return Response.created(new URI("students/"  + String.valueOf(student.getId()))).build();
	}
	
	///////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentById(@PathParam("id") int id) {
		//create a student 
		
		Student student = dao.getById(id, Student.class);
		
		return Response.ok(student).build();
	}

	
	@GET
	@Path("searchContent/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchStudent(@QueryParam("qContent") String studentContent) {
		//create a question 
		List<Student> searchList = dao.search(new Student(studentContent));
		return Response.ok(searchList).build();
	}

}

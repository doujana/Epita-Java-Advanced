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

import fr.epita.quiz.datamodel.Professor;
import fr.epita.quiz.services.ProfessorDAO;



@Path("/professors/")
public class ProfessorResource {

	
	

	@Inject
	ProfessorDAO dao;
	private static final Logger LOGGER = LogManager.getLogger(ProfessorResource.class);
	
	
	@POST
	@Path("/create/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProfessor(@RequestBody Professor professor) throws URISyntaxException {
		LOGGER.debug("entering => createprofessor() with parameters : {} ", professor);
		//create a professor 
		System.out.println("In Create : " + professor.getName());
		dao.create(professor);
		LOGGER.info("received creation order for professor : {}",  professor);
		return Response.created(new URI("professors/"  + String.valueOf(professor.getId()))).build();
	}
	//////////////////////////////////
	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@RequestBody Professor professor) throws URISyntaxException {
		LOGGER.debug("entering => deleteProfessor() with parameters : {} ", professor);
		//delete a professor 
		System.out.println("In Delete : " + professor.getName());
		dao.delete(professor);
		LOGGER.info("received delete order for professor : {}",  professor);
		return Response.created(new URI("professors/"  + String.valueOf(professor.getId()))).build();
	}
	
	////////////////////////////////
	//////////////////////////////
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProfessor(@RequestBody Professor professor) throws URISyntaxException {
		LOGGER.debug("entering => updateprofessor() with parameters : {} ", professor);
		//create a professor 
		System.out.println("In update : " + professor.getName());
		dao.update(professor);
		LOGGER.info("received updating order for student : {}",  professor);
		return Response.created(new URI("professors/"  + String.valueOf(professor.getId()))).build();
	}
	
	///////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfessorById(@PathParam("id") int id) {
		//create a professor 
		
		Professor professor = dao.getById(id, Professor.class);
		
		return Response.ok(professor).build();
	}

	
	@GET
	@Path("searchContent/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchStudent(@QueryParam("qContent") String professorContent) {
		//create a professor 
		List<Professor> searchList = dao.search(new Professor(professorContent));
		return Response.ok(searchList).build();
	}

}

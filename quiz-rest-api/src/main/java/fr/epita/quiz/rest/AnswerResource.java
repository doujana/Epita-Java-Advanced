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

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.services.AnswerDAO;



@Path("/questions/")
public class AnswerResource {
	
	
	
	@Inject
	AnswerDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(AnswerResource.class);
	
	
	@POST
	@Path("/create/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAnswer(@RequestBody Answer answer) throws URISyntaxException {
		LOGGER.debug("entering => createAnswer() with parameters : {} ", answer);
		//create a answer 
		System.out.println("In Create : " + answer.getContent());
		dao.create(answer);
		LOGGER.info("received creation order for answer : {}",  answer);
		return Response.created(new URI("answers/"  + String.valueOf(answer.getId()))).build();
	}
	//////////////////////////////////
	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAnswer(@RequestBody Answer answer) throws URISyntaxException {
		LOGGER.debug("entering => deleteAnswer() with parameters : {} ", answer);
		//delete a answer 
		System.out.println("In Delete : " + answer.getContent());
		dao.delete(answer);
		LOGGER.info("received delete order for answer : {}",  answer);
		return Response.created(new URI("answers/"  + String.valueOf(answer.getId()))).build();
	}
	
	////////////////////////////////
	//////////////////////////////
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAnswer(@RequestBody Answer answer) throws URISyntaxException {
		LOGGER.debug("entering => updateAnswer() with parameters : {} ", answer);
		//create a answer 
		System.out.println("In update : " + answer.getContent());
		dao.update(answer);
		LOGGER.info("received updating order for answer : {}",  answer);
		return Response.created(new URI("answers/"  + String.valueOf(answer.getId()))).build();
	}
	
	///////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuizById(@PathParam("id") int id) {
		//create a answer 
		
		Answer answer = dao.getById(id, Answer.class);
		
		return Response.ok(answer).build();
	}

	
	@GET
	@Path("searchContent/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuizes(@QueryParam("qContent") String answerContent) {
		//create a question 
		List<Answer> searchList = dao.search(new Answer(answerContent));
		return Response.ok(searchList).build();
	}
	



}

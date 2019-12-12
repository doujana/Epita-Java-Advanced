package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
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

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;

@Path("/questions/")

public class QuestionResource {
	
	
	@Inject
	QuestionDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);
	
	
	@POST
	@Path("/create/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody Question question) throws URISyntaxException {
		LOGGER.debug("entering => createQuestion() with parameters : {} ", question);
		//create a question 
		System.out.println("In Create : " + question.getQuestionContent());
		dao.create(question);
		LOGGER.info("received creation order for question : {}",  question);
		return Response.created(new URI("questions/"  + String.valueOf(question.getId()))).build();
	}
	//////////////////////////////////
	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@RequestBody Question question) throws URISyntaxException {
		LOGGER.debug("entering => deleteQuestion() with parameters : {} ", question);
		//delete a question 
		System.out.println("In Delete : " + question.getQuestionContent());
		dao.delete(question);
		LOGGER.info("received delete order for question : {}",  question);
		return Response.created(new URI("questions/"  + String.valueOf(question.getId()))).build();
	}
	
	////////////////////////////////
	//////////////////////////////
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestion(@RequestBody Question question) throws URISyntaxException {
		LOGGER.debug("entering => updateQuestion() with parameters : {} ", question);
		//create a question 
		System.out.println("In update : " + question.getQuestionContent());
		dao.update(question);
		LOGGER.info("received updating order for question : {}",  question);
		return Response.created(new URI("questions/"  + String.valueOf(question.getId()))).build();
	}
	
	///////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(@PathParam("id") int id) {
		//create a question 
		
		Question question = dao.getById(id, Question.class);
		
		return Response.ok(question).build();
	}

	
	@GET
	@Path("searchContent/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("qContent") String questionContent) {
		//create a question 
		List<Question> searchList = dao.search(new Question(questionContent));
		return Response.ok(searchList).build();
	}
	

}

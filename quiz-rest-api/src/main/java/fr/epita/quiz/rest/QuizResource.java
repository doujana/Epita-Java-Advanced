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


import fr.epita.quiz.datamodel.Quiz;

import fr.epita.quiz.services.QuizDAO;

@Path("/quizzes/")
public class QuizResource {
	
	
	
	@Inject
	QuizDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(QuizResource.class);
	
	
	@POST
	@Path("/create/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuiz(@RequestBody Quiz quiz) throws URISyntaxException {
		LOGGER.debug("entering => createQuestion() with parameters : {} ", quiz);
		//create a quiz 
		System.out.println("In Create : " + quiz.getQuizeName());
		dao.create(quiz);
		LOGGER.info("received creation order for quiz : {}",  quiz);
		return Response.created(new URI("questions/"  + String.valueOf(quiz.getId()))).build();
	}
	//////////////////////////////////
	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteQuiz(@RequestBody Quiz quiz) throws URISyntaxException {
		LOGGER.debug("entering => deleteQuestion() with parameters : {} ", quiz);
		//delete a quiz 
		System.out.println("In Delete : " + quiz.getQuizeName());
		dao.delete(quiz);
		LOGGER.info("received delete order for quiz : {}",  quiz);
		return Response.created(new URI("quizzes/"  + String.valueOf(quiz.getId()))).build();
	}
	
	////////////////////////////////
	//////////////////////////////
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuiz(@RequestBody Quiz quiz) throws URISyntaxException {
		LOGGER.debug("entering => updateQuiz() with parameters : {} ", quiz);
		//create a quiz 
		System.out.println("In update : " + quiz.getQuizeName());
		dao.update(quiz);
		LOGGER.info("received updating order for quiz : {}",  quiz);
		return Response.created(new URI("quizzes/"  + String.valueOf(quiz.getId()))).build();
	}
	
	///////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuizById(@PathParam("id") int id) {
		//create a question 
		
		Quiz quiz = dao.getById(id, Quiz.class);
		
		return Response.ok(quiz).build();
	}

	
	@GET
	@Path("searchContent/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuizes(@QueryParam("qContent") String quizContent) {
		//create a question 
		List<Quiz> searchList = dao.search(new Quiz(quizContent));
		return Response.ok(searchList).build();
	}
	


}

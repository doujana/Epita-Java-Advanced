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

import fr.epita.quiz.datamodel.Option;
import fr.epita.quiz.services.OptionDAO;



@Path("/options/")
public class OptionResource {
	

	
	@Inject
	OptionDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(OptionResource.class);
	
	
	@POST
	@Path("/create/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createOption(@RequestBody Option option) throws URISyntaxException {
		LOGGER.debug("entering => createOption() with parameters : {} ", option);
		//create a option 
		System.out.println("In Create : " + option.getContent());
		dao.create(option);
		LOGGER.info("received creation order for option : {}",  option);
		return Response.created(new URI("options/"  + String.valueOf(option.getId()))).build();
	}
	//////////////////////////////////
	@POST
	@Path("/delete/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOption(@RequestBody Option option) throws URISyntaxException {
		LOGGER.debug("entering => deleteOption() with parameters : {} ", option);
		//delete a option 
		System.out.println("In Delete : " + option.getContent());
		dao.delete(option);
		LOGGER.info("received delete order for option : {}",  option);
		return Response.created(new URI("options/"  + String.valueOf(option.getId()))).build();
	}
	
	////////////////////////////////
	//////////////////////////////
	@POST
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOption(@RequestBody Option option) throws URISyntaxException {
		LOGGER.debug("entering => updateOption() with parameters : {} ", option);
		//create a answer 
		System.out.println("In update : " + option.getContent());
		dao.update(option);
		LOGGER.info("received updating order for option : {}",  option);
		return Response.created(new URI("options/"  + String.valueOf(option.getId()))).build();
	}
	
	///////////////////////////
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnswerById(@PathParam("id") int id) {
		//create a option 
		
		Option option = dao.getById(id, Option.class);
		
		return Response.ok(option).build();
	}

	
	@GET
	@Path("searchContent/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuizes(@QueryParam("qContent") String optionContent) {
		//create a question 
		List<Option> searchList = dao.search(new Option(optionContent));
		return Response.ok(searchList).build();
	}
	

	
}

package il.ac.shenkar.todolist;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ToDoLisrREST {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public void getUsers(String id){
		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setUser(){
		
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public void deleteUser(@QueryParam("id") String id){
		
	}
}

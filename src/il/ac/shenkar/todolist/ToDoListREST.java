package il.ac.shenkar.todolist;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/")
public class ToDoListREST {
	
	private HibernateToDoListDAO$ DAO;
	
	//get all users
	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(){
		Gson gson = new GsonBuilder().create();
		DAO = HibernateToDoListDAO$.MODULE$;
		ArrayList<User> users = DAO.getUsers();
		for (User u: users){
			u.setPassword("******");
		}
		String jsonArray = gson.toJson(users);
		return Response.status(200).entity(jsonArray).build();	
	}
	
	//get user by id
	@GET
	@Path("/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@QueryParam("id") int id) throws ToDoListException{
		Gson gson = new Gson();
		DAO = HibernateToDoListDAO$.MODULE$;
		User user = DAO.getUser(id);
		user.setPassword("******");
		String json = gson.toJson(user);
		return Response.status(200).entity(json).build();
	}
	
	//get user items
	@GET
	@Path("/getUserItems")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserItems(@QueryParam("id") int id) throws ToDoListException{
		Gson gson = new GsonBuilder().create();
		DAO = HibernateToDoListDAO$.MODULE$;
		ArrayList<Item> items = DAO.getItems(id);
		String json = gson.toJson(items);
		return Response.status(200).entity(json).build();
	}
	
	//Service verify
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(String result) {
		result = "ToDoListRESTService Successfully started..";
		return Response.status(200).entity(result).build();
	}
}

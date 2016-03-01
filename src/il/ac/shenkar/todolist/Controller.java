package il.ac.shenkar.todolist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public Controller() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateToDoListDAO$ DAO = HibernateToDoListDAO$.MODULE$;
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;
		HttpSession userSession = request.getSession();
		String path = request.getQueryString();
		try{
			if(path.endsWith("addItem")){
				dispatcher = getServletContext().getRequestDispatcher("/additem.jsp");
			}
			else if(path.endsWith("logout")){
				userSession.setMaxInactiveInterval(0);
	        	Cookie[] cookies = request.getCookies();
	        	if (cookies != null) {
	        		 
	                for (int i = 0; i < cookies.length; i++) {
	         
	                    Cookie cookie = cookies[i];
	                    cookies[i].setValue(null);
	                    cookies[i].setMaxAge(0);
	                    response.addCookie(cookie);
	                }
	            }
				dispatcher = getServletContext().getRequestDispatcher("/index.html");
			}
			else if (path.endsWith("deleteUser")) {
				userSession = request.getSession();
	        	int userId = Integer.valueOf((String) userSession.getAttribute("userId"));
	        	ArrayList<Item> items = DAO.getItems(userId);
	        	for(Item i: items){
	        		DAO.deleteItem(i);
	        	}
	        	DAO.deleteUser(userId);
	        	Cookie[] cookies = request.getCookies();
	        	if (cookies != null) {
	        		 
	                for (int i = 0; i < cookies.length; i++) {
	         
	                    Cookie cookie = cookies[i];
	                    cookies[i].setValue(null);
	                    cookies[i].setMaxAge(0);
	                    response.addCookie(cookie);
	                }
	            }
	        	userSession.setMaxInactiveInterval(0);
	    		dispatcher = getServletContext().getRequestDispatcher("/index.html");
	        }
			else if (path.endsWith("changePass")){
		    	dispatcher = getServletContext().getRequestDispatcher("/passchange.jsp");
			}
			else if(path.endsWith("accountSettings")){
				dispatcher = getServletContext().getRequestDispatcher("/account.jsp");
			}
			else if(path.endsWith("update")){
				String itemId = (String)request.getParameter("itemId");
				dispatcher = getServletContext().getRequestDispatcher("/itemsettings.jsp");
			}
			else if(path.endsWith("backToHome")){
				userSession = request.getSession();
	        	int userId = Integer.valueOf((String) userSession.getAttribute("userId"));
	        	User user = null;
	        	try {
					user = DAO.getUser(userId);
				} catch (ToDoListException e) {
					request.setAttribute("exception", e.getMessage());
					dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				}
				Cookie cookie = new Cookie("userName", user.getUserName());
				cookie.setMaxAge(60 * 30);
				response.addCookie(cookie);
				ArrayList<Item> items =  DAO.getItems(user.getId());
	   			user.setItemCount(DAO.getItemCount(user.getId()));
	   			request.setAttribute("user", user);
				request.setAttribute("items", items);
				dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			}
			dispatcher.forward(request, response);
		} catch (ToDoListException e){
			request.setAttribute("exception", e.getMessage());
            dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateToDoListDAO$ DAO = HibernateToDoListDAO$.MODULE$;
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;
		HttpSession userSession = null;
		String userId = null;
		String location = null;
	    String action = request.getParameter("action");
	    try {
		    if(action.equals("Sign in")){		    	
				String userName = request.getParameter("userName");
			    String password = request.getParameter("password");
		    	ArrayList<User> users = DAO.getUsers();
		    	User user = null;
			   	for(User u: users){
			    	if(u.getUserName().equals(userName) && u.getPassword().equals(password)){
			    		u.setAuth(true);
			    		user = u;
			    		break;
			    	}
			    }
			   	if (user != null && user.isAuth()){			   		
			   		userId = String.valueOf(user.getId());
			   		location = "home";
			   		userSession = request.getSession();
			   		userSession.setMaxInactiveInterval(-1);
			   		userSession.setAttribute("userId", userId);
			   		Cookie cookie = new Cookie("userName", user.getUserName());
					cookie.setMaxAge(60 * 30);
					response.addCookie(cookie);
					ArrayList<Item> items =  DAO.getItems(user.getId());
		   			user.setItemCount(DAO.getItemCount(user.getId()));
		   			request.setAttribute("user", user);
					request.setAttribute("items", items);
					dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		            dispatcher.forward(request, response);
			   		
			   	}
			    else{
			    	throw new ToDoListException("User not authenticated");
			    }
			}
		    else if(action.equals("Sign up")){
				String userName = request.getParameter("userName");
			    String password = request.getParameter("password");
		    	User newUser = new User(userName, password);
		    	ArrayList<User> users = DAO.getUsers();
		    	for(User u: users){
		    		if(newUser.getUserName().equals(u.getUserName())){
		    			throw new ToDoListException("User already exists");		    		
		    		}
		    	}	
	    		DAO.addUser(newUser);
		    	userSession = request.getSession();
		    	userSession.setMaxInactiveInterval(30 * 60);
		    	userId = String.valueOf(newUser.getId());
		    	Cookie cookie = new Cookie("userName", newUser.getUserName());
				cookie.setMaxAge(60 * 30);
				response.addCookie(cookie);
				ArrayList<Item> items =  DAO.getItems(newUser.getId());
				newUser.setItemCount(DAO.getItemCount(newUser.getId()));
	   			request.setAttribute("user", newUser);
	   			request.setAttribute("items", items);
		    	userSession.setAttribute("userId", userId);
		    	dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		    	dispatcher.forward(request, response);

		    }
		    else if(action.equals("changePass")){
	    		userSession = request.getSession();
	    		userId = ((String) userSession.getAttribute("userId"));
	    		String oldPass = (String) request.getParameter("oldPass");
	    		String newPass = (String) request.getParameter("newPass");
	    		String newPassConfirm = (String) request.getParameter("newPass2");
	    		if(newPass.equals(newPassConfirm)){
	    			User user = DAO.getUser(Integer.parseInt(userId));			
	    			if(user.getPassword().equals(oldPass)){
	    				user.setPassword(newPass);
	  	    			DAO.updateUser(user);
				    	dispatcher = getServletContext().getRequestDispatcher("/account.jsp");
	    			}
	    			else{
	    				throw new ToDoListException("Wrong password");
	    			}
	    		}
	    		else{
	    			throw new ToDoListException("Password does not match");
	    		}
	    	}
			else if(action.equals("updateItemDone")){
				userSession = request.getSession();
	        	userId = (String) userSession.getAttribute("userId");
	        	String itemName = request.getParameter("desc");
	        	String itemDueDate = request.getParameter("date");
	        	String itemId = request.getParameter("itemId");
	        	Item item = new Item(itemName, Integer.parseInt(userId));
	        	item.setDueDate(itemDueDate);
	        	item.setId(Integer.parseInt(itemId));
	        	DAO.updateItem(item);
	        	User user = DAO.getUser(Integer.parseInt(userId));
	        	Cookie cookie = new Cookie("userName", user.getUserName());
				cookie.setMaxAge(60 * 30);
				response.addCookie(cookie);
				ArrayList<Item> items =  DAO.getItems(user.getId());
				user.setItemCount(DAO.getItemCount(user.getId()));
	   			request.setAttribute("user", user);
	   			request.setAttribute("items", items);
	        	dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			}
			else if(action.equals("changeAccount")){
				userSession = request.getSession();
				userId = (String) userSession.getAttribute("userId");
				location = "home";
				String fullName = request.getParameter("fullName");
				String email = request.getParameter("email");
				User user = DAO.getUser(Integer.parseInt(userId));
				user.setFullName(fullName);
				user.setEmail(email);
				DAO.updateUser(user);
				Cookie cookie = new Cookie("userName", user.getUserName());
				cookie.setMaxAge(60 * 30);
				response.addCookie(cookie);
				ArrayList<Item> items =  DAO.getItems(user.getId());
				user.setItemCount(DAO.getItemCount(user.getId()));
	   			request.setAttribute("user", user);
	   			request.setAttribute("items", items);
				dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}
			else if(action.equals("delete")){//delete item
				userSession = request.getSession();
				userId = (String) userSession.getAttribute("userId");
				int itemId = Integer.parseInt((String) request.getParameter("itemId"));				
				Item item = DAO.getItem(itemId);
				DAO.deleteItem(item);	
				User user = DAO.getUser(Integer.parseInt(userId));
				Cookie cookie = new Cookie("userName", user.getUserName());
				cookie.setMaxAge(60 * 30);
				response.addCookie(cookie);
				ArrayList<Item> items =  DAO.getItems(user.getId());
				user.setItemCount(DAO.getItemCount(user.getId()));
	   			request.setAttribute("user", user);
	   			request.setAttribute("items", items);
				dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			}
			else if(action.equals("update")){
				String itemId = (String)request.getParameter("itemId");
				request.setAttribute("item", itemId);
				dispatcher = getServletContext().getRequestDispatcher("/itemsettings.jsp");
			}
			else if(action.equals("done")){
				userSession = request.getSession();
				String itemName = request.getParameter("itemName");
				String itemDate = request.getParameter("itemDate");
				userId = (String) userSession.getAttribute("userId");
				Item item = new Item(itemName, Integer.parseInt(userId));
				item.setDueDate(itemDate);					
				DAO.addItem(item);
				User user = DAO.getUser(Integer.parseInt(userId));
				Cookie cookie = new Cookie("userName", user.getUserName());
				cookie.setMaxAge(60 * 30);
				response.addCookie(cookie);
				ArrayList<Item> items =  DAO.getItems(user.getId());
				user.setItemCount(DAO.getItemCount(user.getId()));
	   			request.setAttribute("user", user);
	   			request.setAttribute("items", items);
				dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			}
            dispatcher.forward(request, response);
		   // response.sendRedirect("PageController?userId=" + userId + "&where=" + location);
	    } catch (ToDoListException e){
	    	request.setAttribute("exception", e.getMessage());
            dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
	    }	
	}
}

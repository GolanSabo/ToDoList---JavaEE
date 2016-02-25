package il.ac.shenkar.todolist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PageController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	public PageController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateToDoListDAO$ DAO = HibernateToDoListDAO$.MODULE$;
		RequestDispatcher dispatcher = null;
		String userId = request.getParameter("userId");
		String location = request.getParameter("where");
		User user = null;
		if (location.equals("home")){
			try {
				user = DAO.getUser(Integer.parseInt(userId));
			} catch (ToDoListException e) {
				request.setAttribute("exception", e.getMessage());
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
			}
			Cookie cookie = null;
			cookie = new Cookie("userName", user.getUserName());
			cookie.setMaxAge(60 * 30);
			response.addCookie(cookie);
			ArrayList<Item> items =  DAO.getItems(user.getId());
   			user.setItemCount(DAO.getItemCount(user.getId()));
   			request.setAttribute("user", user);
   			request.setAttribute("items", items);
		}
    	dispatcher = getServletContext().getRequestDispatcher("/" + location +".jsp");
    	dispatcher.forward(request, response);
	}
}

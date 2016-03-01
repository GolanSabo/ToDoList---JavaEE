package il.ac.shenkar.todolist;

public class main {

	public static void main(String[] args) throws ToDoListException {
		HibernateToDoListDAO$ DAO = HibernateToDoListDAO$.MODULE$;
		User user= new User("Haim","life");
		DAO.addUser(user);
		Item item1= new Item("homework",3);
		Item item2= new Item("sleep",3);
		DAO.addItem(item1);
		DAO.addItem(item2);
	}

}

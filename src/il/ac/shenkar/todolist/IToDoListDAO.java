package il.ac.shenkar.todolist;

import java.util.ArrayList;
import il.ac.shenkar.todolist.ToDoListException;

public interface IToDoListDAO {
	
	void updateItem(Item item) throws ToDoListException;
	void updateUser(User user) throws ToDoListException;
	void deleteItem(Item item) throws ToDoListException;
	void deleteUser(int userId) throws ToDoListException;
	void addItem(Item item) throws ToDoListException;
	void addUser(User user) throws ToDoListException;
	Item getItem(int id) throws ToDoListException;
	User getUser(int id) throws ToDoListException;
	long getItemCount(int userId);
	ArrayList<User> getUsers();
	ArrayList<Item> getItems(int userId);
}

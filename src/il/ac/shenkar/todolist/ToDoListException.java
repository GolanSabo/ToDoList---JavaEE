package il.ac.shenkar.todolist;

public class ToDoListException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ToDoListException(){
		
	}
	
	public ToDoListException(String message) {
        super(message);
    }

}

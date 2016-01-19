package il.ac.shenkar.todolist;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "to_do_list")
public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name="userId")
	private int userId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="dueDate")
	private String dueDate;
	
	@Column(name="done")
	private int done;
	
	public Item() {}
	
	public Item(String description, int userId) {
		super();
		this.description = description;
		this.userId = userId;
		this.done = 0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int isDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDueDate() {
        return dueDate;
	}

	public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", userId=" + userId + ", description=" + description + ", dueDate=" + dueDate
				+ ", done=" + done + "]";
	}

	
}

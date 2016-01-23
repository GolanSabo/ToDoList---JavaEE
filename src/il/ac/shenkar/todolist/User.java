package il.ac.shenkar.todolist;

import java.io.Serializable;

import javax.persistence.*;

import com.google.gson.Gson;

@Entity
@Table(name="to_do_list")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	private boolean auth;
	
	private long itemCount;
	
	public User() {}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.auth = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	
	
	public long getItemCount() {
		return itemCount;
	}

	public void setItemCount(long itemCount) {
		this.itemCount = itemCount;
	}
	
	public String toJson(User user){
		Gson gson = new Gson();
		String json = gson.toJson(user, this.getClass());
		return json; 
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", fullName=" + fullName + ", password=" + password + ", email="
				+ email + ", auth=" + auth + "]";
	}
}

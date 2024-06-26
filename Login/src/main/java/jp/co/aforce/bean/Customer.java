package jp.co.aforce.bean;

public class Customer implements java.io.Serializable{

	private int id;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
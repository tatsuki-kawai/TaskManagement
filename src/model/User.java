package model;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String pass;

	public User() {

	}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass() {
		return this.pass;
	}
}

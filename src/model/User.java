package model;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String pass;

	public User() {

	}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public User(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
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

package model;

import java.io.Serializable;

public class Task implements Serializable {
	private int id;
	private String name;
	private String timeLimit;
	private int user_id;

	public Task() {

	}

	public Task(String name, String timeLimit) {
		this.name = name;
		this.timeLimit = timeLimit;
	}

	public Task(int id, String name, String timeLimit, int user_id) {
		this.id = id;
		this.name = name;
		this.timeLimit = timeLimit;
		this.user_id = user_id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getTimeLimit() {
		return this.timeLimit;
	}

	public void setUserID(int user_id) {
		this.user_id = user_id;
	}

	public int getUserID() {
		return this.user_id;
	}
}

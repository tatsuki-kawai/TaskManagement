package model;

import java.io.Serializable;

public class Task implements Serializable {
	private String name;
	private String timeLimit;

	public Task() {

	}

	public Task(String name, String timeLimit) {
		this.name = name;
		this.timeLimit = timeLimit;
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
}

package model;

import java.util.ArrayList;

import dao.UserDAO;

public class PrintTaskLogic {
	public ArrayList<Task> execute(String name, String password){
		ArrayList<Task> taskList = new ArrayList<Task>();
		UserDAO userDAO = new UserDAO();
		int userId = userDAO.getUserID(name, password);
		taskList =  userDAO.getUserTask(userId);
		return taskList;
	}
}

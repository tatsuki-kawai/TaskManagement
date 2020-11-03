package model;

import dao.UserDAO;

public class DeleteTaskLogic {
	public void execute(Task task) {
		UserDAO userDAO = new UserDAO();
		userDAO.deleteTask(task);
	}
}

package model;

import dao.UserDAO;

public class ReflectTaskLogic {
	public void execute(Task task) {
		UserDAO userDAO = new UserDAO();
		userDAO.editTask(task);
	}

}

package model;

import dao.UserDAO;

public class CreateTaskLogic {
	public void execute(User user, String taskName, String taskLimit) {
		UserDAO userDAO = new UserDAO();
		user.setId(userDAO.getUserID(user.getName(), user.getPass()));
		userDAO.createTask(taskName, taskLimit, user.getId());
	}
}

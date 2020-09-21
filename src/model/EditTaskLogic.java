package model;

import dao.UserDAO;

public class EditTaskLogic {
	public Task execute(User user, String name, String timeLimit) {
		UserDAO userDAO = new UserDAO();
		int user_id = userDAO.getUserID(user.getName(), user.getPass());
		user.setId(user_id);
		Task task = userDAO.getTask(user, name, timeLimit);
		return task;
	}
}

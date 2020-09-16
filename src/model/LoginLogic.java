package model;

import dao.UserDAO;

public class LoginLogic {
	public boolean execute(User user) {
		  Boolean exist;
		  UserDAO userDAO = new UserDAO();
		  exist = userDAO.confirmUser(user.getName(), user.getPass());
          return exist;
	}

}

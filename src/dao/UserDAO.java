package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Task;

public class UserDAO {

	//データベース接続に使用する情報
	private final String driverClassName = "org.postgresql.Driver";
	private final String JDBC_URL = "jdbc:postgresql://localhost/taskManagement";
	private final String user = "dbpuser";
	private final String password = "hogehoge";
	Connection connection;
	ResultSet resultSet;

	PreparedStatement pS_getUserCount;
	PreparedStatement pS_getTaskCount;
	PreparedStatement pS_registerUser;
	PreparedStatement pS_confirmUser;
	PreparedStatement pS_getUserId;
	PreparedStatement pS_createTask;
	PreparedStatement pS_printTask;

    String getUserCountSQL = "SELECT * FROM app_user";
    String getTaskCountSQL = "SELECT * FROM task";
    String registerUserSQL = "INSERT INTO app_user VALUES(?,?,?)";
    String confirmUserSQL = "SELECT * FROM app_user WHERE name = ?";
    String getUserIdSQL = "SELECT * FROM app_user WHERE name = ? and password = ?";
    String createTaskSQL = "INSERT INTO task VALUES(?,?,?,?)";
    String getUserTask = "SELECT * FROM task WHERE user_id=?" ;

    public UserDAO(){

    	try{
    		Class.forName(driverClassName);
    		connection = DriverManager.getConnection(JDBC_URL, user, password);
    		pS_getUserCount = connection.prepareStatement(getUserCountSQL);
    		pS_getTaskCount = connection.prepareStatement(getTaskCountSQL);
    		pS_registerUser = connection.prepareStatement(registerUserSQL);
    		pS_confirmUser = connection.prepareStatement(confirmUserSQL);
    		pS_getUserId = connection.prepareStatement(getUserIdSQL);
    		pS_createTask = connection.prepareStatement(createTaskSQL);
    		pS_printTask = connection.prepareStatement(getUserTask);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public int getUserCount() { //ユーザー数の取得
    	int userCount = 0;
        try {
        	resultSet = pS_getUserCount.executeQuery();
        	while(resultSet.next()) {
        		userCount++;
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return userCount;
    }

    public int getTaskCount() { //登録された目標の数を取得する
    	int taskCount = 0;
    	try {
    		resultSet = pS_getTaskCount.executeQuery();
    		while(resultSet.next()) {
    			taskCount++;
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return taskCount;
    }

    public void registerUser(String name, String password) { //ユーザーの登録
    	int id = getUserCount() + 1;
    	try {
    		pS_registerUser.setInt(1, id);
    		pS_registerUser.setString(2, name);
    		pS_registerUser.setString(3, password);
    		pS_registerUser.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public Boolean confirmUser(String name, String password) { //引数のユーザーと一致するユーザーがいるかどうかを確認する
    	String userPassword;
        try {
        	pS_confirmUser.setString(1, name);
        	resultSet = pS_confirmUser.executeQuery();
        	while(resultSet.next()) {
        		userPassword = resultSet.getString("password");

        		if(password.equals(userPassword)) { //パスワードが一致したら
        			return true;
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return false;
    }

    public int getUserID(String name, String password) {
    	int userId = 0;
    	try {
    		pS_getUserId.setString(1,name);
    		pS_getUserId.setString(2, password);
    		resultSet = pS_getUserId.executeQuery();
    		while(resultSet.next()) {
    			userId = resultSet.getInt("id");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return userId;
    }

    public void createTask(String userName, String limit, int userId) { //目標を新規に作成する
    	int id = getTaskCount() + 1;
    	try {
    		pS_createTask.setInt(1, id);
    		pS_createTask.setString(2, userName);
    		pS_createTask.setString(3, limit);
    		pS_createTask.setInt(4, userId);
    		pS_createTask.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public ArrayList<Task> getUserTask(int userId) {
    	ArrayList<Task> taskList = new ArrayList<Task>();
    	try {
    		pS_printTask.setInt(1, userId);
    		resultSet = pS_printTask.executeQuery();
    		while(resultSet.next()) {
    			String name = resultSet.getString("name");
    			String deadline = resultSet.getString("deadline");
    			Task task = new Task(name, deadline);
    			taskList.add(task);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return taskList;
    }
}


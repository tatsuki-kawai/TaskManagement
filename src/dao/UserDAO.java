package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	//データベース接続に使用する情報
	private final String driverClassName = "org.postgresql.Driver";
	private final String JDBC_URL = "jdbc:postgresql://localhost/taskManagement";
	private final String user = "dbpuser";
	private final String password = "hogehoge";
	Connection connection;
	ResultSet resultSet;

	PreparedStatement pS;
	PreparedStatement pS_registerUser;
	PreparedStatement pS_confirmUser;

    String sql = "SELECT * FROM app_user";
    String registerUserSQL = "INSERT INTO app_user VALUES(?,?,?)";
    String confirmUserSQL = "SELECT * FROM app_user WHERE name = ?";

    public UserDAO(){

    	try{
    		Class.forName(driverClassName);
    		connection = DriverManager.getConnection(JDBC_URL, user, password);
    		pS = connection.prepareStatement(sql);
    		pS_registerUser = connection.prepareStatement(registerUserSQL);
    		pS_confirmUser = connection.prepareStatement(confirmUserSQL);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public int getUserCount() { //ユーザー数の取得
    	int userCount = 0;
        try {
        	resultSet = pS.executeQuery();
        	while(resultSet.next()) {
        		userCount++;
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return userCount;
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

    public Boolean confirmUser(String name, String password) { //ユーザーの情報かどうかを確認する
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

    public static void main(String[] args) {
    	UserDAO dao = new UserDAO();
    	dao.registerUser("カワイ", "1234");
    }
}


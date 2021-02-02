package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pojo.User;
import com.pojo.Users;


public class UserDB {
	public static boolean isExist() {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		String query = 
				"SELECT TOP 1 * FROM Student";
		try(
			Connection connection =  connectionPool.getConnection();
			Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(query);
			)
		{
			return resultSet.next();
		}
		catch(SQLException e)
		{
			for (Throwable throwable : e) {
				throwable.printStackTrace();
			}
			return false;
		}
	}
	
	public static Users selectUsers() {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		String query = 
				"SELECT * FROM Student";
		Users users = new Users();
		try( 
				Connection connection = connectionPool.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
			)
		{
			while(resultSet.next()) {
				User user = new User(resultSet.getString("email"),
									 resultSet.getString("FirstName"),
									 resultSet.getString("LastName"));
				users.getUsers().add(user);
			}
		}
		catch(SQLException e)
		{
			for (Throwable throwable : e) {
				throwable.printStackTrace();
			}
		}
		return users;
		
	}
	public static int deleteUser(String email) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		String query = "DELETE Student WHERE email = ?";
		int countRowDelete = 0;
		try	(
				Connection connection = connectionPool.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(query); 
			)
		{
			prepareStatement.setString(1, email); 
			countRowDelete =  prepareStatement.executeUpdate();
			return countRowDelete;
		}
		catch(SQLException e)
		{
			for (Throwable throwable : e) {
				throwable.printStackTrace();
			}
			return countRowDelete;
		}
	}
	
	public static int insertUser(String email, String firstName, String lastName) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		String query = "INSERT INTO Student "
					   +"VALUES (?,?,?)";
		int countRowInsert = 0;
		try	(
				Connection connection = connectionPool.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(query); 
			)
		{
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, firstName); 
			prepareStatement.setString(3, lastName); 
			countRowInsert =  prepareStatement.executeUpdate();
			return countRowInsert;
		}
		catch(SQLException e)
		{
			for (Throwable throwable : e) {
				throwable.printStackTrace();
			}
			return countRowInsert;
		}
	}
	
	public static User selectUser(String email) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		ResultSet resultSet = null;
		User user = new User();
		String query = "SELECT * FROM Student WHERE email = ?";
		try	(
				Connection connection = connectionPool.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(query); 
			)
		{
			prepareStatement.setString(1, email); 
			resultSet =  prepareStatement.executeQuery();
			while(resultSet.next()) {
				user.setEmail(resultSet.getString("Email"));
				user.setFristName(resultSet.getString("FirstName"));
				user.setLastName(resultSet.getString("LastName"));
			}
			return user;
		}
		catch(SQLException e)
		{
			for (Throwable throwable : e) {
				throwable.printStackTrace();
			}
			DBUtil.closeResultSet(resultSet);
			return null;
		}
	}
	
	public static int updateUser(String email, String firstName, String lastName) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		String query = "UPDATE Student "+
					   "SET FirstName = ?, LastName = ? "+
					   "WHERE email = ?";
		int countRowDelete = 0;
		try	(
				Connection connection = connectionPool.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(query); 
			)
		{	
			prepareStatement.setString(1, firstName);
			prepareStatement.setString(2, lastName);
			prepareStatement.setString(3, email); 
			countRowDelete =  prepareStatement.executeUpdate();
			return countRowDelete;
		}
		catch(SQLException e)
		{
			for (Throwable throwable : e) {
				throwable.printStackTrace();
			}
			return countRowDelete;
		}
	}
}

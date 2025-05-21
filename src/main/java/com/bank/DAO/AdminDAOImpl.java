package com.bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO
{
	//selection
	private static final String admin_login="select * from admin_details where EmailId=? and Password=?";
	private static final String url="jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=root";
	public boolean selectAdminDetailsByUsingEmailIdAndPassword(String emailId, String password) 
	{
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(admin_login);
			preparedStatement.setString(1, emailId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				//System.out.println("Login successfull...1");
				return true;
			}
			else
			{
				//System.out.println("Invalid emailId or password");
				return false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

	

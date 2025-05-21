package com.bank.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.BankCustomerDetails;

public class BankCustomerDAOImpl implements BankCustomerDAO
{
	private static final String update_pin_accountnumber="update bank_customer_details set Account_Number=? ,Pin=?,Status=?where Id=?";
	private static final String insert_customer_details= "insert into bank_customer_details"
	+ "(Name, EmailId, Mobile_Number, Aadhar_Number, Pan_Number, Date_Of_Birth, Address, Amount, Age, Gender,Status) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String url="jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=root";
	private static final String delete_customer_details="delete from bank_customer_details where Id=?";
	private static final String customer_login="select * from bank_customer_details where EmailId=? and Pin=?";
	public String select="select EmailId form bank_customer_details";
	@Override
	public void insertCustomerDetails(BankCustomerDetails bankCustomerDetails)
	{
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insert_customer_details);
			preparedStatement.setString(1, bankCustomerDetails.getName());
			preparedStatement.setString(2, bankCustomerDetails.getEmailId());
			preparedStatement.setLong(3, bankCustomerDetails.getMobileNumber());
			preparedStatement.setLong(4, bankCustomerDetails.getAadharNumber());
			preparedStatement.setString(5, bankCustomerDetails.getPanNumber());
			preparedStatement.setDate(6, bankCustomerDetails.getDateOfBirth());
			preparedStatement.setString(7, bankCustomerDetails.getAddress());
			preparedStatement.setDouble(8, bankCustomerDetails.getAmount());
			preparedStatement.setInt(9, bankCustomerDetails.getAge());
			preparedStatement.setString(10, bankCustomerDetails.getGender());
			preparedStatement.setString(11, "Pending");
			int result = preparedStatement.executeUpdate();
			if(result>0)
			{
				System.out.println("Customer registration sucessfull...");
			}
			else
			{
				System.out.println("Invalid data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<BankCustomerDetails> getAllCustomerDetails() {
		final String select_All = "select * from bank_customer_details";
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(select_All);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<BankCustomerDetails> listOfBankCustomerDetails = new ArrayList<BankCustomerDetails>();
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					BankCustomerDetails bankCustomerDetails = new BankCustomerDetails();
					bankCustomerDetails.setId(resultSet.getInt("Id"));
					bankCustomerDetails.setName(resultSet.getString("Name"));
					bankCustomerDetails.setEmailId(resultSet.getString("EmailId"));
					bankCustomerDetails.setAadharNumber(resultSet.getLong("Aadhar_Number"));
					bankCustomerDetails.setMobileNumber(resultSet.getLong("Mobile_Number"));
					bankCustomerDetails.setPanNumber(resultSet.getString("Pan_Number"));
					bankCustomerDetails.setStatus(resultSet.getString("Status"));
					listOfBankCustomerDetails.add(bankCustomerDetails);
				}
				return listOfBankCustomerDetails;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public void updateAccountNumberAndPinNumberByUsingId(BankCustomerDetails bankCustomerDetails) {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(update_pin_accountnumber);
			preparedStatement.setInt(1, bankCustomerDetails.getAcountNumber());
			preparedStatement.setInt(2, bankCustomerDetails.getPin());
			preparedStatement.setString(3, "Accepted");
			preparedStatement.setInt(4, bankCustomerDetails.getId());
			
			int result=preparedStatement.executeUpdate();
			if(result>0) {
				System.out.println("Updated");
			}
			else {
				System.out.println("Not Updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteCustomerDetailsByUsingId(BankCustomerDetails bankCustomerDetails) {
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(delete_customer_details);
			preparedStatement.setInt(1, bankCustomerDetails.getId());
			int result=preparedStatement.executeUpdate();
			if(result>0) {
				System.out.println("Deleted");
			}
			else {
				System.out.println("Not Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean selectCustomerDetailsByUsingEmailidAndPassword(String emailId, int pin) 
	{
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(customer_login);
			preparedStatement.setString(1, emailId);
			preparedStatement.setInt(2, pin);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}

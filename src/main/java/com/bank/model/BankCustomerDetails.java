package com.bank.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankCustomerDetails {
	/*Id, Name, EmailId, Mobile_Number, Aadhar_Number, Pan_Number, Account_Number, Pin, Date_Of_Birth,
	 *  Address, Amount, Age, Gender */
	private int id;
	private String name;
	private String emailId;
	private long mobileNumber;
	private long aadharNumber;
	private String panNumber;
	private int acountNumber;
	private int pin;
	private Date dateOfBirth;
	private String address;
	private double amount;
	private int age;
	private String gender;
	private String status;
	public BankCustomerDetails() 
	{
		
	}
	public BankCustomerDetails(int id,String name, String emailId, long mobileNumber, long aadharNumber, String panNumber,
			int acountNumber, int pin, Date dateOfBirth, String address, double amount, int age, String gender, String status) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.acountNumber = acountNumber;
		this.pin = pin;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.amount = amount;
		this.age = age;
		this.gender = gender;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public int getAcountNumber() {
		return acountNumber;
	}
	public void setAcountNumber(int acountNumber) {
		this.acountNumber = acountNumber;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "BankCustomerDetails [id=" + id + ", name=" + name + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", acountNumber="
				+ acountNumber + ", pin=" + pin + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", amount="
				+ amount + ", age=" + age + ", gender=" + gender + ", status=" + status + "]";
	}
	public boolean validation(String given)
	{
		String select = "select EmailId from teca_66_advance_java.bank_customer_details";
		boolean isPresent=false;
		try {
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(select);
			while(resultSet.next())
			{
				if(resultSet.getString("EmailId").equals(given))
				{
					isPresent=true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}


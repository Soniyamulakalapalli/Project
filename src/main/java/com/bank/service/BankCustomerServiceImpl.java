package com.bank.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.bank.DAO.BankCustomerDAO;
import com.bank.DAO.BankCustomerDAOImpl;
import com.bank.exception.BankCustomerException;
import com.bank.model.BankCustomerDetails;

public class BankCustomerServiceImpl implements BankCustomerService
{
	Scanner scan = new Scanner(System.in);
	BankCustomerDAO bankCustomerDAO = new BankCustomerDAOImpl();
	@Override
	public void bankCustomerDetails()
	{
		List<BankCustomerDetails> allCustomerDetails = bankCustomerDAO.getAllCustomerDetails();
		BankCustomerDetails bankCustomerDetails = new BankCustomerDetails();
		System.out.println("Enter customer name");
		String name = scan.next();
		bankCustomerDetails.setName(name);
		while(true)
		{
			System.out.println("Enter customer emailId");
			String emailId=scan.next();
			int emailCount=0;
			try
			{
				for(BankCustomerDetails bankCustomerDetails2 : allCustomerDetails)
				{
					if(bankCustomerDetails2.getEmailId().equals(emailId))
					{
						emailCount++;
					}
				}
				if(emailCount>0)
				{
					throw new BankCustomerException("Entered emailId is already existed");
				}
				else
				{
					bankCustomerDetails.setEmailId(emailId);
					break;
				}
			}
			catch(BankCustomerException e)
			{
				System.out.println(e.getMsg());
			}
		}
		while(true)
		{
			System.out.println("Enter customer mobile number");
			long mobileNumber = scan.nextLong();
			int mobileCount=0;
			try
			{
				for(BankCustomerDetails bankCustomerDetails2 : allCustomerDetails)
				{
					if(bankCustomerDetails2.getMobileNumber()==mobileNumber)
					{
						mobileCount++;
					}
				}
				if(mobileCount>0)
				{
					throw new BankCustomerException("Entered Mobile number is already existed");
				}
				else
				{
					bankCustomerDetails.setMobileNumber(mobileNumber);
					break;
				}
			}
			catch(BankCustomerException e)
			{
				System.out.println(e.getMsg());
			}
		}
		
		while(true)
		{
			System.out.println("Enter customer Aadhar number");
			long aadharNumber = scan.nextLong();
			int aadharCount=0;
			try
			{
				for(BankCustomerDetails bankCustomerDetails2 : allCustomerDetails)
				{
					if(bankCustomerDetails2.getAadharNumber()==aadharNumber)
					{
						aadharCount++;
					}
				}
				if(aadharCount>0)
				{
					throw new BankCustomerException("Entered Aadhar number is already existed");
				}
				else
				{
					bankCustomerDetails.setAadharNumber(aadharNumber);
					break;
				}
			}
			catch(BankCustomerException e)
			{
				System.out.println(e.getMsg());
			}
		}
		while(true)
		{
			System.out.println("Enter PAN card number(ABCDE1234S)");
			String panNumber = scan.next();
			int panCount=0;
			try
			{
				for(BankCustomerDetails bankCustomerDetails2 : allCustomerDetails)
				{
					if(bankCustomerDetails2.getPanNumber().equals(panNumber))
					{
						panCount++;
					}
				}
				if(panCount>0)
				{
					throw new BankCustomerException("Entered Pan number is already existed");
				}
				else
				{
					bankCustomerDetails.setPanNumber(panNumber);
					break;
				}
			}
			catch(BankCustomerException e)
			{
				System.out.println(e.getMsg());
			}
		}
		System.out.println("Enter customer DATE OF BIRTH(YYYY-MM-DD)");
		String dob = scan.next();
		bankCustomerDetails.setDateOfBirth(Date.valueOf(dob));
		System.out.println("Enter customer address");
		String address = scan.next();
		bankCustomerDetails.setAddress(address);
		System.out.println("Enter customer gender");
		String gender = scan.next();
		bankCustomerDetails.setGender(gender);
		System.out.println("Enter customer age");
		int age = scan.nextInt();
		bankCustomerDetails.setAge(age);
		System.out.println("Enter amount");
		double amount = scan.nextDouble();
		bankCustomerDetails.setAmount(amount);
		bankCustomerDAO.insertCustomerDetails(bankCustomerDetails);
	}
	@Override
    public void customerLogin() {
	System.out.println("Enter customer emailId");
	String emailId = scan.next();
	System.out.println("Enter customer pin");
	int pin = scan.nextInt();
	if(bankCustomerDAO.selectCustomerDetailsByUsingEmailidAndPassword(emailId,pin))
	{
		System.out.println("Login sucessfull...!");
	}
	else
	{
		System.out.println("Invalid EmailId Or Password");
	}
}
}

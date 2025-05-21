package com.bank.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bank.DAO.AdminDAO;
import com.bank.DAO.AdminDAOImpl;
import com.bank.DAO.BankCustomerDAO;
import com.bank.DAO.BankCustomerDAOImpl;
import com.bank.model.BankCustomerDetails;

public class AdminServiceImpl implements AdminService
{
	Scanner scan = new Scanner(System.in);
	BankCustomerDAO bankCustomerDAO = new BankCustomerDAOImpl();
	
	AdminDAO adminDAO = new AdminDAOImpl();
	@Override
	public void adminLogin() {
		System.out.println("Enter admin email id");
		String emailId = scan.next();
		System.out.println("Enter admin password");
		String password = scan.next();
		if(adminDAO.selectAdminDetailsByUsingEmailIdAndPassword(emailId, password))
		{
			System.out.println("Enter \n1. To get all account request details \n2. To get all user details \n3. To get all account closing details ");
			switch(scan.nextInt())
			{
			case 1:
				System.out.println("All Account Request Details");
				allPendingDetails();
				
				break;
			case 2:
				System.out.println("All User Details");
				allUserDetails();
				break;
			case 3:
				System.out.println("All Account Closing Request Details");
				break;
			default:
				System.out.println("Invalid Request");
				break;
			}
		}
	}
	public void allUserDetails() {
		List<BankCustomerDetails> allCustomerDetails=bankCustomerDAO.getAllCustomerDetails();
		allCustomerDetails.forEach((customerDetails)->{
			System.out.println("Customer Name: "+customerDetails.getName());
			System.out.println("Customer EmailId: "+customerDetails.getEmailId());
			System.out.println("Customer Mobile Number: "+customerDetails.getMobileNumber());
			System.out.println("Customer status :"+customerDetails.getStatus());
			System.out.println("-------*********----------********--------");

		});
		
	}
	@Override
	public void allPendingDetails() {
		List<BankCustomerDetails> allCustomerDetails = bankCustomerDAO.getAllCustomerDetails();
		List<BankCustomerDetails> allpendingdetailslist=new ArrayList<BankCustomerDetails>();
		for(BankCustomerDetails bankCustomerDetails : allCustomerDetails)
		{
			if(bankCustomerDetails.getStatus().equalsIgnoreCase("Pending"))
			{
				BankCustomerDetails bankCustomerDetails2=new BankCustomerDetails();
				bankCustomerDetails2.setId(bankCustomerDetails.getId());
				bankCustomerDetails2.setName(bankCustomerDetails.getName());
				bankCustomerDetails2.setEmailId(bankCustomerDetails.getEmailId());
				allpendingdetailslist.add(bankCustomerDetails2);
				//int index = allCustomerDetails.indexOf(bankCustomerDetails)+1;
				int indexOf =allpendingdetailslist.indexOf(bankCustomerDetails2)+1;
				System.out.println("S.No :"+ indexOf);
				System.out.println("Customer Name :"+bankCustomerDetails.getName());
				System.out.println("Customer emailid :"+ bankCustomerDetails.getEmailId());
				System.out.println("Customer Mobile number :"+ bankCustomerDetails.getMobileNumber());
				System.out.println("Customer status :"+ bankCustomerDetails.getStatus());
				System.out.println("----------------");
			}
		}
		System.out.println("Enter S.No To Select The Customer Details");
		BankCustomerDetails adminSelectedObject = allpendingdetailslist.get(scan.nextInt()-1);
		System.out.println(adminSelectedObject);
		System.out.println("Enter 1 to Accept \n 2 To Delete");
		switch(scan.nextInt())
		{
		case 1: acceptPendingDetails(adminSelectedObject);
		break;
		case 2: //bankCustomerDAO.deleteCustomerDetailsByUsingId(adminSelectedObject);
			deleteCustomerDetails(adminSelectedObject);
		break;
		default:
		break;
		}
	}
	@Override
	public void acceptPendingDetails(BankCustomerDetails bankCustomerDetails) {
		Random random=new Random();
		int accountNumber=random.nextInt(10000000);
		if(accountNumber<1000000) {
			//999999+1000000=1999999
			accountNumber+=1000000;
		}
		System.out.println(accountNumber);
		
		int pin=random.nextInt(10000);
		if(pin<10000) {
			pin+=10000;
		}
		System.out.println(pin);
		bankCustomerDetails.setAcountNumber(accountNumber);
		bankCustomerDetails.setPin(pin);
		bankCustomerDAO.updateAccountNumberAndPinNumberByUsingId(bankCustomerDetails);
	}
	@Override
	public void deleteCustomerDetails(BankCustomerDetails adminSelectedObject) {
		bankCustomerDAO.deleteCustomerDetailsByUsingId(adminSelectedObject);
	}
}

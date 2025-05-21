package com.bank;

import java.util.Scanner;

import com.bank.service.AdminService;
import com.bank.service.AdminServiceImpl;
import com.bank.service.BankCustomerService;
import com.bank.service.BankCustomerServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);
    	BankCustomerService bankCustomerService = new BankCustomerServiceImpl();
    	bankCustomerService.bankCustomerDetails();
    	AdminService adminService = new AdminServiceImpl();
    	adminService.adminLogin();
    	
    	//adminService.acceptPendingDetails();
    	while(true)
    	{
    		System.out.println("Enter \n1. For customer Registration \n2. For customer Login \n3. For admin Login");
    		switch(scan.nextInt())
    		{
    		case 1: 
    			System.out.println("Customer Registration");
    			bankCustomerService.bankCustomerDetails();
    			break;
    		case 2: 
    			System.out.println("Customer Login");
    			bankCustomerService.customerLogin();
    			break;
    		case 3:                    
    			System.out.println("Admin Login");
    			adminService.adminLogin();
    			break;
    		default: 
    			System.out.println("Invalid Option");
    			break;
    		}
    		System.out.println("Do you wish to continue \nYes or No");
    		if(scan.next().equalsIgnoreCase("Yes"))
    		{
    			
    		}
    		else
    		{
    			System.out.println("Thank You...!");
    			break;
    		}
    	}
    }
}

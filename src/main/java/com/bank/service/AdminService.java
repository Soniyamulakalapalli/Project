package com.bank.service;

import com.bank.model.BankCustomerDetails;

public interface AdminService {
	public void adminLogin();
	public void allUserDetails();
	public void allPendingDetails();
	 void acceptPendingDetails(BankCustomerDetails bankCustomerDetails);
	 void deleteCustomerDetails(BankCustomerDetails bankCustomerDetails);
}

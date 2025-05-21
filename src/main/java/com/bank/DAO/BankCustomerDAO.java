package com.bank.DAO;

import java.util.List;

import com.bank.model.BankCustomerDetails;

public interface BankCustomerDAO {
	public void insertCustomerDetails(BankCustomerDetails bankCustomerDetails);
	public List<BankCustomerDetails> getAllCustomerDetails();
	public void updateAccountNumberAndPinNumberByUsingId(BankCustomerDetails bankCustomerDetails);
	void deleteCustomerDetailsByUsingId(BankCustomerDetails bankCustomerDetails);
	boolean selectCustomerDetailsByUsingEmailidAndPassword(String emailId,int pin);
}

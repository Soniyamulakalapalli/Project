package com.bank.exception;

public class BankCustomerException extends RuntimeException
{
//	@Override
//	public String toString()
//	{
//		String usefullInfo = "Invalid data";
//		return usefullInfo;
//	}
	
	private String msg;
	public BankCustomerException()
	{
		
	}
	public BankCustomerException(String msg)
	{
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}

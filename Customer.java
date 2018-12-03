package com.user;

import java.util.ArrayList;

public class Customer {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password; 
	private String confirmation;
	private Address address = new Address();
	private Transaction transaction = new Transaction();
	//private ArrayList<Transaction> transaction = new ArrayList<Transaction>();
	
	private String initialDeposit;
	public Customer() {
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInitialDeposit() {
		return initialDeposit;
	}
	public void setInitialDeposit(String initialDeposit) {
		transaction.setInitialBalance(initialDeposit);
		this.initialDeposit = initialDeposit;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Transaction getTransaction() {
		return this.transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
	/**public ArrayList<Transaction> getTransaction() {
		return this.transaction;
	}
	public void setTransaction( ArrayList<Transaction> transaction) {
		this.transaction = transaction;
	}
	public String getInitialDeposit() {
		return initialDeposit;
	}
     **/
	
	
	
	
	public String toString() {
		return this.firstName +"*" + this.lastName +"*" + this.email +"*" +this.phoneNumber +"*" +this.password +"*" + this.address +"*"+ this.initialDeposit +"$" + this.transaction;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

}

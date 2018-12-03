package com.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private final String path="/Users/Luan/eclipse-workspace/BankingProject/src/com/user/accountList.txt";
	private ArrayList<Customer> customers= new ArrayList<Customer> ();

	public Bank() {
		
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public void addCustomer(Customer newCustomer) {
		this.customers.add(newCustomer);
	}
	public void saveToFile() {
		//Bank tempBank= new Bank();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.write(toString());
			bw.close();
		} catch (IOException e) {
			
		}
	}
	public void readFromFile() {
		customers= new ArrayList<Customer> (); //create new list of customers
		try {
			Scanner scanner = new Scanner(new File(path));
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] transactionLine= line.split("\\$"); //split personal information from transactions
				String[] personalInfo = transactionLine[0].split("\\*"); //split personal information
				//return this.firstName +"*" + this.lastName +"*" + this.email +"*" + this.password +"*" +this.Adress + "*"+ this.initialDeposit
				Customer customer = new Customer();   //set new customer to read information
				customer.setFirstName(personalInfo[0]);
				customer.setLastName(personalInfo[1]);
				customer.setEmail(personalInfo[2]);
				customer.setPhoneNumber(personalInfo[3]);
				customer.setPassword(personalInfo[4]);
				customer.getAddress().setStreet(personalInfo[5]);
				customer.getAddress().setCity(personalInfo[6]);
				customer.getAddress().setState(personalInfo[7]);
				customer.getAddress().setZipCode(personalInfo[8]);
				customer.setInitialDeposit(personalInfo[9]); //fix this
				for (int i=1; i<transactionLine.length; i++) {     //loop through series of transactions
					//-amount%balance%date%time
					String[] tranSpecific = transactionLine[i].split("%"); //split transaction to specific components
					char sign= tranSpecific[0].charAt(0);
					double amount= Double.parseDouble(tranSpecific[0].substring(1));
					double balance = Double.parseDouble(tranSpecific[1]);
					String currentDate = tranSpecific[2];
					String currentTime = tranSpecific[3];
					customer.getTransaction().addTransaction(sign, amount, balance, currentDate, currentTime); //re-add transaction histories to customer List
					customer.getTransaction().setBalance(balance);
				}
				customers.add(customer); //add customers to customer list
			}
		}catch (FileNotFoundException e) {
			
		}
	}
	public String toString() {
		String allAccounts = "";
		for (int i=0; i<customers.size(); i++) {
			if (i == (customers.size()-1)) {
				allAccounts+= customers.get(i); 
			}
			else {
				allAccounts+= customers.get(i) +"\n";
			}
			
		}
		return allAccounts;
	}
}

package com.user;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
	private double balance;
	private double depositAmount;
	private double withdrawalAmount;
	private char depositOrWithdraw;
	private DateAndTime currentDate = new DateAndTime(); 
	//private Bank bank= new Bank();
	//private String currentTime;
	//private String currentDate;
	private ArrayList<String> transactionAction = new ArrayList<>();
	
	
	public Transaction() {
	}
	public double getBalance() {
		return balance;
	}
	

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getDepositAmount() {
		return depositAmount;
	}
	
	public void setDepositAmount(double depositAmount) {
		//LocalDateTime now = LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:dda");
		//SimpleDateFormat dateFormatter = new SimpleDateFormat (("MM/dd/yyyy hh:mm:dda")); //certain format
		//String [] dateTrimmer = now.format(formatter).split(" ");
		String [] dateTrimmer = currentDate.getDateAndTime().split(" ");  //convert and separate date/out to strings for easier to manipulate
		this.balance += depositAmount;
		this.depositAmount = depositAmount;
		this.depositOrWithdraw = '+';
		addTransaction(depositOrWithdraw, depositAmount, balance, dateTrimmer[0], dateTrimmer[1]); // (- or +)amount, balance, date, time
		
		//saveToFile();  //save file
	}
	
	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	
	///Withdrawal
	public void setWithdrawalAmount(double withdrawalAmount) {
		if (withdrawalAmount>balance) {
			System.out.println("Insufficient amount, please try again");
			
		}
		else {
			//LocalDateTime now = LocalDateTime.now();
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:dda");
			//SimpleDateFormat dateFormatter = new SimpleDateFormat (("MM/dd/yyyy hh:mm:dda")); //certain format
			//String [] dateTrimmer = now.format(formatter).split(" ");
			String [] dateTrimmer = currentDate.getDateAndTime().split(" ");  //convert and separate date/out to strings for easier to manipulate
			this.withdrawalAmount = withdrawalAmount;
			this.depositOrWithdraw = '-';
			this.balance= this.balance - withdrawalAmount;
			addTransaction(depositOrWithdraw, withdrawalAmount, balance, dateTrimmer[0], dateTrimmer[1]); // (- or +)amount, balance, date, time
			//saveToFile();
		}	
	}
	
	public char getDepositOrWithdraw() {
		return depositOrWithdraw;
	}
	
	public void setDepositOrWithdraw(char depOrWith) {
		this.depositOrWithdraw = depOrWith;
	}
	
	public ArrayList<String> getTransactionAction() {
		return transactionAction;  //array of String
	}
	
	public void setTransactionAction(ArrayList<String> transactionDate) {
		this.transactionAction = transactionDate;
	}
	
	//set initial deposit
	public void setInitialBalance(String initialDeposit) {
		//LocalDateTime now = LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:dda");
		//SimpleDateFormat dateFormatter = new SimpleDateFormat (("MM/dd/yyyy hh:mm:dda")); //certain format
		//String [] dateTrimmer = now.format(formatter).split(" ");
		String [] dateTrimmer = currentDate.getDateAndTime().split(" ");  //convert and separate date/out to strings for easier to manipulate
		depositOrWithdraw = '+';
		balance = Double.parseDouble(initialDeposit);
		addTransaction(depositOrWithdraw,balance, balance, dateTrimmer[0], dateTrimmer[1]); // (- or +)amount, balance, date, time
		//saveToFile();
	}
	
	//Creating a String ArrayList of transactions
	public void addTransaction (char negativeOrPositive, double amount, double balance, String currentDate, String currentTime) {
		
		transactionAction.add(negativeOrPositive + "" + amount + "%" + balance + "%"+ currentDate+"%"+currentTime); //each variable is separate by %
	}
	
	//return all transactions  
	public String toString() {
		String allTransaction="";
		for (int i=0; i<transactionAction.size(); i++) {
			 allTransaction += transactionAction.get(i) + "$"; //each transaction action is separate by $
		}
		return allTransaction;
	}
	public DateAndTime getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(DateAndTime currentDate) {
		this.currentDate = currentDate;
	}
	
}

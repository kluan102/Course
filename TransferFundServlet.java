package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransferFund
 */
@WebServlet("/TransferFundServlet")
public class TransferFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferFundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double transferAmount = Double.parseDouble(request.getParameter("amount"));
		String designatedID = request.getParameter("email");
		HttpSession session = request.getSession(true);	
		
		Bank bank = (Bank)session.getAttribute("bank");
		bank.readFromFile();
		Customer sender = (Customer)session.getAttribute("customer");
		Customer receiver = new Customer();
		
		//verify the receiver
		for (int i=0; i < bank.getCustomers().size(); i++) {
			if (designatedID.equalsIgnoreCase(bank.getCustomers().get(i).getEmail())) {
				receiver = (Customer) bank.getCustomers().get(i);
				sender.getTransaction().setWithdrawalAmount(transferAmount);
				receiver.getTransaction().setDepositAmount(transferAmount);
				sender.setConfirmation("Sucessfully Send!!");
			} else {
				sender.setConfirmation("Failure to send fund, please try again");
			}
		}
		
		//send the sender to the bank for saving
		for (int i=0; i < bank.getCustomers().size(); i++) {
			 String senderEmail= sender.getEmail();
			 if (senderEmail.equalsIgnoreCase(bank.getCustomers().get(i).getEmail())) {
				 bank.getCustomers().get(i).getTransaction().setWithdrawalAmount(transferAmount);
			 }
		}
		
		session.setAttribute("customer", sender);
		
		session.setAttribute("bank", bank);
		bank.saveToFile();
		RequestDispatcher rs = request.getRequestDispatcher("main.jsp");
		rs.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

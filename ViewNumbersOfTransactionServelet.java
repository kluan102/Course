package com.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewNumbersOfTransactionServelet
 */
@WebServlet("/ViewNumbersOfTransactionServelet")
public class ViewNumbersOfTransactionServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNumbersOfTransactionServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	
		Customer customer = (Customer)session.getAttribute("customer");		
		ArrayList<String> transactionNumber =new ArrayList<String>();
		
		int numOfTransaction = Integer.parseInt(request.getParameter("viewNumber"));
		int maxTransaction = customer.getTransaction().getTransactionAction().size() -1;
		
		for (int i=maxTransaction; i>maxTransaction - numOfTransaction; i--) {
			String singleTransaction = customer.getTransaction().getTransactionAction().get(i);
			//-amount%balance%date%time   --> return as an array of Strings
			String[] tranSpecific = singleTransaction.split("%");
			//Set to this format: Date Time transaction Balance 
			transactionNumber.add(tranSpecific[2] + " " +tranSpecific[3] +" " +tranSpecific[0] + " " +tranSpecific[1]); 
		}
		
		session.setAttribute("transactionNumber", transactionNumber);
		RequestDispatcher rs = request.getRequestDispatcher("ViewNumbersOfTransactions.jsp");
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

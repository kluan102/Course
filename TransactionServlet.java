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
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	
		Customer customer = (Customer)session.getAttribute("customer");		
		ArrayList<String> transaction =new ArrayList<String>();
		
		int maxTransaction = customer.getTransaction().getTransactionAction().size() -1;
		
		for (int i=maxTransaction; i>-1; i--) {
			String singleTransaction = customer.getTransaction().getTransactionAction().get(i);
			//-amount%balance%date%time   --> return as an array of Strings
			String[] tranSpecific = singleTransaction.split("%");
			//Set to this format: Date Time transaction Balance 
			transaction.add(tranSpecific[2] + " " +tranSpecific[3] +" " +tranSpecific[0] + " " +tranSpecific[1]); 
		}
		
		session.setAttribute("transaction", transaction);
		RequestDispatcher rs = request.getRequestDispatcher("transaction.jsp");
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

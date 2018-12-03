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
 * Servlet implementation class DeleteAccountServlet
 */
@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);	
		Bank bank = (Bank)session.getAttribute("bank");
		bank.readFromFile();
		Customer customer = (Customer)session.getAttribute("customer");	
		String email = customer.getEmail();
		
		for (int i=0; i < bank.getCustomers().size(); i++) {
			if (email.equalsIgnoreCase(bank.getCustomers().get(i).getEmail())) {
				bank.getCustomers().remove(i);
			}
		}
		bank.saveToFile();
		
		bank = new Bank();
		customer = new Customer();
		
		session.setAttribute("customer", customer);
		session.setAttribute("bank", bank);
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
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

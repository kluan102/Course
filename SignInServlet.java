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
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personalID = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);	
		Bank bank = new Bank();
		Customer customer = new Customer();
		bank.readFromFile();
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		
		for (int i=0; i< bank.getCustomers().size(); i++) {
			if (personalID.equalsIgnoreCase(bank.getCustomers().get(i).getEmail())){
				if (password.equals(bank.getCustomers().get(i).getPassword())) {
					customer = bank.getCustomers().get(i);

					session.setAttribute("customer", customer);
					session.setAttribute("bank",bank);
					rs = request.getRequestDispatcher("main.jsp");
				}
			}
		}
		
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

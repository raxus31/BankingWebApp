package com.raxus.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting username and password from form
		String accountNumber=request.getParameter("accountNumber");
		String password=request.getParameter("password");
		
		
		//registering driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.getLocalizedMessage());
			this.dispatchRequest(request, response,"errorPage.jsp",true);
			
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingapp","root","pj@9632276541");
			String query="select password from bankusers where accountNumber='"+accountNumber+"'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					request.setAttribute("accountNumber",accountNumber);
					request.setAttribute("profileImage",accountNumber+"profile.jpg");
					HttpSession session=(HttpSession) request.getSession();
					session.setAttribute("accountNumber",accountNumber);
					this.dispatchRequest(request, response,"Home.jsp",true);
				}else {
				    request.setAttribute("error","INVALID PASSWORD");
					this.dispatchRequest(request, response,"errorPage.jsp",true);
				}
			}else {
				request.setAttribute("error","INVALID LOGIN CREDENTIALS");
				this.dispatchRequest(request, response,"errorPage.jsp",true);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error",e.getLocalizedMessage());
			this.dispatchRequest(request, response,"errorPage.jsp",true);
		}
		
		
	}
	
	public void dispatchRequest(HttpServletRequest request,HttpServletResponse response,String page,boolean servletOrNot) {
		RequestDispatcher dispatcher=request.getRequestDispatcher(page);
		try {
			if(servletOrNot) {
				dispatcher.forward(request,response);
			}else {
				dispatcher.include(request, response);
			}
		}catch(IOException io){
			io.printStackTrace();
		}catch(ServletException ser) {
			ser.printStackTrace();
		}
	}

}

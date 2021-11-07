package com.raxus.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TransactionServlet
 */
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
		HttpSession session= request.getSession();
		String accountNumber=(String)session.getAttribute("accountNumber");
		String tablename=accountNumber+"transactions";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingapp","root","pj@9632276541");
			Statement stmt=con.createStatement();
			ArrayList<Transactions> list=new ArrayList<Transactions>();
			ResultSet rs=stmt.executeQuery("select * from "+tablename);
			while(rs.next()) {
				Transactions ts=new Transactions();
				ts.setSrNo(rs.getInt(1));
				ts.setFrom(rs.getString(2));
				ts.setTo(rs.getString(3));
				ts.setAmount(rs.getInt(4));
				ts.setDateOfTransaction(rs.getString(5));
				list.add(ts);
			}
			
			request.setAttribute("transactions",list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("transaction.jsp");
			dispatcher.forward(request,response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

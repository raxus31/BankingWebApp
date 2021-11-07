package com.raxus.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@MultipartConfig
public class RegisterServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String accountNumber=req.getParameter("accountNumber");
			String cifNumber=req.getParameter("cifNumber");
			String ifscCode=req.getParameter("ifscCode");
			String micrNumber=req.getParameter("micrCode");
			String adharNumber=req.getParameter("adharNumber");
			String address=req.getParameter("address");
			String dob=req.getParameter("dob");
			Part photoAdhar=req.getPart("photoAdhar");
			String path="C:\\Javaee\\project1\\src\\main\\webapp\\images\\";
			InputStream adharStream=photoAdhar.getInputStream();
			byte[] adharByte=adharStream.readAllBytes();
			String adharLoc=path+accountNumber+"adhar.jpg";
			FileOutputStream adharOut=new FileOutputStream(adharLoc);
			adharOut.write(adharByte);
			adharOut.close();
			Part profilePhoto=req.getPart("profilePhoto");
			String profileLoc=path+accountNumber+"profile.jpg";
			new FileOutputStream(profileLoc).write(profilePhoto.getInputStream().readAllBytes());
			String password=req.getParameter("password");
			String repassword=req.getParameter("repassword");
			
			if(!password.equals(repassword)) {
				req.setAttribute("error","passswords doesnt match");
				this.dispatchRequest(req, resp, "errorPage.jsp",true);
			}
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				req.setAttribute("error",e.getLocalizedMessage());
				this.dispatchRequest(req, resp,"errorPage.jsp",true);
			}
			
			
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingapp","root","pj@9632276541");
				Statement stmt=con.createStatement();
				stmt.execute("create table account"+accountNumber+"(cifNumber varchar(20),ifscNumber varchar(20),micrCode varchar(20),adharNumber varchar(20),address varchar(100),dob varchar(20),profileloc varchar(200),adharloc varchar(200),amount int(255))");
				String query=String.format("insert into %s values('%s','%s','%s','%s','%s','%s','%s','%s',%s)","account"+accountNumber,cifNumber,ifscCode,micrNumber,adharNumber,address,dob,profileLoc,adharLoc,"0");
				stmt.executeUpdate(query);
				stmt.executeUpdate("insert into bankusers values('"+accountNumber+"','"+password+"')");
				stmt.execute("create table "+accountNumber+"transactions(srNo int primary key auto_increment,faccount varchar(20),taccount varchar(20),amount int(255),doftransaction varchar(20))");
				req.setAttribute("accountNumber",accountNumber);
				req.setAttribute("profileImage",accountNumber+"profile.jpg");
				this.dispatchRequest(req, resp,"Home.jsp",true);
			} catch (SQLException e) {
				req.setAttribute("error",e.getLocalizedMessage());
				this.dispatchRequest(req, resp,"errorPage.jsp",true);
				
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

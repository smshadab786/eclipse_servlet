package com.abc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.*;


public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName=request.getParameter("fullName");
		String emailId=request.getParameter("emailId");
		String role=request.getParameter("role");
		System.out.println(fullName+" "+emailId+" "+role);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","Shadab@mysql");
			String sql="INSERT INTO users(Fullname,Username,Role) VALUES(?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, fullName);
			stmt.setString(2, emailId);
			stmt.setString(3, role);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.print("<center><h2>user added!!</h2>");
			pw.println("<a href='index.html'>Click here to go back</a>");
			pw.println("</center>");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}

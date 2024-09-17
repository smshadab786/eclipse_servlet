package com.abc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;


public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateUser() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName=request.getParameter("fullName");
		String emailId=request.getParameter("emailId");
		String role=request.getParameter("role");
		String userId=request.getParameter("userId");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","Shadab@mysql");
			String sql="UPDATE users SET Fullname=?,Username=?,Role=? WHERE userId=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, fullName);
			stmt.setString(2, emailId);
			stmt.setString(3, role);
			stmt.setString(4, userId);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
			response.sendRedirect("GetUsers");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}

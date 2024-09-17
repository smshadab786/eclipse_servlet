package com.abc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;


public class DeleteUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteUsers() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","Shadab@mysql");
			String sql="DELETE FROM users WHERE userId=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, userId);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.print("<center><h2>user deleted!!</h2>");
			pw.println("<a href='index.html'>Click here to go back</a>");
			pw.println("</center>");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

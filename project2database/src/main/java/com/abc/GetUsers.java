package com.abc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.*;

public class GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetUsers() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
//		pw.println("Shadab");
		response.setContentType("text/html");
//		pw.println("head");
		pw.println("<link rel='stylesheet' href='style.css'>");
		pw.println("<link\r\n"
				+ "    href=\"https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css\"\r\n"
				+ "    rel=\"stylesheet\"\r\n"
				+ "/>");
		pw.println("<body>");
		pw.println("<div class='header'>");
		pw.println("<a href='index.html'>back</a>");
		pw.println("</div>");
		pw.println("<table>");
		pw.println("<head>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th>#</th>");
		pw.println("<th>Fullname</th>");
		pw.println("<th>Username</th>");
		pw.println("<th>Role</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","Shadab@mysql");
			String sql="SELECT * FROM users";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getString(4)+"</td>");
//				String query="?id="+rs.getInt(1)+"&fn="+rs.getString(2)+"&user="+rs.getString(3)+"&role="+rs.getString(4);
				pw.println("<td><a href='update.html?id="+rs.getInt(1)+
						"&fn="+rs.getString(2)+
						"&user="+rs.getString(3)+
						"&role="+rs.getString(4)+
						"'><i class='ri-pencil-fill'></i></a> <a href='DeleteUsers?userId="+rs.getInt(1)+"'><i class='ri-delete-bin-fill'></i></a></td>");
				pw.println("</tr>");
			}
			stmt.close();
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		pw.println("</tbody>");
		pw.println("</table>");
		pw.println("</body>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

package com.sekh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/happy")
public class First extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String s1=request.getParameter("fname");
		String s2=request.getParameter("lname");
		String s3=request.getParameter("address");
		String s4=request.getParameter("gmail");
		String s5=request.getParameter("mobile");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root", "root");
			String sql="insert into contact values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.setString(5, s5);
			if(!s1.isEmpty()){
			ps.executeUpdate();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}

}

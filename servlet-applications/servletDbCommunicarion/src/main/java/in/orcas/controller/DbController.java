package in.orcas.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	static {
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Driverloaded successfully");
	}
	
	public void init() {
		String url = getInitParameter("url");
		String userName = getInitParameter("userName");
		String password = getInitParameter("password");
		
		System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
		try {
			 connection = DriverManager.getConnection(url,userName,password);
			if(connection!=null) {
				System.out.println("connection successfull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Request type is :: " + request.getMethod() +"</h1>");
		try {
			if(connection!=null) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select sid,sname,sage,saddress from student");
			while(resultSet.next()) {
				
			}
			}
			out.close();
			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}

package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/TestServlet", 
				"/test"
		}, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:Oracle:thin:@localhost:1521:orcl"), 
				@WebInitParam(name = "userName", value = "practice"), 
				@WebInitParam(name = "password", value = "1234")
		})
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private PrintWriter out = null;
	

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void init() {
		String url = getInitParameter("url");
		String userName  = getInitParameter("userName");
		String password = getInitParameter("password");
		try {
			connection = DriverManager.getConnection(url,userName,password);
			System.out.println("connection established succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			preparedStatement = connection.prepareStatement("insert into reg  (sname , sage , saddress) values (?,?,?)");
			String name = request.getParameter("username");
			String age = request.getParameter("userAge");
			String address = request.getParameter("userAdd");
			
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2,Integer.parseInt(age));
			preparedStatement.setString(3,address);
			int rowsAffected = preparedStatement.executeUpdate();
			out = response.getWriter();
			if(rowsAffected==1) {
				out.println("<h1 style='color:green; text-align: center;'>REGISTRATION SUCCESFULL</h1>");
			}
			else {
				out.println("<h1 style='color:red; text-align: center;'>REGISTRATION FAILED</h1>");
				out.println("<a href='./reg.html'/>|REGISTRATION|</a>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void destory() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}

}

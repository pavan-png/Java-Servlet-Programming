package in.orcas.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException{
    	System.out.println("implementation classes of tomcat server is : ");
    	ServletContext context = getServletContext();
    	ServletConfig config = getServletConfig();
    	System.out.println("implementation class of servlet context "+context.getClass().getName());
    	System.out.println("implementation class of servlet config : "+config.getClass().getName());
    	System.out.println("implementation class of HttpServletRequest object : "+request.getClass().getName());
    	System.out.println("implementation class of HttpServletResponse object : "+request.getClass().getName());
    	
    }

}

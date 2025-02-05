package in.orcas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.orcas.service.IStudentService;
import in.orcas.servicefactory.StudentServiceFactory;


@WebServlet("/ controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		IStudentService std = StudentServiceFactory.getStudentService();
		System.out.println("Request URI :: "+request.getRequestURI());
		System.out.println("Request path Info :: " +request.getPathInfo());
		if(request.getRequestURI()=="addform") {
			
		}
	}

}

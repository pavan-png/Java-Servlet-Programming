import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/test")
public class NinthServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response){
		doProcess(request,response);
	}

	@Override 
	public  void doPost ( HttpServletRequest request , HttpServletResponse response){
		doProcess(request,response);
	}

	public void doProcess(HttpServletRequest request , HttpServletResponse response){
		System.out.println("request method of type : "+ request.getMethod());
		String username = request.getParameter("username");
		System.out.println("thr username is "+username);
	}


}
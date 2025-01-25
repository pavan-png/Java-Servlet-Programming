import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/test")
public class SeventhServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response){
		System.out.println("request method of type : GET");
		String username = request.getParameter("username");
		System.out.println("thr username is "+username);
	}

	@Override 
	public  void doPost ( HttpServletRequest request , HttpServletResponse response){
		System.out.println("Request method of type : POST");
		String username = request.getParameter("username");
		System.out.println("thr username is "+username);
	}


}
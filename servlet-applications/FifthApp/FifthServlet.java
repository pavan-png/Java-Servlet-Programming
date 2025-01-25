import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/test")
public class FifthServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response){
		System.out.println("request method of type : GET");
	}

	@Override 
	public  void doPost ( HttpServletRequest request , HttpServletResponse response){
		System.out.println("Request method of type : POST");
	}


}
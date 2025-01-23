import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/test")
public class FourthServlet extends GenericServlet{
	
	public void service(ServletRequest req , ServletResponse res)throws ServletException,IOException{
		PrintWriter out  = res.getWriter();
		out.println("<h1 style = 'color : blue';> writing servlet using generic servlet </h1>");
		out.close();
	}

}
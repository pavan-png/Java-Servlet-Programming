import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/test",loadOnStartup=10)
public class ThirdServlet implements Servlet{
	
	static {
		System.out.println(" ThirdServelt class file is loaded " );
	}	
	
	
	public ThirdServlet(){
		System.out.println(" Third Servlet Object is  instantiated " );
	}

	// for servlet initialization servlet class this method
	public void init(ServletConfig config) throws ServletException{
		System.out.println("servlet initialized ");
	}
	public ServletConfig getServletConfig(){
		return null;
	}
	
	// request processing logic 
	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		System.out.println("servlet request processed");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 
		out.println("<html><head><title>output</title></head>");
		out.println("<body>");
		out.println("<marquee> Annotation servlet welcome to java.... </marquee>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	public String getServletInfo(){
		return null;
	}
	
	//servlet de-instantiation logic
	public void destroy(){
		System.out.println("servlet de-instantiated");
	}


}
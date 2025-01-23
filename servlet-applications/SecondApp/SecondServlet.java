import java.io.*;
import javax.servlet.*;
public class SecondServlet implements Servlet{
	
	static {
		System.out.println(" Second Servelt class file is loaded " );
	}	
	
	
	public SecondServlet(){
		System.out.println(" Second Servlet Object is  instantiated " );
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
		out.println("<marquee> welcome to java.... </marquee>");
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
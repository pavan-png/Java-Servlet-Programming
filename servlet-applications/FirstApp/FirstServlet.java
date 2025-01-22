import java.io.*;
import javax.servlet.*;
public class FirstServlet implements Servlet{
	
	static {
		System.out.println(" FirstServelt class file is loaded " );
	}	
	
	
	public FirstServlet(){
		System.out.println(" First Servlet Object is  instantiated " );
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
	}
	public String getServletInfo(){
		return null;
	}
	
	//servlet de-instantiation logic
	public void destroy(){
		System.out.println("servlet de-instantiated");
	}


}
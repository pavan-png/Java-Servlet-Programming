package in.orcas.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/test")
public class LogFilter extends HttpFilter implements Filter {
  
	private FilterConfig config;
    static {
    	System.out.println("filter loaded");
    }
	
	public LogFilter() {
        System.out.println("filter instantiated");
        
    }

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("filter intialized");
		this.config = config;
		
	}
	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		ServletContext context= config.getServletContext();
		out.println("<h1>This line is added by the Log filter before processing the request</h1>");
		HttpServletRequest req1 = (HttpServletRequest) request;
		context.log("A request is coming from "+req1.getRemoteHost() +" for url :: "+req1.getRequestURL() +" at date " + new java.util.Date());
		chain.doFilter(request, response);
		out.println("<h1>This line is added by Log filter after processing the request .... </h1>");
	}
	

	public void destroy() {
		config = null;
		System.out.println("lof filter de-instantiated");
	}


	

}

package in.orcas.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/test")
public class DemoFilter extends HttpFilter implements Filter {
    
	static {
		System.out.println("DemoFilter loaded");
	}
   
    public DemoFilter() {
       System.out.println("DemoFilter instantiated");
    }

    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DemoFilter intialized");
	}
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by Demo filter before processing the request .... </h1>");
		chain.doFilter(request, response);
		out.println("<h1>This line is added by Demo filter after processing the request .... </h1>");
	}

	
	public void destroy() {
		System.out.println("DemoFilter de-instantiated");
		
	}

}

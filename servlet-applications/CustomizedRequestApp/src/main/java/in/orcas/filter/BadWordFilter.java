package in.orcas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import in.orcas.customization.CustomizedRequest;


@WebFilter("/test")
public class BadWordFilter extends HttpFilter implements Filter {
       
  
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		CustomizedRequest req1 = new CustomizedRequest((HttpServletRequest) request);
		chain.doFilter(req1, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

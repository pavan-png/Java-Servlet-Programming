package in.orcas.customization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper {

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) { 
		
		String word1 = super.getParameter("word");
		/* here call is made to the parent class getParameter() with parameter "word" 
		 * we are not actually using the name argument. 
		 */
		if(word1.equalsIgnoreCase("hello")||word1.equalsIgnoreCase("hi")) {
			return "pani pata em led entra"; 
		}
		else {
			return word1;
		}
		
	}
	
	
	

}

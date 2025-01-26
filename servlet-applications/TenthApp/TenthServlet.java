import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/test")
public class TenthServlet extends HttpServlet{
	

	@Override 
	public  void doPost ( HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		String userAddress = request.getParameter("useraddress");
		String[] courses = request.getParameterValues("course");

		PrintWriter out = response.getWriter();
		out. println("<html><head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Student Registration details</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><td>"+userName+"</td></tr>");
		out.println("<tr><th>EMAIL</th><td>"+userEmail+"</td></tr>");
		out.println("<tr><th>ADDR</th><td>"+userAddress+"</td></tr>");
		out.println("<tr><th>COURSE</th>");
		String data = "";
		for(String course : courses)
			data = data + course;
		out.println("<td>"+data+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}




}
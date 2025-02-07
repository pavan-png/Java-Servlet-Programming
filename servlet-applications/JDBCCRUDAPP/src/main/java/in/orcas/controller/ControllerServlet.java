package in.orcas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.orcas.dto.Student;
import in.orcas.service.IStudentService;
import in.orcas.servicefactory.StudentServiceFactory;


@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		IStudentService stdService = StudentServiceFactory.getStudentService();
		System.out.println("Request URI :: "+request.getRequestURI());
		System.out.println("Request path Info :: " +request.getPathInfo());
		if(request.getRequestURI().endsWith("addform")){
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");
			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddress);
			String status = " ";
			PrintWriter out = null;
			try {
				 out = response.getWriter();
				status = stdService.addStudent(student);
			} catch (IOException e) {
				e.printStackTrace();
			}
			 catch (SQLException e) {
				e.printStackTrace();
			} 
			if(status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
			}
			else {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
			}
			out.close(); 
		}
		if(request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			try {
				Student student = stdService.searchStudent(Integer.parseInt(sid));
				PrintWriter out = response.getWriter();
				if(student!=null) {
					out.println("<body>");
					out.println("<center>");
					out.println("<table border='1'>");
					out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
					out.println("<tr><th>NAME</th><td>" + student.getSname() + "</td></tr>");
					out.println("<tr><th>AGE</th><td>" + student.getSage() + "</td></tr>");
					out.println("<tr><th>ADDRESS</th><td>" + student.getSaddress() + "</td></tr>");
					out.println("</table>");
					out.println("</center>");
					out.println("</body>");	
				} else {
					out.println("<h1 style='color:red; text-align: center; '>RECORD NOT AVAILABLE FOR THE GIVEN ID " + sid + "</h1>");
				} 
				out.close();
				}catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		
		if(request.getRequestURI().endsWith("deleteform")) {
			
			String sid = request.getParameter("sid");
			try {
				String status = stdService.deleteStudent(Integer.parseInt(sid));
				PrintWriter out = response.getWriter();
				if(status.equals("success")) {
					out.println("<body>");
					out.println("<h1 style='color: green; text-align: center; '>RECORD DELETED SUCCESFULLY</h1>");
					out.println("</body>");
				}else if( status.equals("failure")) {
					out.println("<body>");
					out.println("<h1 style='color:red; text-align: center; '>RECORD DELETION FAILED</h1>");
					out.println("</body>");
				}else {
					out.println("<body>");
					out.println("<h1 style='color:green; text-align: center; '>RECORD NOT FOUND FOR DELETION</h1>");
					out.println("</body>");
				}
				out.close();
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(request.getRequestURI().endsWith("editform")) {
			String sid = request.getParameter("sid");
			try {
				Student student = stdService.searchStudent(Integer.parseInt(sid));
				PrintWriter out = response.getWriter();
				if(student!=null) {
					out.println("<body>");
					out.println("<center>");
					out.println("<form method='post' action='./controller/updateRecord'>");
					out.println("<table>");
					out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
					out.println("<input type='hidden' name='sid' value='"+student.getSid()+"'/>");
					out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getSname()+ "'/></td></tr>");
					out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + student.getSage() + "'/></td></tr>");
					out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='" + student.getSaddress()+ "'/></td></tr>");
					out.println("<tr><td><td><td><input type='submit' value='update'/></td></tr>");
					out.println("</table>");
					out.println("</form>");
					out.println("</center>");
					out.println("</body>");
				}
				else {
					// display not found message
					out.println("<body>");
					out.println("<h1 style='color: red; text-align: center; '>Record not avaialable for the give id :: " + sid + "</h1>");
					out.println("</body>");
				}
				out.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
			if(request.getRequestURI().endsWith("updateRecord")) {
				String sid = request.getParameter("sid");
				String sname = request.getParameter("sname");
				String sage = request.getParameter("sage");
				String saddr = request.getParameter("saddr");
				
				Student student = new Student();
				student.setSid(Integer.parseInt(sid));
				student.setSname(sname);
				student.setSage(Integer.parseInt(sage));
				student.setSaddress(saddr);
				PrintWriter out = null;
			try {
				String status = stdService.updateStudent(student);
				out = response.getWriter();
				if(status.equals("success")) {
					out.println("<h1 style='color:green; text-align:center; '>STUDENT RECORD UPDATED SUCCESSFULLY </h1>");
				} else {
					out.println("<h1 style='color:green; text-align: center;'>STUDENT RECORD UPDATION FAILED </h1>");

				}
				out.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			}
		}
		
	}


 
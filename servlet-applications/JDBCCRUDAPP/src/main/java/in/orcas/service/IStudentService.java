package in.orcas.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import in.orcas.dto.Student;

public interface IStudentService {
	public String addStudent(Integer sid, String sname, Integer sage, String saddress) throws FileNotFoundException, SQLException, IOException;
	
	public Student searchStudent(Integer sid) throws FileNotFoundException, SQLException, IOException;
	
	public String updateStudent(Student student) throws FileNotFoundException, SQLException, IOException;
	
	public String deleteStudent(Integer sid) throws FileNotFoundException, IOException, SQLException;
}

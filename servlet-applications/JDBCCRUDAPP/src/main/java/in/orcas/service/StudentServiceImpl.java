package in.orcas.service;

import java.io.FileNotFoundException;



import java.io.IOException;
import java.sql.SQLException;

import in.orcas.daofactory.StudentDaoFactory;
import in.orcas.dto.Student;
import in.orcas.dao.IStudentDao;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	@Override
	public String addStudent(Integer sid, String sname, Integer sage, String saddress) throws FileNotFoundException, SQLException, IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sid, sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) throws FileNotFoundException, SQLException, IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) throws FileNotFoundException, SQLException, IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) throws FileNotFoundException, IOException, SQLException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}

}

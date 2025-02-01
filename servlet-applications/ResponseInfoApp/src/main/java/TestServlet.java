
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		
		File f = new File("C:\\Users\\Administrator\\servlets\\servlet-applications\\ResponseInfoApp\\src\\main\\webapp\\cozy-home-interior-anime-style.jpg");
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[(int) f.length()];
		fis.read(b);
		
		ServletOutputStream stream = response.getOutputStream();
		stream.write(b);
		stream.flush();
		stream.close();
		fis.close();
	}

}

package kh.test.jdbckh.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentGetController
 */
@WebServlet("/student/get")
public class StudentGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGetController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전달받은 parameter 읽어내기
		String studentNo = request.getParameter("sno");
		System.out.println(studentNo);
		// 2. 전달받은 데이터를 활용해 DB학생 상세 정보 가져오기
		StudentDao dao = new StudentDao();
		// vo에 실리게된다.
		StudentVo vo = dao.selectOneStudent(studentNo);
		// 3.DB로부터 전달받은 데이터를 JSP에 전달함
		request.setAttribute("svo", vo); //" " 이름(아무거나 정함), 값
		// 4. JSP 파일 forward로 열기
		request.getRequestDispatcher("/WEB-INF/veiw/student/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}

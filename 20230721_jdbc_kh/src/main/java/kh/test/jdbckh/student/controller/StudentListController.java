package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;



/**
 * Servlet implementation class StudentListController
 */
//"student list"이걸 웹페이지 거서 다시 실행 시켜야함(f5)
@WebServlet({"/student/list" })
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListController() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/student/list doGot() 진입");
		// TODO DB 연결
		StudentDao dao = new StudentDao();
		//dao 부분이랑 StudentDao랑 연결됨
		List<StudentVo> result = dao.selectListStudent();
		request.setAttribute("studentList", result);
		request.setAttribute("aaa", "그냥속성값테스트해봄");
		request.setAttribute("bbb", "그냥속성값테스트해봄");
		request.setAttribute("ccc", 333);
		request.getRequestDispatcher("/WEB-INF/veiw/student/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
	

}

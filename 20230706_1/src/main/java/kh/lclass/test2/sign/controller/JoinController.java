package kh.lclass.test2.sign.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/sign/join/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//성공했다면 reponse Red--로 연결해줘 그리고 get추가하고 index로 연결해줘 or 로그인
		System.out.println("/join POST"); //join에 post 진입했다.
		// 1. 데이터 전달 받음( 그걸 꺼내서 읽어야 하는데)
		String id = request.getParameter("mid");
		String pass = request.getParameter("mpass");
		String nicname = request.getParameter("mnicname");
		// 위 전달 받은 데이터를 DB 제장
		// 2. DB 저장
		
		// 성공시 로그인 페이지로 이동 (jsp로 이동이 아님 url로 이동임)
		// 3. url 이동(밑에 url 이동 시키는 명령어)
		response.sendRedirect(request.getContextPath()+"/login");
		
		// 실패
		// 경고창 후 /join으로 이동
	}

}

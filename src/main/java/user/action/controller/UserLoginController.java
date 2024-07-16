package user.action.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.action.dao.UserLoginDAO;
import user.action.vo.UserVO;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/userfilter/action/login")
public class UserLoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserVO> userList = new ArrayList<UserVO>();
		UserLoginDAO loginDAO = new UserLoginDAO();

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		boolean idCheck = false;
		boolean pwdCheck = false;

		userList = loginDAO.login();

		for (UserVO user : userList) {

			if (user.getUser_id().equals(user_id)) {
				idCheck = true;
				if (BCrypt.checkpw(password, user.getPassword())) {
					pwdCheck = true;
				}
				break;
			}

		}

		String str = user_id;
		HttpSession session = request.getSession();
		String loginErroMsg = null;

		// 로그인 성공
		if (idCheck == true && pwdCheck == true) {
			session.setAttribute("loginInfo", str);
			RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);

		} else if (idCheck == true) {
			// 아이디가 맞는데 비밀번호가 틀리면
			if (pwdCheck == false) {
				loginErroMsg = "비밀번호를 확인해 주시기 바랍니다";
				RequestDispatcher dispatch = request.getRequestDispatcher("/users/loginFail.jsp");
				request.setAttribute("loginErrorMsg", loginErroMsg);
				dispatch.forward(request, response);

			}
		} else if (idCheck == false) {
			System.out.println("아이디가 존재하지 않습니다.");
			loginErroMsg = "아이디가 존재하지 않습니다.";
			RequestDispatcher dispatch = request.getRequestDispatcher("/users/loginFail.jsp");
			request.setAttribute("loginErrorMsg", loginErroMsg);
			dispatch.forward(request, response);
		}
	}
}

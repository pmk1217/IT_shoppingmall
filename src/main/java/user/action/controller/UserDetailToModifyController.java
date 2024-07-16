package user.action.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.action.dao.UserDetailDAO;
import user.action.vo.UserVO;


@WebServlet("/user/action/detailToModify")
public class UserDetailToModifyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO user = new UserVO();
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("loginInfo");
		
		System.out.println(user_id);
		
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		
		user = userDetailDAO.userdetail(user_id);
		

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/users/modify.jsp");
		dispatcher.forward(request, response);
		
	}

}

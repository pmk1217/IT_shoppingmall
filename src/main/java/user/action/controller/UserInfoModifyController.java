package user.action.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.action.dao.UserInfoModifyDAO;
import user.action.vo.UserVO;

@WebServlet("/user/action/infoModify")
public class UserInfoModifyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserVO user = new UserVO();
		
		user.setUser_id(request.getParameter("user_id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setBirthday(request.getParameter("birthday"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setZipcode(request.getParameter("zipcode"));

		UserInfoModifyDAO userInfoModify = new UserInfoModifyDAO();

		userInfoModify.userModify(user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}

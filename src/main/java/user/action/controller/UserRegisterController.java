package user.action.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.action.dao.UserRegisterDAO;
import user.action.vo.UserVO;

@WebServlet("/userfilter/action/register")
public class UserRegisterController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");

		UserVO user = new UserVO();

		user.setUser_id(user_id);
		user.setPassword(password);
		user.setName(name);
		user.setBirthday(birthday);
		user.setEmail(email);
		user.setAddress(address);
		user.setZipcode(zipcode);

		UserRegisterDAO register = new UserRegisterDAO();
		register.addUser(user);
		
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/users/login.jsp");
		dispatcher.forward(request, response);

	}

}

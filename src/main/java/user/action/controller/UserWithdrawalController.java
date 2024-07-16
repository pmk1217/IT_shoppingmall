package user.action.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.action.dao.UserWithdrawalDAO;


@WebServlet("/user/action/withdrawal")
public class UserWithdrawalController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		
		UserWithdrawalDAO userWithdrawal = new UserWithdrawalDAO();
		userWithdrawal.userDelete(user_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("회원정보 삭제시 jsp => 세션만료, 초기화면으로이동");
		dispatcher.forward(request, response);
		
	}

}

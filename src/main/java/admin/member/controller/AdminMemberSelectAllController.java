package admin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.member.dao.AdminMemberSelectAllDAO;
import user.action.vo.UserVO;

@WebServlet("/admin/member/selectAll")
public class AdminMemberSelectAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/* 유저 모델 */
	AdminMemberSelectAllDAO memberSelectAll = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminMemberSelectAllDAO memberSelectAll = new AdminMemberSelectAllDAO();
		
		List<UserVO> userList  = memberSelectAll.userSelectAll();
		
		request.setAttribute("userList", userList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admins/adminUserList.jsp");
		rd.forward(request, response);
	}

}


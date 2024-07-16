package user.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.order.dao.UserOrderDeleteDAO;

@WebServlet("/user/order/delete")
public class UserOrderDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String o_userID = (String)session.getAttribute("loginInfo");	//주문자 아이디
		String order_id = request.getParameter("order_id");	//상품 주문번호
		
		UserOrderDeleteDAO orderDelete = new UserOrderDeleteDAO();
		
		orderDelete.delete(o_userID, order_id);
		response.sendRedirect(request.getContextPath()+ "/user/order/selectAll");
		
	}

}

package user.cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.cart.dao.UserCartModifyDAO;

@WebServlet("/user/cart/modify")
public class UserCartModifyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int cart_id = Integer.parseInt(request.getParameter("cart_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		System.out.println("UserCartModifyController 실행중");
		System.out.println("가져온 modify 파라미터 값 : " + cart_id + ", " + quantity + "개" );
		
		UserCartModifyDAO userCartModifyDAO = new UserCartModifyDAO();
		
		userCartModifyDAO.modify(cart_id, quantity);
		
		System.out.println("수정 직전");

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginInfo");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/cart/selectAll?userId="+userId);
		dispatcher.forward(request, response);
	}

}

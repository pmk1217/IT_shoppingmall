package admin.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.order.dao.AdminOrderModifyDAO;

@WebServlet("/admin/order/modify")
public class AdminOrderModifyController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String orderProcess = request.getParameter("orderProcess");
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		
		AdminOrderModifyDAO OrderModifyDAO = new AdminOrderModifyDAO();		
		
		OrderModifyDAO.OrderModify(orderProcess, order_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/order/selectAll");
		rd.forward(request, response);	
	}

}
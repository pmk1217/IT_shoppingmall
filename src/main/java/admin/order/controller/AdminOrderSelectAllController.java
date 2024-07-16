package admin.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.order.dao.AdminOrderSelectAllDAO;
import user.order.vo.UserOrderVO;

@WebServlet("/admin/order/selectAll")
public class AdminOrderSelectAllController extends HttpServlet {

    public AdminOrderSelectAllController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
				
		AdminOrderSelectAllDAO OrderAllDAO = new AdminOrderSelectAllDAO();
		List<UserOrderVO> AdminOrderList = OrderAllDAO.AdminOrderAllDAO();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("OrderSelectAll 서블릿 실행 중 : " + AdminOrderList.size());
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		System.out.println(AdminOrderList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admins/adminOrderList.jsp");
		request.setAttribute("AdminOrderList", AdminOrderList);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
				
		AdminOrderSelectAllDAO OrderAllDAO = new AdminOrderSelectAllDAO();
		List<UserOrderVO> AdminOrderList = OrderAllDAO.AdminOrderAllDAO();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("OrderSelectAll 서블릿 실행 중 : " + AdminOrderList.size());
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		System.out.println(AdminOrderList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admins/adminOrderList.jsp");
		request.setAttribute("AdminOrderList", AdminOrderList);
		rd.forward(request, response);
	}

}
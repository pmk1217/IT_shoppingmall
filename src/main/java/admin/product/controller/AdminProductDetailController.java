package admin.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.dao.AdminProductDetailDAO;
import user.product.vo.UserProductVO;

@WebServlet("/admin/product/detail")
public class AdminProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		AdminProductDetailDAO adminDetail = new AdminProductDetailDAO();	
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		UserProductVO productVO = adminDetail.adminSelectOne(product_id);
		
		request.setAttribute("productVO", productVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admins/adminProductDetail.jsp");  
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}


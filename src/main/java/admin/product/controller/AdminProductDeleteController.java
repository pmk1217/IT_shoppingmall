package admin.product.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.dao.AdminProductDeleteDAO;


@WebServlet("/admin/product/delete")
public class AdminProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int n = Integer.parseInt(request.getParameter("product_id"));
		
		AdminProductDeleteDAO adminDelete = new AdminProductDeleteDAO();
		
		adminDelete.productDelete(n);
		
		String url = request.getContextPath();
		
		response.sendRedirect(url+"/admin/product/selectAll"); 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}



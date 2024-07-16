package user.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.product.dao.UserProductIncrementViewsDAO;


@WebServlet("/userfilter/product/incrementViews")
public class UserProductIncrementViewsController extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jsp에서 상품 아이디를 받아온다.
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		
		UserProductIncrementViewsDAO userProductIncrementViewsDAO = new UserProductIncrementViewsDAO();
		
		
		// 조회 수 증가 
		userProductIncrementViewsDAO.incrementViews(product_id);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package user.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.product.dao.UserProductSortByViewsDAO;
import user.product.vo.UserProductVO;

@WebServlet("/userfilter/product/sortByViews")
public class UserProductSortByViewsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserProductSortByViewsDAO userProductSortByViews = new UserProductSortByViewsDAO();				
		String category = request.getParameter("category");
		List<UserProductVO> ProductList = userProductSortByViews.productSortByViews(category);
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("UserProductSortByViews 서블릿 실행 중 : " + ProductList.size());
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

		RequestDispatcher rd = request.getRequestDispatcher("/products/productCategory.jsp");
		request.setAttribute("categoryList", ProductList);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

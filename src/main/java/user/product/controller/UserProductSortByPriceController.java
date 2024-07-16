package user.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.product.dao.UserProductSortByPriceDAO;
import user.product.vo.UserProductVO;


@WebServlet("/userfilter/product/sortByPrice")
public class UserProductSortByPriceController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserProductSortByPriceDAO userProductSortByPrice = new UserProductSortByPriceDAO();
		String category = request.getParameter("category");
		List<UserProductVO> ProductList = userProductSortByPrice.productSortByPrice(category);

		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("UserProductSortByPrice 서블릿 실행 중 : " + ProductList.size());
		System.out.println("파라미터 값 : " + category);
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

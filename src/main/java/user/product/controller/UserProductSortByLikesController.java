package user.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.product.dao.UserProductSortByLikesDAO;
import user.product.vo.UserProductVO;


@WebServlet("/userfilter/product/sortByLikes")
public class UserProductSortByLikesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserProductSortByLikesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserProductSortByLikesDAO userProductSortByLikes = new UserProductSortByLikesDAO();
		String category = request.getParameter("category");
		List<UserProductVO> ProductList = userProductSortByLikes.productSortByLikes(category);

		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("productSortByLikes 서블릿 실행 중 : " + ProductList.size());
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
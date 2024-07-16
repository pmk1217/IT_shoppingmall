package user.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.product.dao.UserProductDecrementLikesDAO;
import user.product.dao.UserProductIncrementLikesDAO;
import user.product.dao.UserProductLikesDAO;

@WebServlet("/user/product/incrementLikes")
public class UserProductIncrementLikesController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int product_id = Integer.parseInt(request.getParameter("product_id"));
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("loginInfo");
		int likeCount = 0;
	

		UserProductIncrementLikesDAO userProductIncrementLikesDAO = new UserProductIncrementLikesDAO();

		if (userProductIncrementLikesDAO.checkLike(user_id, product_id)) {// 좋아요가 있으면 true, 없으면 false
			
			UserProductDecrementLikesDAO userProductDecrementLikesDAO = new UserProductDecrementLikesDAO();
			
			userProductDecrementLikesDAO.deleteLikes(user_id, product_id);// db좋아요쌍 삭제
			userProductDecrementLikesDAO.decrementLikes(product_id);// prouduct 좋아요수감소

			UserProductLikesDAO userProductLikesDAO = new UserProductLikesDAO();
			likeCount = userProductLikesDAO.likes(product_id);

			request.setAttribute("likeCount", likeCount);
			response.sendRedirect(request.getContextPath() + "/products/productCategory.jsp");

		} else {

			// close()되었기때문에 객체 다시 생성필요
			userProductIncrementLikesDAO.incrementLikes(product_id);

			UserProductLikesDAO userProductLikesDAO = new UserProductLikesDAO();

			likeCount = userProductLikesDAO.likes(product_id);

			userProductIncrementLikesDAO.addLike(user_id, product_id);
			
			request.setAttribute("likeCount", likeCount);
			response.sendRedirect(request.getContextPath() + "/products/productCategory.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

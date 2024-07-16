package user.action.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.action.dao.UserDetailDAO;
import user.action.vo.UserLikeVO;
import user.action.vo.UserVO;
import user.product.dao.UserProductDetailDAO;
import user.product.vo.UserProductVO;


@WebServlet("/user/action/detail")
public class UserDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO user = new UserVO();
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("loginInfo");
		
		System.out.println(user_id);
		
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		UserProductDetailDAO productDetail = new UserProductDetailDAO();
		
		List<UserProductVO> productList = new ArrayList<>();
		
		List<UserLikeVO> likeList = userDetailDAO.userLike(user_id);
		
		user = userDetailDAO.userdetail(user_id);
		UserLikeVO likeVO = new UserLikeVO();
		System.out.println(likeList);
		
		 for(UserLikeVO userLike : likeList) { 
		 int product = userLike.getProduct_id();
		 System.out.println(product); 
		 UserProductVO productVO = productDetail.selectOne(product);
		  
		 productList.add(productVO); 
		 }
		 System.out.println(productList);
		
		request.setAttribute("product", productList);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/users/detail.jsp");
        dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}

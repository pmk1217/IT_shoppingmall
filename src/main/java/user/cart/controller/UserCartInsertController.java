package user.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.cart.dao.UserCartDuplicatedDAO;
import user.cart.dao.UserCartInsertDAO;
import user.cart.dao.UserCartModifyDAO;
import user.cart.dao.UserCartSelectAllDAO;
import user.cart.vo.UserCartVO;
import user.product.dao.UserProductDetailDAO;
import user.product.vo.UserProductVO;


@WebServlet("/user/cart/insert")
public class UserCartInsertController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String c_userId = request.getParameter("c_userId");
		int c_productId = Integer.parseInt(request.getParameter("c_productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		System.out.println("Received parameters: c_userId=" + c_userId + ", c_productId=" + c_productId + ", quantity=" + quantity);
	
		UserCartInsertDAO userCartInsertDAO = new UserCartInsertDAO();
		UserCartSelectAllDAO userCartSelectAllDAO = new UserCartSelectAllDAO();
		UserCartModifyDAO userCartModifyDAO = new UserCartModifyDAO();
		
		
		List<UserCartVO> cartList = new ArrayList<UserCartVO>();
		List<UserProductVO> productList = new ArrayList<UserProductVO>();		
		
		cartList = userCartSelectAllDAO.selectAll(c_userId);
		
		// 상품이 아이디가 중복인지 아닌지 확인 
		UserCartDuplicatedDAO userCartDuplicatedDAO = new UserCartDuplicatedDAO();
		boolean c_productIdCheck = userCartDuplicatedDAO.duplicatedCheck(c_productId);
		
		
		
		// 상품 카트에 담길때 수량 확인 
		UserProductDetailDAO userProductDetailDAO = new UserProductDetailDAO();	
		UserProductVO userProductVO = new UserProductVO();
		
		userProductVO = userProductDetailDAO.selectOne(c_productId);
		int product_quantity = userProductVO.getQuantity();
	
		
		if(c_productIdCheck) {
			userCartModifyDAO.duplicatedModify(c_productId, quantity);
		} else {
			userCartInsertDAO.insert(c_userId, c_productId, quantity);		
		}
		
		response.sendRedirect(request.getContextPath() + "/user/cart/selectAll?userId=" + c_userId);
		
		
	}
		
}

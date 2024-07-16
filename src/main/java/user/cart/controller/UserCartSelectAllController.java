package user.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.cart.dao.UserCartSelectAllDAO;
import user.cart.vo.UserCartVO;
import user.product.dao.UserProductDetailDAO;
import user.product.vo.UserProductVO;

@WebServlet("/user/cart/selectAll")
public class UserCartSelectAllController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("--------------------------------cartList selectAll Start--------------------------------");
		// 유저, 상품 아이디 가져오기
		String userId = request.getParameter("userId");

		System.out.println("cartSelectAll : " + userId);
		
		List<UserCartVO> cartList = new ArrayList<UserCartVO>();
		List<UserProductVO> productList = new ArrayList<UserProductVO>();		
					
		UserCartSelectAllDAO userCartSelectAllDAO = new UserCartSelectAllDAO();
		UserProductDetailDAO userProductDetailDAO = new UserProductDetailDAO();		
		
		cartList = userCartSelectAllDAO.selectAll(userId);				
		
		for(UserCartVO item : cartList) {
			UserProductVO productVO = null;
			productVO = userProductDetailDAO.selectOne(item.getC_productId());
			productList.add(productVO);
			System.out.println("productId : "+ item.getC_productId());
			System.out.println("productVO : "+ productVO);
		}
		
		// 총 가격을 저장할 리스트
        List<Integer> totalPriceList = new ArrayList<>();
        
        // 각 상품의 총 가격 계산하여 리스트에 저장
        for (int i = 0; i < cartList.size(); i++) {
            int quantity = cartList.get(i).getQuantity();
            int price = productList.get(i).getPrice();
            int totalPrice = quantity * price;
            totalPriceList.add(totalPrice);
            //System.out.println("quantity : "+ quantity + "/ price : " + price);
			//System.out.println("totalPrice : "+ totalPrice);
        }
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/carts/cartList.jsp");
		request.setAttribute("cartList",cartList);
		request.setAttribute("productList", productList);
		request.setAttribute("totalPriceList", totalPriceList);
		dispatcher.forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package user.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.cart.dao.UserCartDeleteOneDAO;
import user.order.dao.UserOrderInsertDAO;

@WebServlet("/user/order/insert")
public class UserOrderInsertController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 주문하기를 클릭하였을때,
		// userid와 해당 상품의 id, 주문수량을 jsp가 post방식으로 전달하고
		// 전달받은 userid와 productID, 주문수량(quantity)를 request를 통해 뽑아내서
		// dao에 있는 userid와 productid, quantity를 매개변수로 받아 해당값을 orderlist db에 insert한다.

		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("loginInfo"));
		String o_userid = (String) session.getAttribute("loginInfo"); // 주문자 아이디
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));

		int orderQuantity = 0;
		
		if (request.getParameter("orderQuantity") == "") {
			orderQuantity = 1;
		} else {
			orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
		}
		
		
		System.out.println("order product_id :"+ product_id);
		

		UserOrderInsertDAO orderInsert = new UserOrderInsertDAO();
		
		System.out.println("==<UserOrderInsertController 구동 중>==");
		System.out.println("가져온 파라미터 값 : " + o_userid + ", " + product_id + ", " + orderQuantity);
		System.out.println("================================");
		
		// 주문목록 추가
		orderInsert.insert(o_userid, product_id, orderQuantity);
		
		// 주문이 추가되면 해당 장바구니 상품 삭제 
		UserCartDeleteOneDAO userCartDeleteOneDAO = new UserCartDeleteOneDAO();
		userCartDeleteOneDAO.deleteOne(product_id);
		
		
		
		
		response.sendRedirect(request.getContextPath() + "/user/order/selectAll?o_userId="+o_userid);
	}

}

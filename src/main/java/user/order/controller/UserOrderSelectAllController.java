package user.order.controller;

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

import user.order.dao.UserOrderSelectAllDAO;
import user.order.vo.UserOrderVO;
import user.product.dao.UserProductDetailDAO;
import user.product.vo.UserProductVO;

@WebServlet("/user/order/selectAll")
public class UserOrderSelectAllController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String o_userID = request.getParameter("o_userId");

		HttpSession session = request.getSession();
		String o_userID = (String) session.getAttribute("loginInfo");

		UserOrderSelectAllDAO selectAllDAO = new UserOrderSelectAllDAO();
		UserProductDetailDAO prouctDetail = new UserProductDetailDAO();

		List<UserProductVO> productList = new ArrayList<>();

		List<UserOrderVO> orderList = selectAllDAO.selectAll(o_userID);

		for (UserOrderVO userOrder : orderList) {
			int oProduct = userOrder.getO_product();
			System.out.println(oProduct);
			UserProductVO product = prouctDetail.selectOne(oProduct);

			productList.add(product);

		}

//		System.out.println("여기까진 실행");

		System.out.println(productList);
		System.out.println("-----------");
		System.out.println(orderList);

		RequestDispatcher rd = request.getRequestDispatcher("/orders/orderList.jsp");
		request.setAttribute("productList", productList);
		request.setAttribute("orderList", orderList);

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String o_userID = request.getParameter("o_userId");
		UserOrderSelectAllDAO selectAllDAO = new UserOrderSelectAllDAO();
		UserProductDetailDAO prouctDetail = new UserProductDetailDAO();
		List<UserProductVO> productList = new ArrayList<>();
		List<UserOrderVO> orderList = selectAllDAO.selectAll(o_userID);

		for (UserOrderVO userOrder : orderList) {
			int oProduct = userOrder.getO_product();

			UserProductVO product = prouctDetail.selectOne(oProduct);

			productList.add(product);

		}

		RequestDispatcher rd = request.getRequestDispatcher("/orders/orderList.jsp");
		request.setAttribute("productList", productList);
		request.setAttribute("orderList", orderList);
		rd.forward(request, response);
	}

}

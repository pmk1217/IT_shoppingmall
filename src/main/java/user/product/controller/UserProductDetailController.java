package user.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.cart.dao.UserCartSelectOneDAO;
import user.cart.vo.UserCartVO;
import user.product.dao.UserProductDetailDAO;
import user.product.vo.UserProductVO;

@WebServlet("/userfilter/product/detail")
public class UserProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserProductDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserProductDetailDAO detail = new UserProductDetailDAO();	
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		UserProductVO ProductVO = detail.selectOne(product_id);
		
		System.out.println("getParameter 값 출력 : " + product_id);
	
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("loginInfo");
		
		
		
		
		
		
		UserCartSelectOneDAO userCartSelectOneDAO = new UserCartSelectOneDAO();
		UserCartVO cartVO = new UserCartVO();
		
		cartVO = userCartSelectOneDAO.selectOne(product_id, user_id);
		
		
		
		
		//확인용
		System.out.println("UserProductDetailController 정상구동 완료!");
		System.out.println("doGet ProductVO : " + ProductVO);
		System.out.println("=====================< UserProductDetailController >=====================");
		
		System.out.println("ProductVO"+ ProductVO);
		System.out.println("product_id"+ product_id);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/products/productDetail.jsp");  
		request.setAttribute("ProductVO", ProductVO);
		request.setAttribute("product_id", product_id);
		request.setAttribute("CartVO", cartVO);
		
		rd.forward(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
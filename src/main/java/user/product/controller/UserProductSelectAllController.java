package user.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.product.dao.UserProductSelectAllDAO;
import user.product.vo.UserProductVO;

@WebServlet("/userfilter/product/selectAll")
public class UserProductSelectAllController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
		
			UserProductSelectAllDAO SelectAllDAO = new UserProductSelectAllDAO();
			List<UserProductVO> ProductList = SelectAllDAO.SelectAll();
			
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("SelectAll 서블릿 실행 중 : " + ProductList.size());
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
			RequestDispatcher rd = request.getRequestDispatcher("/products/productList.jsp"); //수정!!!!!
			request.setAttribute("ProductList", ProductList);
			rd.forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

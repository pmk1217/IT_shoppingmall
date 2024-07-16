package user.product.controller;

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

import user.product.dao.UserProductSearchByCategoryDAO;
import user.product.vo.UserProductVO;

@WebServlet("/userfilter/product/searchByCategory")
public class UserProductSearchByCategoryController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserProductSearchByCategoryDAO SearchByCategoryDAO = new UserProductSearchByCategoryDAO();
		String category = request.getParameter("category");
		List<UserProductVO> categoryList = new ArrayList<UserProductVO>();
		categoryList = SearchByCategoryDAO.SearchByCategory(category);
		
		
		// session 
		HttpSession categorySession = request.getSession();
		categorySession.setAttribute("category", category);
		
		//확인용
		System.out.println("가져온 parameter : " + category);
	
		//확인용
		System.out.println("UserProductSearchByCategoryController 정상구동 완료!");
		System.out.println("doGet categoryList : " + categoryList);
		System.out.println("=====================< UserProductSearchByCategoryController end >=====================");
				
		RequestDispatcher rd = request.getRequestDispatcher("/products/productCategory.jsp");
		request.setAttribute("categoryList", categoryList);
		//request.setAttribute("category", category);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}

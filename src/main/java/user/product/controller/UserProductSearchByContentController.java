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

import user.product.dao.UserProductSearchByContentDAO;
import user.product.vo.UserProductVO;

@WebServlet("/userfilter/product/searchByContent")
public class UserProductSearchByContentController extends HttpServlet {

    public UserProductSearchByContentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {						
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserProductSearchByContentDAO SearchByContentDAO = new UserProductSearchByContentDAO();
		String category = request.getParameter("category");
		String SearchText = request.getParameter("SearchText");
		
		//확인용
		System.out.println("ContentSearchController 구동 완료!!!!!");
		System.out.println("가져온 parameter : " + SearchText + ", " + category);
		
		List<UserProductVO> ContentSearchList = new ArrayList<UserProductVO>();
		ContentSearchList = SearchByContentDAO.SearchByContent(category, SearchText);
		
		System.out.println("UserProductSearchByContentController 정상구동 완료!");
		System.out.println("doGet ContentSearchList : " + ContentSearchList);			
		System.out.println("=====================< UserProductSearchByContentController >=====================");

		
		RequestDispatcher rd = request.getRequestDispatcher("/products/productSearchContent.jsp");
		request.setAttribute("ContentSearchList", ContentSearchList);
		rd.forward(request, response);	
	}

}
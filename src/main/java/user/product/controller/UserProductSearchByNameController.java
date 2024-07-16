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

import user.product.dao.UserProductSearchByNameDAO;
import user.product.vo.UserProductVO;

@WebServlet("/userfilter/product/searchByName")
public class UserProductSearchByNameController extends HttpServlet {
	
    public UserProductSearchByNameController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserProductSearchByNameDAO SearchByNameDAO = new UserProductSearchByNameDAO();
		String category = request.getParameter("category");
		String name = request.getParameter("SearchText");
		
		System.out.println("nameSearchController 구동 완료");
		System.out.println("가져온 parameter : " + category);
		System.out.println("가져온 parameter : " + name);
		
		List<UserProductVO> NameSearchList = new ArrayList<UserProductVO>();
		NameSearchList = SearchByNameDAO.SearchByName(category, name);
		
		//확인용							
				System.out.println("=====================< UserProductSearchByNameController >=====================");
				System.out.println("UserProductSearchByNameController 정상구동 완료!");
				System.out.println("doGet NameSearchList : " + NameSearchList);
				System.out.println("===============================================================================");
		
		RequestDispatcher rd = request.getRequestDispatcher("/products/productSearchName.jsp");
		request.setAttribute("NameSearchList", NameSearchList);
		rd.forward(request, response);	
	}

}

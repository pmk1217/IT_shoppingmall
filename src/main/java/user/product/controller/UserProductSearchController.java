package user.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userfilter/product/search")
public class UserProductSearchController extends HttpServlet {
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Get the selected search type from the form
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
        
		
		String category = request.getParameter("category");
		String searchType = request.getParameter("searchType");
		String SearchText = request.getParameter("SearchText");
        
		System.out.println("SearchController 실행 완료");
		System.out.println("category : " + category);
		System.out.println("searchType : " + searchType);
		System.out.println("SearchText : " + SearchText);
		
        // Redirect to the appropriate search servlet based on the selected search type
        if ("productName".equals(searchType)) {
        	request.setAttribute("SearchText", SearchText);
        	RequestDispatcher rd = request.getRequestDispatcher("/userfilter/product/searchByName");  
    		rd.forward(request, response);
        } else if ("productContent".equals(searchType)) {
        	request.setAttribute("SearchText", SearchText);
        	RequestDispatcher rd = request.getRequestDispatcher("/userfilter/product/searchByContent");  
    		rd.forward(request, response);
        } else {
            response.getWriter().println("에러 발생 : 서블릿이 유효하지 않음");
        }
	}

}
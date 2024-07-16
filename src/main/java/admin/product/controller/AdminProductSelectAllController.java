package admin.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.dao.AdminProductSelectAllDAO;
import user.product.vo.UserProductVO;
import util.AdminProductPageNavigator;

@WebServlet("/admin/product/selectAll")
public class AdminProductSelectAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*  Product DAO  */
	private AdminProductSelectAllDAO productSelectAllDAO = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전달된 파라미터를 이용하여 값 추출(처음에는 전달되는 값이 없슴)
		String pageNum = request.getParameter("pageNum");  // 페이지 번호
		String searchType = request.getParameter("searchType"); // 검색 종류
		String searchText = request.getParameter("searchText");  // 검색어
		if (pageNum == null) {
			pageNum = "1";			// 전달된 페이지 번호가 없으면 1
		}
		if (searchText == null) {
			searchType = "";			// 전달된 검색 종류가 없으면 "" 를 이용하여 초기화
			searchText = "";			// 전달된 검색어가 없으면  "" 를 이용하여 초기화
		}
		
		UserProductVO productVO = new UserProductVO();
		productVO.setPageNum(pageNum);
		productVO.setSearchType(searchType);
		productVO.setSearchText(searchText);
		
		productSelectAllDAO = new AdminProductSelectAllDAO();
		
		// 게시물 총 수 (목록 아래에 페이지 번호를 계산하기 위한 메서드 호출) 
		int totalCount = productSelectAllDAO.selectCount(productVO);
		
		List<UserProductVO> productList = productSelectAllDAO.productSelectAll(productVO);
		
		// View 사용될 객체 설정
		request.setAttribute("totalCount", totalCount);
				
		// 목록 하단 페이지 번호출력을 위한 객체 생성
		AdminProductPageNavigator pNavigator=new AdminProductPageNavigator();
		
		String p_navi=pNavigator.getPageNavigator(totalCount, 
				productVO.getListCount(), 
				productVO.getPagePerBlock(), 
				Integer.parseInt(pageNum), 
				searchType, searchText);
		
		request.setAttribute("pageNavigator", p_navi);   	// 페이지 번호들
		request.setAttribute("productList", productList);
		request.setAttribute("productVO", productVO);
		
		RequestDispatcher requestDispatcher =request.getRequestDispatcher("/admins/adminProductList.jsp");
		requestDispatcher.forward(request, response);
	}

}

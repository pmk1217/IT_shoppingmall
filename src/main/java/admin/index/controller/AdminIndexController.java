package admin.index.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.index.dao.AdminIndexDAO;
import admin.member.dao.AdminMemberSelectAllDAO;
import user.product.vo.UserProductVO;

@WebServlet("/admin/index/count")
public class AdminIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	AdminMemberSelectAllDAO memberSelectAll = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminIndexDAO adminIndexDAO = new AdminIndexDAO();
		
		// 회원 수 조회
        int userCount = adminIndexDAO.userCount();
        request.setAttribute("userCount", userCount);

        // 상품 수 조회
        int productCount = adminIndexDAO.productCount();
        request.setAttribute("productCount", productCount);

        // 상품 quantity 역순 조회
        List<UserProductVO> productQuantity = adminIndexDAO.productQuantity();
        request.setAttribute("productQuantity", productQuantity);

        // 상품 likes순 조회
        List<UserProductVO> productLikes = adminIndexDAO.productLikes();
        request.setAttribute("productLikes", productLikes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admins/adminIndex.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
    }
}


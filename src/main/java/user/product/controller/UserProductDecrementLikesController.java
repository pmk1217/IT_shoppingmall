package user.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.product.dao.UserProductDecrementLikesDAO;

@WebServlet("/user/product/decrementLikes")
public class UserProductDecrementLikesController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jsp에서 상품 아이디를 받아온다.
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		System.out.println("decrementLikes:" +product_id);
		UserProductDecrementLikesDAO userProductDecrementLikesDAO = new UserProductDecrementLikesDAO();
		
	
		// like 상태 
        boolean liked = false;
        boolean likeValue = false;
        // 세션을 가져옴. 세션이 없으면 새로 생성
        
        HttpSession session = request.getSession();

        // 세션에 liked 상태 저장
        session.setAttribute("liked", liked);
        session.setAttribute("likeValue", likeValue);
		
		// 좋아요 수 감소
		userProductDecrementLikesDAO.decrementLikes(product_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

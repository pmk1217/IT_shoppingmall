package user.cart.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.cart.dao.UserCartDeleteDAO;


@WebServlet("/user/cart/delete")
public class UserCartDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		//형변환
		String[] cartIds = request.getParameterValues("cart_id");			
		String IdString = String.join(",", cartIds);				
		String[] splittedIds = IdString.split(",");
		int[] intIds = new int[splittedIds.length];
		
		System.out.println("cartIds 파라미터 값 : " + IdString);
		System.out.println("intIds 파라미터 값 : " + intIds);
		
	    if (cartIds != null && cartIds.length > 0) {

	        for (int i=0; i<splittedIds.length; i++) {
	            try {
	            	
	            	intIds[i] = Integer.parseInt(splittedIds[i]);

	                System.out.println("UserCartDeleteController 실행중");
	                System.out.println("가져온 delete 파라미터 값 : " + intIds[i]);

	                UserCartDeleteDAO userCartDeleteDAO = new UserCartDeleteDAO();

	                userCartDeleteDAO.delete(intIds[i]);

	                System.out.println("삭제 직전");
	            } catch (NumberFormatException e) {
	                
	            	System.err.println("NumberFormatException 에러 발생 : " + e.getMessage());
	                System.out.println("유효하지 않은 cart_id parameter");	               	                
	            }catch (Exception e) {
	            	System.err.println("Exception 에러 발생 : " + e.getMessage());
	            }
	        }
	        //RequestDispatcher dispatcher = request.getRequestDispatcher("/carts/cartList.jsp");
            //dispatcher.forward(request, response);
            
	        HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("loginInfo");
	        
	        response.sendRedirect(request.getContextPath() + "/user/cart/selectAll?userId=" + userId);
            
            
	    }
	}

}


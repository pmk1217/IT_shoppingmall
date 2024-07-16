package admin.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.dao.AdminProductDetailDAO;
import admin.product.dao.AdminProductModifyDAO;
import admin.product.dao.AdminProductSelectAllDAO;
import user.product.vo.UserProductVO;

@WebServlet("/admin/product/modify")
public class AdminProductModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
			UserProductVO productVO = new UserProductVO();
		
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			
			
			AdminProductDetailDAO selectDAO = new AdminProductDetailDAO();
			UserProductVO productOne = selectDAO.adminSelectOne(product_id);
			
			request.setAttribute("productVO", productOne);
			
			System.out.println(productOne);
			
			RequestDispatcher rd=request.getRequestDispatcher("/admins/adminProductModify.jsp");
			rd.forward(request, response);
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
		
		
			UserProductVO productVO = new UserProductVO();
		
			int id = Integer.parseInt(request.getParameter("product_id"));
			int price = Integer.parseInt(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int likes = Integer.parseInt(request.getParameter("likes"));
			
			productVO.setProduct_id(id);
			productVO.setName(request.getParameter("name"));
			productVO.setPrice(price);
			productVO.setContent(request.getParameter("content"));	
			productVO.setQuantity(quantity);
			productVO.setCategory(request.getParameter("category"));
			//productVO.setImg(request.getParameter("img"));
			productVO.setLikes(likes);
			
			AdminProductDetailDAO selectDAO = new AdminProductDetailDAO();
			UserProductVO productOne = selectDAO.adminSelectOne(id);
			String img = productOne.getImg();
			
			if(request.getParameter("img") == "") {
				productVO.setImg(img);
			}else {
				productVO.setImg(request.getParameter("img"));
			}
			
		
			AdminProductModifyDAO modifyDAO = new AdminProductModifyDAO();
			
			modifyDAO.productModify(productVO);
			
			request.setAttribute("productVO", productVO);
		
			/*
			 * RequestDispatcher requestDispatcher =
			 * request.getRequestDispatcher("/admins/adminProductModify.jsp");
			 * requestDispatcher.forward(request, response);
			 */
			String url = request.getContextPath();
			
			response.sendRedirect(url+"/admin/product/selectAll");
	
	}
	

}

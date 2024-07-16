package admin.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.product.dao.AdminProductWriteDAO;
import user.product.vo.UserProductVO;


@WebServlet("/admin/product/write")
public class AdminProductWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminProductWriteDAO adminProductWriteDAO = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admins/adminProductWrite.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String content = request.getParameter("content");
		String img = request.getParameter("img");
		String quantity = request.getParameter("quantity");
		String category = request.getParameter("category");
		
		UserProductVO productVO = new UserProductVO();
		productVO.setName(name);
		productVO.setPrice(Integer.parseInt(price));
		productVO.setContent(content);
		productVO.setImg(img);
		productVO.setQuantity(Integer.parseInt(quantity));
		productVO.setCategory(category);
		
		adminProductWriteDAO = new AdminProductWriteDAO();
		adminProductWriteDAO.productWrite(productVO);
		
		String url = request.getContextPath();
		
		response.sendRedirect(url+"/admin/product/selectAll");
		
		//RequestDispatcher rd=request.getRequestDispatcher("/admins/adminProductList.jsp");
		//rd.forward(request, response);
	}

}


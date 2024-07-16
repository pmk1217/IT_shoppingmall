package user.action.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.action.dao.UserRegisterDAO;
import user.action.vo.ZipCodeVO;


@WebServlet("/userfilter/action/zipcode")
public class ZipCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ziparea3 = request.getParameter("zip_area3");
		System.out.println(ziparea3);

		UserRegisterDAO zipCodeDAO = new UserRegisterDAO();
		List<ZipCodeVO> zipCodeList = new ArrayList<ZipCodeVO>();

		zipCodeList = zipCodeDAO.findZipCode(ziparea3);
		System.out.println(zipCodeDAO);
		request.setAttribute("zipList", zipCodeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/users/zipcode.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

}

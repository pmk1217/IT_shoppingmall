package user.action.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.action.dao.UserDuplicateIdDAO;

@WebServlet("/userfilter/action/duplicatedId")
public class UserDuplicatedIdController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		String user_id = (String) request.getParameter("user_id");

		if (user_id.length() > 0 && user_id.length() < 12) {
			UserDuplicateIdDAO userDAO = new UserDuplicateIdDAO();
			boolean overlappedID = userDAO.overlappedID(user_id);

			if (overlappedID == true) {
				writer.print("not_usable");
			} else {
				writer.print("usable");
			}
		} else {
			writer.print("not_usable");
		}
	}

}

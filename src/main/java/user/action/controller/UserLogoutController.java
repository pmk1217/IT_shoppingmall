package user.action.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userfilter/action/logout")
public class UserLogoutController extends HttpServlet {
    

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      
      session.removeAttribute("loginInfo");
      session.invalidate();
      
      RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
      dispatcher.forward(request, response);
   }

}
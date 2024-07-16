package admin.action.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.dao.AdminLoginDAO;
import admin.action.vo.AdminVO;

@WebServlet("/adminfilter/action/login")
public class AdminLoginController extends HttpServlet {

       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 한글 인코딩 
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset-8");
      
      // 관리자 VO , DAO, List 객체 생성 
      AdminVO adminVO= new AdminVO();
      AdminLoginDAO adminLoginDAO = new AdminLoginDAO();
      List<AdminVO> adminList = new ArrayList<AdminVO>();
      
      // 사용자 입력 유저 아이디, 비밀번호 
      String admin_id = request.getParameter("admin_id");
      String admin_password = request.getParameter("admin_password");
      
      // 아이디 , 비밀번호 체크 여부 
      boolean idCheck = false;
      boolean pwdCheck = false;
      
      
      // DB안 admin_id와 admin_pw 저장한 adminList 반환 
      adminList = adminLoginDAO.Login(admin_id, admin_password);
      
      
      // DB안에 ID와 PW를 확인 
      for(AdminVO admin : adminList) {
         if(admin.getManager_id().equals(admin_id)) {
            idCheck = true;
         }
         
         if(admin.getPassword().equals(admin_password)){
            pwdCheck= true;
         }
      }
      
      String sessionValue = admin_id;
      
      
      // 세션 객체 생성 
      HttpSession session = request.getSession();
      
      // 로그인 에러 메시지 
      String loginErroMsg = null;
      
      
      //System.out.println("idCheck : " + idCheck);
      //System.out.println("pwdCheck : " + pwdCheck);
      
      // 로그인 성공 
      if(idCheck == true && pwdCheck == true) {
         session.setAttribute("adminLoginInfo", sessionValue);
         String url = request.getContextPath();
         RequestDispatcher dispatch = request.getRequestDispatcher("/admin/index/count");
         dispatch.forward(request, response);
      
         
       //아이디가 맞는데 비밀번호가 틀리면 
      } else if(idCheck == true) {
         if(pwdCheck == false) {
            loginErroMsg = "비밀번호를 확인해 주시기 바랍니다";
            RequestDispatcher dispatch = request.getRequestDispatcher("/admins/adminLogin.jsp");
            request.setAttribute("loginErrorMsg", loginErroMsg);
            dispatch.forward(request, response);
            
            
         }
      // 아이디가 존재하지 않을경우 
      } else if(idCheck == false) {
         loginErroMsg = "아이디가 존재하지 않습니다.";
         RequestDispatcher dispatch = request.getRequestDispatcher("/admins/adminLogin.jsp");
         request.setAttribute("loginErrorMsg", loginErroMsg);
         dispatch.forward(request, response);
      }
      
   }

   
}
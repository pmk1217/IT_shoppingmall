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
import javax.servlet.http.HttpSession;

import user.action.dao.UserDetailDAO;
import user.action.vo.UserLikeVO;
import user.product.dao.UserProductDetailDAO;
import user.product.vo.UserProductVO;

@WebServlet("/user/action/userLike")
public class UserDetailLikeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("loginInfo");

        UserDetailDAO userDetailDAO = new UserDetailDAO();
        List<UserLikeVO> likeList = userDetailDAO.userLike(user_id);

        List<UserProductVO> productList = new ArrayList<>();

        UserProductDetailDAO productDetailDAO = new UserProductDetailDAO();
        for (UserLikeVO userLike : likeList) {
            int product_id = userLike.getProduct_id();
            UserProductVO productVO = productDetailDAO.selectOne(product_id);
            productList.add(productVO);
        }
        
        System.out.println(productList);

        request.setAttribute("productList", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/users/userLike.jsp");
        dispatcher.forward(request, response);
    }
}

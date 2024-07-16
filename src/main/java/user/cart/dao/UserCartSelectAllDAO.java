package user.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.action.vo.UserVO;
import user.cart.vo.UserCartVO;
import user.product.dao.UserProductDetailDAO;
import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class UserCartSelectAllDAO extends MySQLConnector {
	Connection connector = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public UserCartSelectAllDAO() {
		this.connector = getConnection();
	}

	public List<UserCartVO> selectAll(String userId) {
		UserCartVO cart = null;
		List<UserCartVO> cartList = new ArrayList<UserCartVO>();
		
		try {
			String query = "select * from cart where c_userid=? order by cart_id desc";
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cart = new UserCartVO();
				cart.setC_userId(rs.getString("c_userId"));
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setC_productId(rs.getInt("c_productId"));
				cart.setQuantity(rs.getInt("quantity"));
				
				cartList.add(cart);
				
			}
			System.out.println(cartList);
		} catch (SQLException e) {
			System.err.println("UserCartSelectAllDAO Error: " + e.getMessage());
		} finally {
			this.close(connector, pstmt, rs);
		}
		
		return cartList;
	}

}

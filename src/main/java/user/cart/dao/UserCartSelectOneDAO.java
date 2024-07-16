package user.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.cart.vo.UserCartVO;
import util.MySQLConnector;

public class UserCartSelectOneDAO extends MySQLConnector {
	Connection connector = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public UserCartSelectOneDAO() {
		this.connector = getConnection();
	}

	public UserCartVO selectOne(int product_id, String userId) {
		UserCartVO cart = null;

		try {
			String query = "select * from cart where c_productId=? and c_userId=?";
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, product_id);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cart = new UserCartVO();
				cart.setC_userId(rs.getString("c_userId"));
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setC_productId(rs.getInt("c_productId"));
				cart.setQuantity(rs.getInt("quantity"));

			}
			
		} catch (SQLException e) {
			System.err.println("UserCartSelectAllDAO Error: " + e.getMessage());
		} finally {
			this.close(connector, pstmt, rs);
		}
		
		return cart;
	}

}

package user.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserCartDeleteOneDAO extends MySQLConnector {
	Connection connector = null;
	PreparedStatement pstmt = null;
	
	public UserCartDeleteOneDAO() {
		this.connector = getConnection();
	}
	
	
	public void deleteOne(int product_id) {
		String query = "DELETE FROM cart WHERE c_productId = ?";
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, product_id);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("UserCartDeleteDAO Error : " + e.getMessage());
		} finally {
			this.close(connector, pstmt);
		}
		
		

	}

}
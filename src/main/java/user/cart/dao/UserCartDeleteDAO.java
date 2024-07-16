package user.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserCartDeleteDAO extends MySQLConnector {
	Connection connector = null;
	PreparedStatement pstmt = null;
	
	public UserCartDeleteDAO() {
		this.connector = getConnection();
	}
	
	
	public void delete(int cart_id) {
		String query = "DELETE FROM cart WHERE cart_id = ?";
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, cart_id);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("UserCartDeleteDAO Error : " + e.getMessage());
		} finally {
			this.close(connector, pstmt);
		}
		
		

	}

}

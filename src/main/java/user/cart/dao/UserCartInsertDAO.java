package user.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserCartInsertDAO extends MySQLConnector{
	Connection connector = null;
	PreparedStatement pstmt = null;
	
	
	public UserCartInsertDAO() {
		connector = this.getConnection();
	}

	
	public void insert(String c_userId, int c_productId, int quantity) {
		String query = "insert into cart (c_userId, c_productId, quantity) VALUES (?, ?, ?)";

		
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, c_userId);
			pstmt.setInt(2, c_productId);
			pstmt.setInt(3, quantity);
			
			pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			System.err.println("UserCartInsertDAO Error: " + e.getMessage());
		} finally {
			this.close(connector, pstmt);
		}
		
		
		
	}

}

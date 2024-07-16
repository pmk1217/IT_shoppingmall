package user.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserCartModifyDAO extends MySQLConnector {
	Connection connector = null;
	PreparedStatement pstmt = null;
	
	public UserCartModifyDAO() {
		this.connector = getConnection();
	}
	
	
	public void modify(int cart_id, int quantity) {
		String query = "UPDATE cart SET quantity = ? WHERE cart_id = ?";
		
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, cart_id);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("UserCartModifyDAO Error : " + e.getMessage());
		} finally {
			this.close(connector, pstmt);
		}

	}
	
	public void duplicatedModify(int c_productId, int quantity) {
		String query = "UPDATE cart set quantity = quantity + ?  where c_productId= ?";
		
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, c_productId);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("UserCartModifyDAO Error : " + e.getMessage());
		} finally {
			this.close(connector, pstmt);
		}
		
	}

}

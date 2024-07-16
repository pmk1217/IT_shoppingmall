package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserProductDecrementLikesDAO extends MySQLConnector{
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	
	
	public UserProductDecrementLikesDAO() {
		this.connector= getConnection();
	}
	
	
	public void decrementLikes(int product_id) {
		String query = "update product set likes = likes - 1 where product_id= ?";
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, product_id);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("decrementLikes ERROR : " + e.getMessage());
		} finally {
			this.close(connector,pstmt);
		}
		
		
	}
	
	public void deleteLikes(String userId, int productId) {
	    String query = "DELETE FROM user_product_likes WHERE user_id = ? AND product_id = ?";

	    try {
	        pstmt = connector.prepareStatement(query);
	        pstmt.setString(1, userId);
	        pstmt.setInt(2, productId);
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
}

package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserProductIncrementLikesDAO extends MySQLConnector {
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public UserProductIncrementLikesDAO() {
		this.connector = getConnection();
	}

	public boolean checkLike(String userId, int productId) {
		String query2 = "SELECT COUNT(*) FROM user_product_likes WHERE user_id = ? AND product_id = ?";

		try {
			pstmt = connector.prepareStatement(query2);
			pstmt.setString(1, userId);
			pstmt.setInt(2, productId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // 좋아요가 이미 추가된 경우 true 반환
			}
		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	public void incrementLikes(int product_id) {
		String query = "update product set likes = likes + 1 where product_id= ?";
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, product_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("incrementLikes ERROR : " + e.getMessage());
		} finally {
//			this.close(connector, pstmt);
		}

	}

	public void addLike(String userId, int productId) {
	    String query3 = "INSERT INTO user_product_likes (user_id, product_id) VALUES (?, ?)";

	    try {
			pstmt = connector.prepareStatement(query3);
			pstmt.setString(1, userId);
			pstmt.setInt(2, productId);
			pstmt.executeUpdate();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
    }
	
	
	


}

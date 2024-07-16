package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserProductLikesDAO extends MySQLConnector{
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public UserProductLikesDAO() {
		this.connector= getConnection();
	}
	
	
	public int likes(int product_id) {
		String query = "select likes from product where product_id=?";
		int likeCount = 0 ;
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, product_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				likeCount = rs.getInt("likes");
			}
			

			
		} catch (SQLException e) {
			System.err.println("incrementLikes ERROR : " + e.getMessage());
		} finally {
			this.close(connector,pstmt, rs);
		}
		
		
		return likeCount;
	}
}

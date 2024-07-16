package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserProductIncrementViewsDAO extends MySQLConnector{
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	
	
	public UserProductIncrementViewsDAO() {
		this.connector= getConnection();
	}
	
	
	
	public void incrementViews(int product_id) {
		String query = "update product set views = views + 1 where product_id= ?";
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, product_id);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("incrementViews ERROR : " + e.getMessage());
		} finally {
			this.close(connector,pstmt);
		}
		
		
	}
}

package user.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserOrderDeleteDAO extends MySQLConnector {

	Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String query1 = "select quantity, o_productId from orderlist WHERE o_userID = ? AND order_id = ?";
	String query2 = "DELETE FROM orderlist WHERE o_userID = ? AND order_id = ?";
	String query3 = "update product set quantity = quantity + ? where product_id = ?";

	public UserOrderDeleteDAO() {
		this.connector = getConnection();
	}

	public void delete(String o_userID, String order_id) {

		
		rollbackProductQuantity(o_userID, order_id);
		
		try {
			pstmt = connector.prepareStatement(query2);
			pstmt.setString(1, o_userID);
			pstmt.setString(2, order_id);

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("delete() ERR: " + e.getMessage());
		} finally {
			close(connector, pstmt);
		}

	}
	
	public void rollbackProductQuantity(String o_userID, String order_id) {
		
		int product_id = 0;
		int quantity = 0;
		try {
			pstmt = connector.prepareStatement(query1);
			pstmt.setString(1, o_userID);
			pstmt.setString(2, order_id);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product_id = Integer.parseInt(rs.getString("o_productId"));
				quantity = Integer.parseInt(rs.getString("quantity"));
				
			}
			
			pstmt.close();
			
			pstmt = connector.prepareStatement(query3);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, product_id);
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.err.println("delete() ERR: " + e.getMessage());
		} finally {
          
             try {
				rs.close();
				 pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
            } 
		
		
	}
	
	

}

package admin.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.MySQLConnector;

public class AdminOrderModifyDAO extends MySQLConnector{
	
	Connection conn = null;
	
	public AdminOrderModifyDAO() {
		this.conn = getConnection();
	}
	
	public void OrderModify(String orderProcess, int order_id) {
		
		String query = "update orderlist set orderProcess=? where order_id= ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, orderProcess);
			pstmt.setInt(2, order_id);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.err.println("AdminOrderModifyDAO ERR : " + e.getMessage());
		}finally {
			close(conn, pstmt);			
		}	
		
	}
	
}
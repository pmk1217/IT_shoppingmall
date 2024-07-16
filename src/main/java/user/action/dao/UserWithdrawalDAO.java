package user.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserWithdrawalDAO {

	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	
	public UserWithdrawalDAO() {
		
	}
	// 글 수정에서 회원정보삭제,탈퇴시 호출(DB삭제)
	public void userDelete(String user_id) {
	    String query = "DELETE FROM user WHERE user_id = ?";
	    
	    try {
	        connector = datasource.getConnection();
	        pstmt = connector.prepareStatement(query);
	        pstmt.setString(1, user_id);
	        
	        pstmt.executeUpdate();
	        
	    } catch (SQLException e) {
	        System.err.println("deleteUser() ERR: " + e.getMessage());
	    } finally {
	        datasource.close(connector, pstmt);
	    }
	}

}

package user.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserDuplicateIdDAO {
	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public UserDuplicateIdDAO() {
		datasource = new MySQLConnector();
	}

	// 중복확인
	public boolean overlappedID(String user_id) {
		boolean result = false;

		try {
			connector = datasource.getConnection();

			String query = "select user_id from user where user_id=?";

			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			result = rs.next();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return result;
	}

}

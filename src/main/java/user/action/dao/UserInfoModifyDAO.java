package user.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import user.action.vo.UserVO;
import util.MySQLConnector;
import org.mindrot.jbcrypt.BCrypt;
public class UserInfoModifyDAO {

	private Connection connector = null;
	private MySQLConnector datasource = null;
	

	public UserInfoModifyDAO() {
		datasource = new MySQLConnector();
	}

	// 글 수정에서 수정완료클릭시 호출(DB업데이트)
	public void userModify(UserVO user) {
		
		PreparedStatement pstmt = null;
		String query = "UPDATE user SET password = ?, name = ?, birthday = ?, email = ?, address = ?, zipcode = ? WHERE user_id = ?";

		try {
			connector = datasource.getConnection();
			pstmt = connector.prepareStatement(query);

			String password = user.getPassword();
			System.out.println(password);
	        String hashedPasswordMo = BCrypt.hashpw(password, BCrypt.gensalt());
	        System.out.println(hashedPasswordMo);
	        
			pstmt.setString(1, hashedPasswordMo);
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getBirthday());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getZipcode());
			pstmt.setString(7, user.getUser_id());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("userModify() ERR: " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt);
		}

	}

}

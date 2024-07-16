package user.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.action.vo.UserVO;
import user.action.vo.ZipCodeVO;
import util.MySQLConnector;
import org.mindrot.jbcrypt.BCrypt;

public class UserRegisterDAO extends MySQLConnector {

	private MySQLConnector datasource = null;
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public UserRegisterDAO() {
		datasource = new MySQLConnector();
	}

	// DB회원정보 추가
	public void addUser(UserVO user) {

		try {
			connector = datasource.getConnection();
			String query = "insert into user (user_id, password, name, birthday, email, address, zipcode) values (?, ?, ?, ?, ?, ?, ?)";// 7개
			pstmt = connector.prepareStatement(query);
			
			String password = user.getPassword();
	        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
	        	        
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, hashedPassword);
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getBirthday());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getZipcode());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}


	// 도로명주소,우편주소 조회
	public List<ZipCodeVO> findZipCode(String streetName) {

		List<ZipCodeVO> zipCodeList = new ArrayList<ZipCodeVO>();
		ZipCodeVO zipCode = null;
		String query = "SELECT *, concat(cityName, ' ', regionName, ' ', streetName) as area FROM zipcode WHERE streetName LIKE concat('%',?,'%')";

		try {
			connector = datasource.getConnection();
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, streetName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				zipCode = new ZipCodeVO();
				zipCode.setZipcode(rs.getString("zipcode"));
				zipCode.setArea(rs.getString("area"));
				zipCodeList.add(zipCode);
			}
		} catch (SQLException e) {
			System.err.println("findZipCode ERR: " + e.getMessage());
		} finally {
			datasource.close(null, pstmt, rs);
		}

		return zipCodeList;
	}

}

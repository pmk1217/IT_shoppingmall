package user.action.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.action.vo.UserVO;
import util.MySQLConnector;

public class UserLoginDAO {

	private Connection connector = null;
	private MySQLConnector datasource = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public UserLoginDAO() {
		datasource = new MySQLConnector();
	}

	public List<UserVO> login() {

		UserVO user = null;
		String query = "select user_id,password from user";
		List<UserVO> userList = new ArrayList<UserVO>();

		try {
			connector = datasource.getConnection();
			stmt = connector.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				user = new UserVO();
				user.setUser_id(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				userList.add(user);
			}

		} catch (Exception e) {
			System.err.println("login() ERR: " + e.getMessage());
		} finally {
			datasource.close(connector, stmt, rs);
		}

		return userList;
	}

}

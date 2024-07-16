package admin.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.action.vo.UserVO;
import util.MySQLConnector;

public class AdminMemberSelectAllDAO extends MySQLConnector {

	private MySQLConnector datasource = null;
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminMemberSelectAllDAO() {
		this.connector = getConnection();
	}
	
	public List<UserVO> userSelectAll() {
		List<UserVO> userList = new ArrayList<UserVO>();
		
		try {
			String query = "select user_id, password, name, birthday, email, created_at from user";
			pstmt = connector.prepareStatement(query);
			
			UserVO userVO = null;
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				/*
				 * String id = rs.getString("user_id"); String pwd = rs.getString("password");
				 * String name = rs.getString("name"); String birthday =
				 * rs.getString("birthday"); String email = rs.getString("email");
				 */
				userVO = new UserVO();
				userVO.setUser_id(rs.getString("user_id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setName(rs.getString("name"));
				userVO.setBirthday(rs.getString("birthday"));
				userVO.setEmail(rs.getString("email"));
				userVO.setCreated_at(rs.getTimestamp("created_at"));
				
				userList.add(userVO);
				
				System.out.println(userList);
			}
			
		} catch (Exception e) {
			System.err.println("회원 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(null, pstmt, rs);
		}
		
		return userList;
	}

		public int userCount() {
			int count = 0;
	
	        try {
	            String query = "SELECT COUNT(*) AS count FROM user";
	            pstmt = connector.prepareStatement(query);
	            rs = pstmt.executeQuery();
	
	            if (rs.next()) {
	                count = rs.getInt("count");
	            }
	        } catch (Exception e) {
	            System.err.println("회원 수 조회 실패: " + e.getMessage());
	        } finally {
	            close(null, pstmt, rs);
	        }
	
	        return count;
	    }
	
}


package user.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.action.vo.UserLikeVO;
import user.action.vo.UserVO;
import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class UserDetailDAO {

	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public UserDetailDAO() {
		datasource = new MySQLConnector();
	}

	public UserVO userdetail(String user_id) {

		UserVO user = new UserVO();
		String query = "select * from user where user_id=?;";

		try {
			connector = datasource.getConnection();
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				user.setUser_id(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setZipcode(rs.getString("zipcode"));

			}

		} catch (Exception e) {
			System.err.println("userdetail() ERR: " + e.getMessage());
		} finally {
			datasource.close(null, pstmt, rs);
		}

		return user;
	}

	public List<UserLikeVO> userLike(String user_id) {
		List<UserLikeVO> likeList = new ArrayList<UserLikeVO>();
		String query = "select * from user_product_likes where user_id=?";
		
		try {
			connector = datasource.getConnection();
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				UserLikeVO likeVO = new UserLikeVO();
				likeVO.setUser_id(rs.getString("user_id"));
				likeVO.setProduct_id(rs.getInt("product_id"));
				
				likeList.add(likeVO);
			}
			
			
		} catch (Exception e) {
			System.err.println("like() ERR: " + e.getMessage());
		} finally {
			datasource.close(null, pstmt, rs);
		}
		
		return likeList;
	}
}

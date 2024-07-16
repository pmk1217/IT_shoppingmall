package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class UserProductSortByLikesDAO extends MySQLConnector{

	Connection conn = null;

	public UserProductSortByLikesDAO() {
		this.conn = getConnection();
	}
	
	public List<UserProductVO> productSortByLikes(String category) {
		
		List<UserProductVO> ProductList = new ArrayList<UserProductVO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM product where category = ? ORDER BY likes DESC";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			UserProductVO ProductVO = null;
			
			while(rs.next()) {
				ProductVO = new UserProductVO();
				ProductVO.setProduct_id(rs.getInt("product_id"));
				ProductVO.setName(rs.getString("name"));
				ProductVO.setPrice(rs.getInt("price"));
				ProductVO.setContent(rs.getString("content"));
				ProductVO.setImg(rs.getString("img"));
				ProductVO.setViews(rs.getInt("views"));
				ProductVO.setLikes(rs.getInt("likes"));
				ProductVO.setCategory(rs.getString("category"));
				ProductVO.setCreated_at(rs.getTimestamp("created_at"));
				ProductVO.setUpdated_at(rs.getTimestamp("updated_at"));
				
				ProductList.add(ProductVO);
				
			}
			
		}catch (Exception e) {
			System.err.println("productSortByLikes() ERR : " + e.getMessage());			
		}finally {
			close(conn, pstmt, rs);
		}
				
		
		return ProductList; 
	} 

}

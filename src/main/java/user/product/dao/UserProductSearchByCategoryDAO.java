
package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class UserProductSearchByCategoryDAO extends MySQLConnector {
	
	Connection conn = null;
	
	public UserProductSearchByCategoryDAO() {
		this.conn = getConnection();
	} //기본생성자 end
	
	public List<UserProductVO> SearchByCategory(String category) {
		
		List<UserProductVO> categoryList = new ArrayList<>();
		
		String query  = "select * from product where category=? ORDER BY created_at DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;				
		
		try {
			
			pstmt = conn.prepareStatement(query);
			System.out.println("category: " + category);
			pstmt.setString(1, category);
			
			UserProductVO ProductVO = new UserProductVO();
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO = new UserProductVO();
				ProductVO.setProduct_id(rs.getInt("product_id"));
				ProductVO.setName(rs.getString("name"));
				ProductVO.setPrice(rs.getInt("price"));
				ProductVO.setContent(rs.getString("content"));
				ProductVO.setQuantity(rs.getInt("quantity"));
				ProductVO.setCategory(rs.getString("category"));
				ProductVO.setImg(rs.getString("img"));
				ProductVO.setLikes(rs.getInt("likes"));
				ProductVO.setViews(rs.getInt("views"));
				
				categoryList.add(ProductVO);
			}
			
			System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
			System.out.println("categoryList : " + categoryList);
			
		}catch (Exception e) {
			System.err.println("ProductSearchByCategoryDAO ERR : " + e.getMessage());
		}finally {
			close(null, pstmt, rs);
		}		
		
		return categoryList;		
	}
	
}//class end
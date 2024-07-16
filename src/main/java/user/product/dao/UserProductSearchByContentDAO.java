package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class UserProductSearchByContentDAO extends MySQLConnector{
	
	Connection conn = null;
	
	public UserProductSearchByContentDAO() {
		this.conn = getConnection();
	}
	
	
	public List<UserProductVO> SearchByContent(String category, String content){
		
		List<UserProductVO> ContentSearchList = new ArrayList<UserProductVO>();
		
		String query = "select * from product where category = ? and content like ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserProductVO ProductVO = null;
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setString(2, "%" + content + "%");
			System.out.println("검색할 content : " + content);
			
			rs = pstmt.executeQuery();
									
			while(rs.next()) {
				ProductVO = new UserProductVO();
				ProductVO.setProduct_id(rs.getInt("product_id"));
				ProductVO.setName(rs.getString("name"));
				ProductVO.setPrice(rs.getInt("price"));
				ProductVO.setContent(rs.getString("content"));
				ProductVO.setQuantity(rs.getInt("quantity"));
				ProductVO.setCategory(rs.getString("category"));
				ProductVO.setViews(rs.getInt("views"));
				ProductVO.setImg(rs.getString("img"));
				ProductVO.setLikes(rs.getInt("likes"));
				
				ContentSearchList.add(ProductVO);
			}
			
			System.out.println(">> ContentSearchList : " + ContentSearchList);
			System.out.println(" ");
			
		}catch (Exception e) {
			System.err.println("SearchByContentDAO ERR : " + e.getMessage());
		}finally {
			close(conn, pstmt, rs);
		}
		
		return ContentSearchList;
	} //SearchByContent end	
}// class end
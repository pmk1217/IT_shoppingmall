package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class UserProductSearchByNameDAO extends MySQLConnector {
		
	Connection conn = null;
	
	public UserProductSearchByNameDAO() {
		this.conn = getConnection();
	} //기본생성자 end
	
	public List<UserProductVO> SearchByName(String category, String name){
		
		List<UserProductVO> NameSearchList = new ArrayList<UserProductVO>();
		
		 String query = "select * from product where category = ? and name like ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserProductVO ProductVO = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setString(2, "%" + name + "%");
			System.out.println("검색할 name : " + name);
			
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
				ProductVO.setViews(rs.getInt("views"));
				ProductVO.setLikes(rs.getInt("likes"));
				
				NameSearchList.add(ProductVO);
			}
			
			System.out.println(">> NameSearchList : " + NameSearchList);
			System.out.println(" ");
			
		}catch (Exception e) {
			System.err.println("SearchByNameDAO ERR : " + e.getMessage());
		}finally {
			close(conn, pstmt, rs);
		}
		
		return NameSearchList; //list 반환
	}
	
} //class end
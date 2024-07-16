package user.product.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class UserProductSelectAllDAO extends MySQLConnector{
	
	Connection conn = null;
	
	public UserProductSelectAllDAO() {
		this.conn = getConnection();
	}
	
	public List<UserProductVO> SelectAll() {
		
		List<UserProductVO> ProductList = new ArrayList<UserProductVO>();
		
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from product";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
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
				
			}//while end
			
		}catch (Exception e) {
			System.err.println("SelectAll ERR : " + e.getMessage());			
		}finally {
			close(conn, stmt, rs);
		}
				
		//확인용
		System.out.println("==================< UserProductSelectAllDAO >==================");
		System.out.println("ProductList 크기 : " + ProductList.size());
		System.out.println("UserProductSelectAllDAO 정상구동 완료!");
		System.out.println("===============================================================");
		
		return ProductList; //List 객체 return
	} // SelectAll() end

} // UserProductListDAO end

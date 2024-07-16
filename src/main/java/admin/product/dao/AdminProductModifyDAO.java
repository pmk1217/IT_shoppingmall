package admin.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class AdminProductModifyDAO extends MySQLConnector {

	private MySQLConnector datasource = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminProductModifyDAO() {
		this.conn = getConnection();
	}
	
	public void productModify(UserProductVO productVO) {
		String query ="update product set name=?, price=?, content=?, quantity=?, category=?, img=?, likes=? where product_id=?";
	
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, productVO.getName());
			pstmt.setInt(2, productVO.getPrice());
			pstmt.setString(3, productVO.getContent());
			pstmt.setInt(4, productVO.getQuantity());
			pstmt.setString(5, productVO.getCategory());
			pstmt.setString(6, productVO.getImg());
			pstmt.setInt(7, productVO.getLikes());
			pstmt.setInt(8, productVO.getProduct_id());
			pstmt.executeUpdate();
			
			System.out.println(productVO.getProduct_id());
			
		} catch (Exception e) {
			System.err.println("Modify() SQL ERR : " + e.getMessage());		
		}finally {
			close(conn, pstmt);
		}
	}
}

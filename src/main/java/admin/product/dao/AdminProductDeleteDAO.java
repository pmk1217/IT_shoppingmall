package admin.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class AdminProductDeleteDAO extends MySQLConnector {

	private MySQLConnector datasource = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminProductDeleteDAO() {
		this.conn = getConnection();
	}

	public void productDelete(int product_id) {
		
		String query = "delete from product where product_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, product_id);
			int n = pstmt.executeUpdate();
			
			if(n>0) {
				System.out.println("delete seccess");
			} else {
				System.out.println("삭제 실패");
			}
			
		} catch (Exception e) {
			System.err.println("delete() SQL ERR : " + e.getMessage());		
		}	finally {
			close(null, pstmt, rs);
		}
	}
}



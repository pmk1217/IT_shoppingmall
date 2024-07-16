package admin.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.product.vo.UserProductVO;
import util.MySQLConnector;

public class AdminProductWriteDAO extends MySQLConnector {

	private MySQLConnector datasource = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminProductWriteDAO() {
		this.conn = getConnection();
	}
	
	public void productWrite(UserProductVO productVO) {
		
		try {
			String query = "insert into product(name, price, content, img, quantity, category) values(?, ?, ?, ?, ?, ?)";		
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,  productVO.getName());
			pstmt.setInt(2,  productVO.getPrice());
			pstmt.setString(3,  productVO.getContent());
			pstmt.setString(4,  productVO.getImg());
			pstmt.setInt(5,  productVO.getQuantity());
			pstmt.setString(6,  productVO.getCategory());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("상품 등록 실패" + e.getMessage());
		}	finally {
			close(conn, pstmt, rs);
		}
	}

}


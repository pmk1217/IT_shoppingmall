package user.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.MySQLConnector;

public class UserCartDuplicatedDAO extends MySQLConnector {
	Connection connector = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	public UserCartDuplicatedDAO() {
		this.connector = getConnection();
	}
	
	
	public boolean duplicatedCheck(int c_productId) {
		String query = "select * FROM cart WHERE c_productId=?";
		boolean prodcutDuplicated = false;
		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setInt(1, c_productId);
			
			rs = pstmt.executeQuery();
			
			// 똑같은 상품이 있다는거
			if(rs.next()) {
				System.out.println("똑같은 상품이 존재합니다");
				prodcutDuplicated = true;
			} else {
				System.out.println("똑같은 상품이 존재하지 않습니다");
				prodcutDuplicated = false;
			}
		} catch (SQLException e) {
			System.err.println("UserCartDeleteDAO Error : " + e.getMessage());
		} finally {
			this.close(connector, pstmt, rs);
		}
		
		return prodcutDuplicated;

	}

}
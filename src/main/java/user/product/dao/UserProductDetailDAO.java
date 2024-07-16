package user.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.MySQLConnector;

import user.product.vo.UserProductVO;

public class UserProductDetailDAO extends MySQLConnector {

	Connection conn = null;

	public UserProductDetailDAO() {
		this.conn = getConnection();
	} // 기본생성자 end

	public UserProductVO selectOne(int product_id) {
		// 상품 이미지 , 상품명, 가격, 좋아요(별점), 설명
		String query = "select * from product where product_id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserProductVO ProductVO = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, product_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				ProductVO = new UserProductVO();
				ProductVO.setProduct_id(rs.getInt("product_id"));
				ProductVO.setName(rs.getString("name"));
				ProductVO.setPrice(rs.getInt("price"));
				ProductVO.setContent(rs.getString("content"));
				ProductVO.setQuantity(rs.getInt("quantity"));
				ProductVO.setCategory(rs.getString("category"));
				ProductVO.setImg(rs.getString("img"));
				ProductVO.setLikes(rs.getInt("likes"));
			} // if end

		} catch (SQLException e) {
			System.err.println("Detail() SQL ERR : " + e.getMessage());
		} finally {
			close(null, pstmt, rs);
		}

		return ProductVO;
	} // SelectOne end

} // class end
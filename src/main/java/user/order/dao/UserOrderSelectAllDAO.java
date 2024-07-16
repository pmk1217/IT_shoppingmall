package user.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.order.vo.UserOrderVO;
import util.MySQLConnector;

public class UserOrderSelectAllDAO extends MySQLConnector {

	Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String query = "select * from orderList where o_userId=? order by order_id desc";

	public UserOrderSelectAllDAO() {
		this.connector = getConnection();
	}

	// order한 유저id를 받아서 해당 유저의 주문내역리스트를 출력해주는 메소드
	public List<UserOrderVO> selectAll(String o_userId) {

		List<UserOrderVO> orderList = new ArrayList<UserOrderVO>();

		try {
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, o_userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				UserOrderVO orderVO = new UserOrderVO();

				orderVO.setOrder_id(rs.getString("order_id"));
				orderVO.setO_user(rs.getString("o_userId"));
				orderVO.setO_product(rs.getInt("o_productId"));
				orderVO.setQuantity(rs.getInt("quantity"));
				orderVO.setOrderProcess(rs.getString("orderProcess"));
				orderVO.setCreated_at(rs.getTimestamp("created_at"));
				orderVO.setUpdated_at(rs.getTimestamp("updated_at"));

				orderList.add(orderVO);
			}
		} catch (Exception e) {
			System.err.println("selectAll() ERR: " + e.getMessage());
		} finally {
			close(null, pstmt, rs);
		}

		return orderList;
	}
}

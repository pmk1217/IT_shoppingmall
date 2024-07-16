package user.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MySQLConnector;

public class UserOrderInsertDAO extends MySQLConnector {

	Connection connector = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	String query1 = "INSERT INTO orderlist (o_userId, o_productId, quantity) VALUES (?, ?, ?)";
	String query2 = "select o_productId, orderProcess from orderlist where o_userId=?";
	String query3 = "UPDATE orderlist SET quantity = quantity + ? WHERE o_userId = ? AND o_productId = ?";
	String query4 = "update product set quantity = quantity - ? where product_id=?";

	public UserOrderInsertDAO() {
		this.connector = getConnection();
	}

	public void insert(String o_userid, int o_productId, int quantity) {

		if (!find(o_userid, o_productId)) {
			try {
				pstmt = connector.prepareStatement(query1);
				pstmt.setString(1, o_userid);
				pstmt.setInt(2, o_productId);
				pstmt.setInt(3, quantity);
				pstmt.executeUpdate();
				pstmt.close();

				pstmt = connector.prepareStatement(query4);
				pstmt.setInt(1, quantity);
				pstmt.setInt(2, o_productId);

				pstmt.executeUpdate();

			} catch (Exception e) {
				System.err.println("insert() ERR: " + e.getMessage());
			} finally {
				close(connector, pstmt, rs);
			}
		} else {
			try {
				pstmt = connector.prepareStatement(query3);
				pstmt.setInt(1, quantity);
				pstmt.setString(2, o_userid);
				pstmt.setInt(3, o_productId);

				pstmt.executeUpdate();
				
				pstmt.close();

				pstmt = connector.prepareStatement(query4);
				pstmt.setInt(1, quantity);
				pstmt.setInt(2, o_productId);

				pstmt.executeUpdate();

			} catch (Exception e) {
				System.err.println("insert() ERR: " + e.getMessage());
			} finally {
				close(connector, pstmt, rs);
			}

		}

	}

	public boolean find(String user_id, int product_id) {

		boolean result = false;

		try {
			pstmt = connector.prepareStatement(query2);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				if (product_id == Integer.parseInt(rs.getString("o_productId"))) {

					if (rs.getString("orderProcess").equals("0")) {

						result = true;

						break;
					}

				}
			}

		} catch (Exception e) {
			System.err.println("find() ERR: " + e.getMessage());
		}

		return result;

	}

}

package admin.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.order.vo.UserOrderVO;
import util.MySQLConnector;

public class AdminOrderSelectAllDAO extends MySQLConnector{
	
	Connection conn = null;
	
	public AdminOrderSelectAllDAO() {
		this.conn = getConnection();
		System.out.println("AdminOrderSelectAllDAO 구동 시작합니당!");
	}
	
	public List<UserOrderVO> AdminOrderAllDAO(){
		
		List<UserOrderVO> AdminOrderList = new ArrayList<UserOrderVO>();
		
		String query = "select * from orderlist order by order_id desc";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		UserOrderVO OrderVO = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);			
			
			while(rs.next()) {				
				OrderVO = new UserOrderVO();
				
				OrderVO.setOrder_id(rs.getString("order_id"));
				OrderVO.setO_user(rs.getString("o_userId"));
				OrderVO.setO_product(rs.getInt("o_productId"));
				OrderVO.setQuantity(rs.getInt("quantity"));
				OrderVO.setOrderProcess(rs.getString("orderProcess"));
				OrderVO.setCreated_at(rs.getTimestamp("created_at"));
				OrderVO.setUpdated_at(rs.getTimestamp("updated_at"));
				
				AdminOrderList.add(OrderVO);
				System.out.println("AdminOrderList 크기 : " + AdminOrderList.size());
			}
			
		}catch (Exception e) {
			System.err.println("");
		}finally {
			close(conn, stmt, rs);
		}
		
		//확인용
				System.out.println("==================< AdminOrderSelectAllDAO >==================");
				System.out.println("AdminOrderList 크기 : " + AdminOrderList.size());
				System.out.println("AdminOrderSelectAllDAO 정상구동 완료!");
				System.out.println("==============================================================");
		
		return AdminOrderList; //List return
	}
	
}
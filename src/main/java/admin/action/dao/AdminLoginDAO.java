package admin.action.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.action.vo.AdminVO;
import util.MySQLConnector;

public class AdminLoginDAO extends MySQLConnector{
	Connection connector = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public AdminLoginDAO() {
		this.connector = getConnection();
	}
	
	public List<AdminVO> Login(String admin_id, String admin_password){
		AdminVO admin = null;
		List<AdminVO> adminList = new ArrayList<AdminVO>();
		
		try {
			stmt = connector.createStatement();
			String query = "select manager_id, password from manager";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				admin = new AdminVO();
				admin.setManager_id(rs.getString("manager_id"));
				admin.setPassword(rs.getString("password"));
				
				adminList.add(admin);
			}
		
			
		} catch (SQLException e) {
			System.err.println("admin Login Error: " + e.getMessage());
		} finally {
			this.close(null, stmt, rs);
		}
		
		return adminList;
	}
	
	

}

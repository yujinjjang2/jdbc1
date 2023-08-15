package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest4 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			
			String ip = "localhost";
			
			String port = ":1521";
			
			String sid = ":XE";
			
			String id = "workbook";
			
			String pw = "workbook";
			
			conn = DriverManager.getConnection(type+ip+port+sid, id, pw);
			
			String sql = "SELECT MENU_ID, MENU_NAME, MENU_PRICE FROM TB_MENU";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String menuId = rs.getString("MENU_ID");
				String menuName = rs.getString("MENU_NAME");
				int menuPrice = rs.getInt("MENU_PRICE");
				
				System.out.println(menuId + " " + menuName + " " + menuPrice);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		
	}

}

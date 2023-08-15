package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest5 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			String id = "workbook";
			
			String pw = "workbook";
			
			conn = DriverManager.getConnection(url, id, pw);

			stmt = conn.createStatement();
			
			String sql = "UPDATE TB_MENU SET MENU_NAME = '녹차라떼' WHERE MENU_ID = 'A04'";
			
			int result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("성공~");
			}
			
			
		} catch(Exception e) {
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

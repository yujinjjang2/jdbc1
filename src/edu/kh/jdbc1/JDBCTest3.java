package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest3 {
	
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
						
			String sql = "INSERT INTO TB_ORDER VALUES(SQ_ORDER_NO.NEXTVAL, 'A01', SYSDATE)";
			int count = stmt.executeUpdate(sql);
			
			if(count > 0) {
				
				System.out.println("성공적으로 저장했습니다.");
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

package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest2 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			String id = "workbook";
			
			String password = "workbook";
			
			conn = DriverManager.getConnection(url, id, password);
			
			String sql = "SELECT TERM_NO, STUDENT_NO, CLASS_NO, POINT FROM TB_GRADE WHERE ROWNUM <= 100";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			int cnt = 1;
			
			while(rs.next()) {
				
				String termNo = rs.getString(1);
				String studentNo = rs.getString("STUDENT_NO");
				String classNo = rs.getString("CLASS_NO");
				float point = rs.getFloat(4);
				
				System.out.println(cnt + " " + termNo + " " + studentNo + " " + classNo + " " + point);
				
				cnt++;
				
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

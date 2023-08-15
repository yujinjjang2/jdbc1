package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest6 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			String id = "workbook";
			
			String pw = "workbook";
			
			conn = DriverManager.getConnection(url, id, pw);

			stmt = conn.createStatement();
			
			System.out.println("메뉴 id를 입력하세요.");
			System.out.print("메뉴 id 입력 : ");
			String menuId = sc.nextLine();
			
			System.out.println("메뉴 이름을 입력하세요.");
			System.out.print("메뉴 이름 입력 : ");
			String menuName = sc.nextLine();
			
			System.out.println("메뉴 가격을 입력하세요.");
			System.out.print("메뉴 가격 입력 : ");
			int menuPrice = sc.nextInt();
			sc.nextLine();
			
			String sql = "INSERT INTO TB_MENU VALUES('" + menuId + "', '" + menuName + "', " + menuPrice + ")";
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("성공~");
			}
			
			sql = "SELECT MENU_ID, MENU_NAME, MENU_PRICE FROM TB_MENU";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String menuId1 = rs.getString("MENU_ID");
				String menuName1 = rs.getString("MENU_NAME");
				String menuPrice1 = rs.getString("MENU_PRICE");
				
				System.out.println(menuId1 + " " + menuName1 + " " + menuPrice1);
				
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

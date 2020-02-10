package test_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		Boolean result = delete(1L);
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
	public static Boolean delete(Long no) {
		
		Boolean result = false;
		Connection con = null;
		Statement stmt = null;
		
		// 1.JDBC Driver(MyDriver) 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			con =  DriverManager.getConnection(url,"webdb","webdb");
			
			// 3.Statement 객체 생성
			stmt = con.createStatement();
			
			// 4.SQL문 실행
			String sql = "delete from dept where no = "+no;
			int count = stmt.executeUpdate(sql);
			
			// 5. 성공여부
			result = count == 1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+ e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			//6. 자원정리
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();	
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}		
	

}

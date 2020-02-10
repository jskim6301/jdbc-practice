package test_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 1.JDBC Driver(MyDriver) 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			con =  DriverManager.getConnection(url,"webdb","webdb");
			
			// 3.Statement 객체 생성
			stmt = con.createStatement();
			
			// 4.SQL문 실행
			String sql = "select no,name from dept";
			rs = stmt.executeQuery(sql);
			
			//5. 결과 가져오기
			while(rs.next()) {
				Long no = rs.getLong(1); //0부터 시작이 아닌 1부터 시작
				String name = rs.getString(2);
				System.out.println(no+":"+name);
			}			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+ e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			//6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
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

	}

}

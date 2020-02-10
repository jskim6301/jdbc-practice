package test_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection connection = null;
		// 1.JDBC Driver(MyDriver) 로딩
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2.연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			connection =  DriverManager.getConnection(url,"webdb","webdb");
			
			System.out.println("연결성공!");			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+ e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			// 3. 자원 정리
			try {
				if(connection != null) {
					connection.close();	
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}

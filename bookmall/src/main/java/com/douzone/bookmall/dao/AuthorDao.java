package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.AuthorVo;

public class AuthorDao {
	
	private Connection getConnection() throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			

			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			con =  DriverManager.getConnection(url,"webdb","webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+ e);
		}
		return con;
	}
	
	
	public List<AuthorVo> findAll(){
		List<AuthorVo> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
			String sql = "select no,name from author";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//5. 결과 가져오기
			while(rs.next()) {
				Long no = rs.getLong(1); //0부터 시작이 아닌 1부터 시작
				String name = rs.getString(2);
				AuthorVo vo = new AuthorVo();
				vo.setNo(no);
				vo.setName(name);
				
				result.add(vo);
			}			
			
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			//6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
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
	
	
	public Boolean insert(AuthorVo authorVo) {
		
		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
		
			String sql = "insert into author values(null,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, authorVo.getName());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			//6. 자원정리
			try {
				if(pstmt != null) {
					pstmt.close();
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
	
	public boolean delete(AuthorVo authorVo) {
		
		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();	

			String sql = "delete from author where name =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, authorVo.getName());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {

			try {
				if(pstmt != null) {
					pstmt.close();
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
	
	public boolean update(AuthorVo vo,String newName) {  //updateTest("김난도","김절도")

		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update author set name =? where name = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,newName);
			pstmt.setString(2,vo.getName());
			
//			pstmt.setString(1,"'"+newName+"'");   안먹힘
//			pstmt.setString(2,"'"+vo.getName()+"'");
			
			int count = pstmt.executeUpdate();
			

			result = count == 1;
			
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
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

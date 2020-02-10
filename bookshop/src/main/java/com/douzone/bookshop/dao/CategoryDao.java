package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CategoryVO;
import com.douzone.bookshop.vo.MemberVO;



public class CategoryDao {
	private Connection getConnection() throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			con =  DriverManager.getConnection(url,"bookshop","bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+ e);
		}
		return con;
	}
	
	public Boolean insert(String name) {
		
		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "insert into category values(null,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			
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
	
	public List<CategoryVO> findAll(){
		List<CategoryVO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
			String sql = "select no,name from category";

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//5. 결과 가져오기
			while(rs.next()) {
				Long no = rs.getLong(1); //0부터 시작이 아닌 1부터 시작
				String name = rs.getString(2);
				
				
				CategoryVO vo = new CategoryVO();
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
	
	public boolean delete(Long no) {
		
		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();	

			String sql = "delete from category where no =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
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
	
	public boolean update(CategoryVO categoryVO) {  

		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update category set name =? where no = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,categoryVO.getName());
			pstmt.setLong(2,categoryVO.getNo());
			
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

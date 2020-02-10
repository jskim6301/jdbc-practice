package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.BookVO;

public class BookDao {
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
	
	public Boolean insert(BookVO bookVO) {
		
		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			//insert into book values(null,'홍길동전',30000,1)
			String sql = "insert into book values(null,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bookVO.getTitle());
			pstmt.setInt(2, bookVO.getPrice());
			pstmt.setLong(3, bookVO.getCategoryNo());
			
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
	
	public List<BookVO> findAll(){
		List<BookVO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
//			String sql = "select b.no,b.title,b.price,c.no,c.name from book b,category c where b.category_no = c.no";
			String sql = "select b.title,b.price,c.name from book b,category c where b.category_no = c.no";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				Long no = rs.getLong(1); //0부터 시작이 아닌 1부터 시작
				String title = rs.getString(1);
				int price = rs.getInt(2);
//				Long categoryNo = rs.getLong(4);
				String categoryName = rs.getString(3);
				
				
				BookVO vo = new BookVO();
//				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
//				vo.setCategoryNo(categoryNo);
				vo.setCategoryName(categoryName);
				
				result.add(vo);
			}			
			
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
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

			String sql = "delete from book where no = ?";
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
	
	public boolean update(BookVO bookVO) {  

		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update book set price =? where no = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,bookVO.getPrice());
			pstmt.setLong(2,bookVO.getNo());
			
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

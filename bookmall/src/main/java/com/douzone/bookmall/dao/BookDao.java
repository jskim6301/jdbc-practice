package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;

public class BookDao {
	
	
	
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
	
	public List<BookVo> findAll(){
		List<BookVo> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
//			String sql = "select no,title,state,author_no from book";
			String sql = "select b.no,b.title,b.state,b.author_no,a.name from book b,author a where b.author_no = a.no";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//5. 결과 가져오기
			while(rs.next()) {
				Long no = rs.getLong(1); //0부터 시작이 아닌 1부터 시작
				String title = rs.getString(2);
				String state = rs.getString(3);
				Long authorNo = rs.getLong(4);
				String authorName = rs.getString(5);
				
				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setState(state);
				vo.setAuthorNo(authorNo);
				vo.setAuthorName(authorName);
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
	
	public Boolean insert(BookVo bookVo) {
			
			Boolean result = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
			
				String sql = "insert into book values(null,?,?,?)";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, bookVo.getTitle());
				pstmt.setString(2, bookVo.getState());
				pstmt.setLong(3, bookVo.getAuthorNo());
				
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
	
	public boolean delete(BookVo bookVo) {
		
		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();	

			String sql = "delete from book where title =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bookVo.getTitle());
			
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
	
	
	public boolean update(Long no,String newState) {  

		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update book set state =? where no = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,newState);
			pstmt.setLong(2,no);
			
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

package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVO;

public class CartDao {
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
	
	public Boolean insert(CartVO cartVO) {
		
		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			//insert into cart values(1,4,30)
			String sql = "insert into cart values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, cartVO.getMemberNo());
			pstmt.setLong(2, cartVO.getBookNo());
			pstmt.setInt(3, cartVO.getAmount());
			
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

	public List<CartVO> findAll(){
		List<CartVO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
//			String sql = "select a.no,a.name,c.no,c.title,c.price,b.amount from member a, cart b, book c where a.no = b.member_no and b.book_no = c.no";
			String sql = "select c.title,b.amount,c.price from member a, cart b, book c where a.no = b.member_no and b.book_no = c.no";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				Long memberNo = rs.getLong(1);
				String bookTitle = rs.getString(1);
				int amount = rs.getInt(2);
//				String memberName = rs.getString(2);
//				Long bookNo = rs.getLong(3);
				
				int bookPrice = rs.getInt(3);
				
				
				CartVO vo = new CartVO();
//				vo.setMemberNo(memberNo);
//				vo.setMemberName(memberName);
//				vo.setBookNo(bookNo);
				vo.setBookTitle(bookTitle);
				vo.setBookPrice(bookPrice);
				vo.setAmount(amount);
				
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
	
	
	public boolean update(CartVO cartVO) {  

		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update cart set amount =? where no = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,cartVO.getAmount());
			pstmt.setLong(2,cartVO.getMemberNo());
			
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

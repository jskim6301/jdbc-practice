package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderBookVO;
import com.douzone.bookshop.vo.OrderVO;



public class OrderDao {
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
	
	public Boolean insert(OrderVO orderVO) {

		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			//insert into orders values(null,now(),30000,'워싱턴',1);
			String sql = "insert into orders values(null,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, orderVO.getOrderNo());
			pstmt.setInt(2, orderVO.getAuthorizationPrice());
			pstmt.setString(3, orderVO.getLocation());
			pstmt.setLong(4, orderVO.getMemberNo());

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
	
	public List<OrderVO> orderList(){
		List<OrderVO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
			String sql = "select a.order_no,b.name,b.email,a.authorization_price,a.location from orders a,member b where a.member_no = b.no ";

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String orderNo = rs.getString(1);
				String memberName = rs.getString(2);
				String memberEmail = rs.getString(3);
				int authorizationPrice = rs.getInt(4);
				String location = rs.getString(5);
				
				
				
								
				OrderVO vo = new OrderVO();
				vo.setOrderNo(orderNo);
				vo.setMemberName(memberName);
				vo.setMemberEmail(memberEmail);
				vo.setAuthorizationPrice(authorizationPrice);
				vo.setLocation(location);
				
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
	
	public List<OrderBookVO> orderBookList(){
		List<OrderBookVO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
			String sql = "select d.book_no,e.title,d.amount from order_book a, orders b, member c,cart d,book e where a.order_number = b.no and b.no=c.no and c.no = d.member_no and d.book_no = e.no";

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long bookNo = rs.getLong(1);
				String bookTitle = rs.getString(2);
				int amount = rs.getInt(3);
				
				OrderBookVO vo = new OrderBookVO();
				vo.setBookNo(bookNo);
				vo.setBookTitle(bookTitle);
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
	
	
	public boolean delete(Long no) {

		Boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();	

			String sql = "delete from orders where no =?";
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

	
	
	
	
}

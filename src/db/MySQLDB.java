package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDB {
	
	public int login(String loginID, String loginPW) {
		 Connection conn= null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
	      String dbID = "root";
	      String dbPW = "rootroot";
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	         
	         String sql = " SELECT mID, mPW from memberTBL WHERE mID = ? and mPW = ? "; 
	               
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, loginID);   
	         pstmt.setString(1, loginPW);     
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 String resultID = rs.getString("mID");
	        	 String resultPW = rs.getString("mPW");
	        	 if(resultID.equals(loginID && resultPW.equals(loginPW)){
	        		 System.out.println("로그인 성 공");
	        	 }
	        	 
	        
	        }else {
	        	 System.out.println("실패");
	        	
	        }
	         
	         
	         
	         
	         
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
		
		
		
	}
   
   public boolean idDuplicate(String mID) {
      Connection conn= null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
      String dbID = "root";
      String dbPW = "rootroot";
      
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
         
         String sql = " SELECT mID from memberTBL WHERE mID = ? ";
               
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mID);         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
        	 
        	 System.out.println("중복된느 아이디가 존재 ");
        	 return true ; 
        }else {
        	 System.out.println("중복된느 아이디가 없음");
        	return false;
        }
         
         
         
         
         
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(pstmt != null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         if(conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
	return false;
   }


	
}
   




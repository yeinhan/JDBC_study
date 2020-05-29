package com.test02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;
import com.test02.dto.MyTest;

public class MyTestDao {

	public List<MyTest> getALl(Connection con) {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MYTEST";
		List<MyTest> my = new ArrayList<>(); 
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MyTest tmp = new MyTest(
						rs.getInt(1),rs.getString(2),rs.getString(3));
				my.add(tmp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
				
		return my;
	}

	public int getUpdate(Connection con, MyTest update) {
	      PreparedStatement pstm = null;
	      int res = 0;
	      
	      String sql = "UPDATE MYTEST SET MNAME=?,NICKNAME=? WHERE MNO=?";
	      
	      try {
	         pstm = con.prepareStatement(sql);
	         pstm.setString(1, update.getMname());
	         pstm.setString(2, update.getMnickname());
	         pstm.setInt(3, update.getMno());
	         
	         res = pstm.executeUpdate();
	         if(res>0) {
	            commit(con);
	         }
	      } catch (SQLException e) {
	         System.out.println("update 에러");
	         rollback(con);
	         e.printStackTrace();
	      } finally {
	         close(pstm);
	      }
	      
	      return res;
	   }

	public int getInsert(Connection con, MyTest dto) {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)";
		int res = 0;
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getMno());
			pstm.setString(2, dto.getMname());
			pstm.setString(3, dto.getMnickname());
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			rollback(con);
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		return res;
	}

	public int getDelete(Connection con, int del) {
		PreparedStatement pstm = null;
		int res =0;
		
		String sql = "DELETE FROM MYTEST WHERE = MNO?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, del);
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			rollback(con);
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		
		
		
		return res;
	}

}

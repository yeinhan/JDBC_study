package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest03_select {

	public static void main(String[] args) throws Exception  {
		//jdbc를 통한 db연결 후 mytest테이블 select하는 코드 작성
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id= "KH";
		String pw = "KH";
		String sql = "SELECT * FROM MYTEST";
		
		Class.forName(driver);
		con = DriverManager.getConnection(url,id,pw);
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" : " +rs.getString(2) + " : " +rs.getString(3));
			
		}
		rs.close();
		stmt.close();
		con.close();
		
		
	}

}

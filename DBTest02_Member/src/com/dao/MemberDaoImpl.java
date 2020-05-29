package com.dao;


import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.Member;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> selectAll(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> res = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectAll);
			
			while(rs.next()) {
				Member tmp = new Member();
				tmp.setM_no(rs.getInt(1));
				tmp.setM_name(rs.getString(2));
				tmp.setM_age(rs.getInt(3));
				tmp.setM_gender(rs.getString("M_GENDER"));
				tmp.setM_location(rs.getString(5));
				tmp.setM_job(rs.getString(6));
				tmp.setM_tel(rs.getString(7));
				tmp.setM_email(rs.getString(8));
				
				res.add(tmp);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return res;
	}

	@Override
	public Member selectOne(Connection con, int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection con, Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection con, int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection con, Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.biz;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.dao.MemberDaoImpl;
import com.dto.Member;

public class MemberBizImpl implements MemberBiz {
	MemberDaoImpl dao = new MemberDaoImpl();
	
	
	@Override
	public List<Member> selectAll() {
		Connection con = getConnection();
		List<Member> res = dao.selectAll(con);
		close(con);
		return res;
	}

	@Override
	public Member selectOne(Connection con, int no) {
		Connection con = getConnection();
		Member m = dao.selectOne(con, no);
		close(con);
		
		return null;
	}

	@Override
	public int insert(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

}

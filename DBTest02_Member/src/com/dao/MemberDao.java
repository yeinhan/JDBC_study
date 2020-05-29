package com.dao;

import java.sql.Connection;
import java.util.List;

import com.dto.Member;

public interface MemberDao {
	public String selectAll = " SELECT * FROM TB_MEMBER";
	public String selectOne = "	SLECT * FROM TB_MEMBER WHERE M_NO=? ";
	public String insert = "";
	public String delete= "";
	public String update = "";
	
	public List<Member> selectAll(Connection con);
	public Member selectOne(Connection con,int no);
	public int insert(Connection con, Member m);
	public int delete(Connection con, int no);
	public int update(Connection con, Member m);
	
	
}

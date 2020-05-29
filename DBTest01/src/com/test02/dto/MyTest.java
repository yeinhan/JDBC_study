package com.test02.dto;

public class MyTest {
	private int mno;
	private String mname;
	private String mnickname;
	
	public MyTest()	{}
	
	public MyTest(int mno, String mname, String mnickname) {
		super();
		this.mname = mname;
		this.mno = mno;
		this.mnickname = mnickname;
		
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMnickname() {
		return mnickname;
	}
	public void setMnickname(String mnickname) {
		this.mnickname = mnickname;
	}
	
	@Override 
	public String toString() {
		return "Mytest [mno=" + mno +"," +", mname ="+mname+", mnickname="+mnickname+"]";
	}
	//생성자(기본/매개변수) getter, setter toString
	
	
}

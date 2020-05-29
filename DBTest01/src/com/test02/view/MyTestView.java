package com.test02.view;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.Scanner;

import com.test02.dao.MyTestDao;
import com.test02.dto.MyTest;

public class MyTestView {
	static Scanner sc= new Scanner(System.in);
	
	public static int getMenu() {
		int select =0;
		
		System.out.println("1. 전체출력");
		System.out.println("2. 추가");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		System.out.println("================");
		System.out.print("번호 선택:");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int no=0;
		
		int mno=0;
		String name= null;
		String nickname =null;
		
		Connection con = getConnection();
		MyTestDao dao = new MyTestDao();
		
		do {
			no = getMenu();
			
			switch(no) {
				//전체출력
			case 1:
				System.out.println("***전체출력****");
				System.out.println(dao.getALl(con));
				break;
			case 2:
				System.out.print("추가할 번호:");
				mno=sc.nextInt();
				System.out.print("추가할 이름:");
				name = sc.next();
				System.out.print("추가할 별명:");
				nickname = sc.next();
				
				MyTest dto = new MyTest(mno, name, nickname);
				int res = dao.getInsert(con, dto);
				
				if(res>0) {
					System.out.println("입력 성공");
				}else {
				}
				break;
				
				//수정
			case 3:
				System.out.print("수정할 번호:");
				mno=sc.nextInt();
				System.out.print("수정할 이름:");
				name = sc.next();
				System.out.print("수정할 별명:");
				nickname = sc.next();
				
				MyTest update = new MyTest(mno,name, nickname);
				
				int res_update= dao.getUpdate(con,update);
				
				if(res_update >0) {
					System.out.println("수정 성공!!");
				}else {
					System.out.println("수정 실패!!");
				}
				break;
			case 4:
				System.out.print("삭제할 번호:");
				int del = sc.nextInt();
				
				int del_res = dao.getDelete(con, del);
				if(del_res>0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				break;
				
			case 5:
				System.out.println("종료");
				close(con);
			}
		}while(no != 5);
		
	}
}

package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBizImpl;
import com.dto.Member;

public class MemberView {
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select =0;
		
		System.out.println("**************");
		System.out.println("1. selectAll");
		System.out.println("2. selectOne");
		System.out.println("3. insert");
		System.out.println("4. update");
		System.out.println("5. delete");
		System.out.println("6. exit");

		System.out.print("input select:");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int select = 0;
		MemberBizImpl memberBiz = new MemberBizImpl();
		
		while(select != 6) {
			select = getMenu();
			
			switch(select) {
			case 1://전체출력
				List<Member> res = memberBiz.selectAll();
				
				for(Member m:res) {
					System.out.println(m);
				}
				break;
			case 2:
				System.out.print("번호 선택:");
				int n = sc.nextInt();
				Member resOne = memberBiz.selectOne(n);
				System.out.println(resOne);
			case 3:
			case 4:
			case 5:
			case 6:
				
			}
		}
	}

}

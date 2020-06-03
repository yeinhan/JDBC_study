package product.view;


import java.util.List;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.vo.Product;

public class ProductView {
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() {
		System.out.println("1.전체보기");
		System.out.println("2.선택보기");
		System.out.println("3.츄가");
		System.out.println("4.수정");
		System.out.println("5.삭제");
		System.out.println("6.종료");
		System.out.println("--------------");

		System.out.print("메뉴번호 입력:");
		int select = sc.nextInt();
		
		
		return select;
	}
	public ProductView() {
		int select =0;
		ProductController pc = new ProductController();
		
		while(select != 6){
			select= getMenu();
			switch(select) {
			case 1:	//��ü����
				List<Product> res = pc.selectAll();
				for(Product p:res) {
					System.out.println(p);
				}
				break;
			case 2:
				System.out.print("pid 입력:");
				String id = sc.next();
				
				Product resone = pc.selectOne(id);
				System.out.println(resone);
				break;
			case 3:
				System.out.print("pid 입력:");
				String pid = sc.next();
				System.out.print("pname 입력:");
				String pname = sc.next();
				System.out.print("price 입력:");
				int price = sc.nextInt();
				System.out.print("desc 입력:");
				String desc = sc.next();
				
				Product insert = new Product(pid, pname, price,desc);
				
				int resInsert = pc.insert(insert);
				if(resInsert>0) {
					System.out.println("insert 성공!!");
				}else {
					System.out.println("insert 실패");
				}
				break;
			case 4:
				System.out.println("****수정할 정보 입력****");
				System.out.print("id:");
				String uid=sc.next();
				System.out.print("price:");
				int uprice = sc.nextInt();
				
//				Product update = new Product();
//				update.setpId(uid);
//				update.setPrice(uprice);
				
//				Product update = new Product(uid,"",uprice,"");
				Product update = new Product(uid, uprice);
				
				int resUp = pc.update(update);
				if(resUp>0) {
					System.out.println("update 성공!!");
				}else {
					System.out.println("update 실패ㅠㅠ");
				}
				break;
			case 5:
				System.out.print("삭제할 id:");
				String did=sc.next();
				
				int resDel= pc.delete(did);
				
				if(resDel>0) {
					System.out.println("delete 성공!!");
				}else {
					System.out.println("delete 실패");
				}
				
			case 6:
				System.out.println("****종료*****");
				break;
			}
		}
		
	}
}

package model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import product.dao.ProductDao;
import product.model.vo.Product;

public class ProductService {
	
	public List<Product> selectAll(){
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		
		ArrayList<Product> res = dao.selectAll(con);
		
		close(con);
		return res;
	}


	public Product selectOne(String id) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		
		Product res = dao.selectOne(con,id);
		
		close(con);
		return res;
	}


	public int insert(Product insert) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		
		int res = dao.insert(con,insert);
		
		close(con);
		return res;
	}


	public int update(Product update) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		
		int res = dao.update(con, update);
		
		close(con);
		return res;
	}


	public int delete(String did) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		
		int res = dao.update(con, did);
		return res;
	}


	
}

package product.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import product.model.vo.Product;

public class ProductDao {
	private Properties prop;
	Scanner sc = new Scanner(System.in);
	
	public ProductDao() {
		
		try {
			prop = new Properties();
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> selectAll(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Product> list = null;
		String sql = prop.getProperty("selectALL");
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			list = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product();
				p.setpId(rs.getString(1));
				p.setpName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setDesc(rs.getString(4));
				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstm);
		}
		
		return list;
	}

	public Product selectOne(Connection con, String id) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Product res = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				res = new Product();
				res.setpId(rs.getString(1));
				res.setpName(rs.getString(2));
				res.setPrice(rs.getInt(3));
				res.setDesc(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		
		return res;
	}

	public int insert(Connection con, Product insert) {
		PreparedStatement pstm = null;
		int res =0;
		
		String sql = prop.getProperty("insert");
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, insert.getpId());
			pstm.setString(2, insert.getpName());
			pstm.setInt(3, insert.getPrice());
			pstm.setString(4, insert.getDesc());
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}

	public int update(Connection con, Product update) {
		PreparedStatement pstm = null;
		int res =0;
		
		String sql = prop.getProperty("update");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, update.getPrice());
			pstm.setString(2, update.getpId());
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}

	public int update(Connection con, String did) {
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = prop.getProperty("delete");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, did);
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		return res;
	}


}

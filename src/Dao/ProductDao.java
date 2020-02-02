package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Product;

public abstract class ProductDao  extends Dao<Product>{
	
	
	
	public static ResultSet productAll() {


		String sql ="select id , nom , price , path from product";

		ResultSet res = null;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
		}
		catch(SQLException ex) {

			ex.printStackTrace();
		}

		return res;

	}
	
	

	public static ResultSet catAll(String s) {


		String sql ="select id , nom , price , path from product where category = "+"'"+ s +"'";

		ResultSet res = null;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
		}
		catch(SQLException ex) {

			ex.printStackTrace();
		}

		return res;

	}
	
	
	public static ResultSet savePanier(int i ) {


		String sql ="select nom , price , category from product where id = "+"'"+ i +"'";

		ResultSet res = null;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
		}
		catch(SQLException ex) {

			ex.printStackTrace();
		}

		return res;

	}
	
	
	
	
	
	

}

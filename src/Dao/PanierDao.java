package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import beans.Panier;
import beans.User;



public abstract class PanierDao extends Dao<Panier> {
	
	

	public static ResultSet find(int s) {


		String sql ="select panierID, nom ,category , price from panier where personId = "+"'"+ s +"'";

		ResultSet res = null;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);

		}
		catch(SQLException ex) {

			ex.printStackTrace();
		}

		return res;
	}


	public static ResultSet findProdutId(int i ) {


		String sql =" select nom , price ,category from panier where panierId = "+"'" +i+ "'";
		ResultSet res = null;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);

		}
		catch(SQLException ex) {

			ex.printStackTrace();

		}

		return res;


	}
	/*
      panierID  | int(11)     | NO   | PRI | NULL    | auto_increment |
	| personID  | int(11)     | YES  | MUL | NULL    |                |
	| productID | int(11)     | YES  | MUL | NULL    |                |
	| category  | varchar(50) | YES  |     | NULL    |                |
	| price     | varchar(50) | YES  |     | NULL    |                |
	| nom  

	 */


	public static boolean save(int personid, int productid,String category , String price ,String nom ) {

		boolean alea = false; 

		String sql =  "insert  into panier ( personID ,productID  ,category,price,nom) values (?,?,?,?,?)";

		try {

			PreparedStatement result = conn.prepareStatement(sql);

			//result.setInt(1,panierid);

			result.setInt(1,personid);

			result.setInt(2,productid);
			
			result.setString(3,category);

			result.setString(4,price);

			result.setString(5,nom);

			result.execute();

			alea= true;

		} catch (SQLException e) {


			e.printStackTrace();
		}


		return alea;

	}

	
	public static boolean removeProduct(int ss ) {

		boolean test = false;

		String sql ="delete from panier where panierID = " +"'"+ss+"'";

		Statement statement = null;

		try {

			statement = conn.createStatement();

			statement.execute(sql);

			test= true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return test; 

	}


}

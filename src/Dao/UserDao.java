package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.User;

public abstract class UserDao extends Dao<User> {

	public static ResultSet  find() {


		String sql="select mail, password from user";

		ResultSet res = null;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);

		}
		catch(SQLException ex) {

			ex.printStackTrace();
		}

		return res;

	}


	public static boolean find(String mail,String password) {

		boolean alea = false;

		ResultSet res = find();

		try {

			while(res.next()) {

				if(mail.equals(res.getString("mail")) && password.equals (res.getString("password") )){

					alea = true;

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return alea ;


	}


	public static boolean save(String id ,String nom, String prenom,String mail ,String password ) {

		boolean alea = false; 

		String sql =  "insert  into user (id,nom,prenom ,mail,password) values (?,?,?,?,?)";

		try {

			PreparedStatement result = conn.prepareStatement(sql);

			result.setString(1,id);

			result.setString(2,nom);

			result.setString(3,prenom);

			result.setString(4,password);


			result.setString(5,password);

			result.executeUpdate();

			alea= true;

		} catch (SQLException e) {


			e.printStackTrace();
		}


		return alea;

	}

	public static String nom(String s) {


		String sql = "select nom from user where mail = "+"'"+s+"'";

		ResultSet res = null;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);

		}
		catch(SQLException ex) {

			ex.printStackTrace();
		}
		String ss ="";
		try {
			while (res.next()) {
				ss = res.getString("nom");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ss;

	}

	public static boolean updateNom(String s ,String ss ) {

		boolean test = false;

		String sql ="update user set nom = "+"'"+s+"'"+" where mail = "+"'"+ss+"'";

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
	public static boolean updatepass(String s ,String ss ) {

		boolean test = false;

		String sql ="update user set  password = "+"'"+s+"'"+" where mail = "+"'"+ss+"'";

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
	public static boolean updatemail(String s ,String ss ) {

		boolean test = false;

		String sql ="update user set mail = "+"'"+s+"'"+" where mail = "+"'"+ss+"'";

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
	public static boolean updateadresse(String s ,int ss ) {

		boolean test = false;

		String sql ="update user set adresse = "+"'"+s+"'"+" where id = "+"'"+ss+"'";

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


	public static int findId(String mail) {

		String sql = "select id from user where mail = "+"'"+mail+"'";

		ResultSet res = null;
		
		int s=0;

		try {	

			res = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);

		}
		catch(SQLException ex) {

			ex.printStackTrace();
		}
		

		try {

			while(res.next()) {

				s =res.getInt("id");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return s;

		
		
	

	}

}

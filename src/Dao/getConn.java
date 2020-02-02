package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class getConn {

	//	static String driver = "com.mysql.jdbc.Driver";
	private static  String url  = "jdbc:mysql://localhost/projet_web";
	private static  String user = "root";
	private static  String password = "root";
	private static Connection con;

	public  static Connection getConnection (){

		//  	Class.forName(driver);

		try {

			Class.forName("com.mysql.jdbc.Driver");

			return  con = DriverManager.getConnection(url,user,password);



		}  catch (Exception ex){

			ex.printStackTrace();

		}


		return  con;
	}



}

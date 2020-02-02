package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Commande;

public abstract class CommandeDao extends Dao<Commande> {


	/*
 +------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| commandeID | int(11)     | NO   | PRI | NULL    | auto_increment |
| personID   | int(11)     | YES  | MUL | NULL    |                |
| nom        | varchar(50) | YES  |     | NULL    |                |
| category   | varchar(50) | YES  |     | NULL    |                |
| price      | varchar(50) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+

	 */

	public static boolean save(int personid,String category , String price ,String nom ) {

		boolean alea = false; 



		String sql =  "insert  into commande ( personID,category,price,nom) values (?,?,?,?)";

		try {

			PreparedStatement result = conn.prepareStatement(sql);

			//result.setInt(1,panierid);

			result.setInt(1,personid);
		
			result.setString(2,category);

			result.setString(3,price);

			result.setString(4,nom);

			result.execute();

			alea= true;

		} catch (SQLException e) {


			e.printStackTrace();
		}


		return alea;

	}
}

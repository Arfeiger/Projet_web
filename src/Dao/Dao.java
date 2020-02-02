package Dao;

import java.sql.Connection;


public abstract class Dao <T> {

public static Connection conn = getConn.getConnection();


public abstract  T find (String s);




}

package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.PanierDao;
import Dao.ProductDao;
import Dao.UserDao;
import beans.Product;

/**
 * Servlet implementation class VetementServlet
 */
@WebServlet("/VetementServlet")
public class VetementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VetementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(false);

		String userName = (String) session.getAttribute("mail");


		int id = UserDao.findId(userName);

		int idproduct = 0 ;
		String nom ="";
		String prix="";
		String path="";


		ResultSet res = ProductDao.catAll("Vêtements, Chaussures, Bijoux");

		List <Product> l = new ArrayList<>();

		try {

			while (res.next()) {

				nom = res.getString("nom");

				prix = res.getString("price");

				idproduct = res.getInt("id");

				path = res.getString("path");

				Product p = new Product();

				p.setId(idproduct);

				p.setNom(nom);

				p.setPrice(prix);

				p.setPath(path);

				l.add(p);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("list", l);
		RequestDispatcher rd = request.getRequestDispatcher("/vetements.jsp");
		rd.forward(request,response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);


		String userName = (String) session.getAttribute("mail");


		int id = UserDao.findId(userName);


		String idproduct = request.getParameter("panier");

		//	int result = Integer.parseInt(idpro);			


		ResultSet res = ProductDao.savePanier(Integer.parseInt(idproduct));

		String nom="";
		String prix="";
		String category="";


		try {

			while (res.next()) {

				nom = res.getString("nom");

				prix = res.getString("price");

				category= res.getString("category");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		/*
	      panierID  | int(11)     | NO   | PRI | NULL    | auto_increment |
		| personID  | int(11)     | YES  | MUL | NULL    |                |
		| productID | int(11)     | YES  | MUL | NULL    |                |
		| category  | varchar(50) | YES  |     | NULL    |                |
		| price     | varchar(50) | YES  |     | NULL    |                |
		| nom       |             |      |     |         |                |
		 */


		if( request.getParameter("panier")!= null) {

			boolean alea = PanierDao.save( id, Integer.parseInt(idproduct),category, prix, nom);

			if(alea) {

		//		session.setAttribute("panierSucc","well done"); 

				response.sendRedirect("http://localhost:9080/projet_web/VetementServlet");


			}

		}




	}

}

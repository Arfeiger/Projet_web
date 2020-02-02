package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.PanierDao;
import beans.Panier;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/EncherirServlet")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EncherirServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(false);

		String montant = request.getParameter("montant");


		if (!test(montant) && montant!=null && !montant.equals("")) {

			request.setAttribute("chiffre","Veuillez entrer que des chiffres!!"); 
			RequestDispatcher rd = request.getRequestDispatcher("encherir.jsp");
			rd.forward(request,response);
		}

		if(montant ==null || montant.equals("")) {


			request.setAttribute("montantVide","Espace vide !!!!"); 
			RequestDispatcher rd = request.getRequestDispatcher("encherir.jsp");
			rd.forward(request,response);

		}

		String price = request.getParameter("encherirbutton");

		price = price.trim();

		double priceToInt =  Double.parseDouble(price);

		/*
		try{

			priceToInt =  Integer.parseInt(price);

		}catch(NumberFormatException ex){

			System.out.println("not a number" + ex);
		}

		 */
		double montantToInt = Integer.parseInt(montant);


		if( request.getParameter("encherirbutton") !=  null) {


			Random rand = new Random();

			double randomNum =(Math.random()*(( priceToInt-0)+1))+0;

			if( montantToInt<randomNum) {


				request.setAttribute("loose","Veuillez essayer une autre fois"); 
				RequestDispatcher rd = request.getRequestDispatcher("encherir.jsp");
				rd.forward(request,response);

			}

			else {


				request.setAttribute("winner","you win"); 
				RequestDispatcher rd = request.getRequestDispatcher("encherir.jsp");
				rd.forward(request,response);

			}

		}


		String id = request.getParameter("acheter");

		/*	if(request.getParameter("acheter") !=null ) {


			List <Panier> l = findList(id);

			session.setAttribute("produitEnch",l); 

			RequestDispatcher rd1 = request.getRequestDispatcher("acheter.jsp");
			rd1.forward(request,response);


		}*/

	}


	protected boolean test(String s) {
		try{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}


	protected List<Panier> findList(String i) {

		List <Panier> l = new ArrayList<>();

		String nom ="";
		String prix="";
		String category="";

		ResultSet res = PanierDao.findProdutId( Integer.parseInt(i));

		try {
			
			while (res.next()) {

				nom = res.getString("nom");

				prix = res.getString("price");

				category=res.getString("category");

				Panier p = new Panier(category, prix, nom);

				p.setCategory(category);

				p.setNom(nom);

				p.setPrice(prix);

				l.add(p);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}


		return l;


	}
}

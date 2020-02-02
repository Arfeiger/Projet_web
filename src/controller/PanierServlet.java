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


import Dao.UserDao;
import beans.Panier;
import Dao.PanierDao;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/PanierServlet")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PanierServlet() {
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


		String nom ="";
		String prix="";
		String category="";
		int idproduct = 100 ;


		ResultSet res = PanierDao.find(id);

		List <Panier> l = new ArrayList<>();


		try {

			while (res.next()) {

				nom = res.getString("nom");

				prix = res.getString("price");

				category=res.getString("category");

				idproduct = res.getInt("panierID");

				Panier p = new Panier(category, prix, nom);

				p.setCategory(category);

				p.setNom(nom);

				p.setPrice(prix);

				p.setPanierId(idproduct);

				l.add(p);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("list", l);


		RequestDispatcher rd = request.getRequestDispatcher("commandes.jsp");
		rd.forward(request,response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session=request.getSession(false);

		if(request.getParameter("acheter")!=null) {

			String i = request.getParameter("acheter");

			List <Panier> ll = findList(i);

			session.setAttribute("descProduit",ll); 
			RequestDispatcher rd1 = request.getRequestDispatcher("acheter.jsp");
			rd1.forward(request,response);


		}


		if(request.getParameter("encherir")!=null) {

			String i = request.getParameter("encherir");

			List <Panier> l = findList(i);

			session.setAttribute("descProduit",l); 

			RequestDispatcher rd1 = request.getRequestDispatcher("encherir.jsp");
			rd1.forward(request,response);


		}




		if(request.getParameter("supprimer") != null) {

			String d =	request.getParameter("supprimer");
			boolean res = PanierDao.removeProduct(Integer.parseInt(d));
			
			if(res) {

				request.setAttribute("deleteSuc", "ping");
			
				response.sendRedirect("http://localhost:9080/projet_web/PanierServlet");

			}


		}

	}

	protected List<Panier> findList(String i) {

		List <Panier> l = new ArrayList<>();

		String nom ="";
		String prix="";
		String category="";

		ResultSet res = PanierDao.findProdutId(Integer.parseInt(i));

		try {
			while (res.next()) {

				nom = res.getString("nom");

				prix = res.getString("price");

				category=res.getString("category");

				Panier p = new Panier(nom,prix,category);

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

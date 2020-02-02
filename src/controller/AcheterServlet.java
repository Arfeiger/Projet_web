package controller;

import java.io.IOException;
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


import Dao.CommandeDao;
/**
 * Servlet implementation class AcheterServlet
 */
@WebServlet("/AcheterServlet")
public class AcheterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcheterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*	HttpSession session=request.getSession(false);

		String id = (String) session.getAttribute("idproduit");

		int result = Integer.parseInt(id);

		String adre = request.getParameter("adresee");

		if(request.getParameter("ajouA")!=null) {


			if(adre == null || adre.equals("")) {


				request.setAttribute("adresseNull","well"); 

				RequestDispatcher rd = request.getRequestDispatcher("acheter.jsp");

				rd.forward(request,response);


			}

			else {

				boolean res = UserDao.updateadresse(adre, result);


				if(res) {

					request.setAttribute("adresseSuc","well"); 

					RequestDispatcher rd1 = request.getRequestDispatcher("acheter.jsp");

					rd1.forward(request,response);

				}

			}

		}

		RequestDispatcher rd2 = request.getRequestDispatcher("acheter.jsp");

		rd2.forward(request,response);

		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(false);

		String userName = (String) session.getAttribute("mail");

		int id = UserDao.findId(userName);


		if(request.getParameter("ajoutA")!= null) {

			String adre = request.getParameter("adresse");


			if(adre == null || adre.equals("") ) {


				request.setAttribute("adresseNull","well"); 

				RequestDispatcher rd = request.getRequestDispatcher("acheter.jsp");

				rd.forward(request,response);

			}

			else {

				boolean res = UserDao.updateadresse(adre, id);

				if(res) {

					request.setAttribute("adresseSuc","well"); 

					RequestDispatcher rd1 = request.getRequestDispatcher("acheter.jsp");

					rd1.forward(request,response);

				}

			}


		}

		if(request.getParameter("passer")!= null) {



			List <Panier> l = (List <Panier>)session.getAttribute("descProduit");

			boolean alea = CommandeDao.save(id,l.get(0).getCategory(), l.get(0).getPrice(),l.get(0).getNom());

			if(alea) {

				
				request.setAttribute("CommandeSuc","well"); 
				RequestDispatcher rd1 = request.getRequestDispatcher("acheter.jsp");

				rd1.forward(request,response);



			}

		}


	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServlet() {
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


		if(request.getParameter("compteExist")!= null){

			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

		String nom = request.getParameter("nom");

		String prenom = request.getParameter("prenom");

		String mail= request.getParameter("adresse");

		String password = request.getParameter("password");


		if((nom==null || prenom==null|| mail == null|| password == null )||( nom.equals("")|| password.equals("") || mail.equals("") || prenom.equals(""))) {

			request.setAttribute("loginVide","Espace vide !!!!"); 
			RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
			rd.forward(request,response);

		}

		else {

			boolean alea = UserDao.save(null,nom,prenom,mail,password);

			if(alea == true) {


				request.setAttribute("succes","well done"); 

				RequestDispatcher rd = request.getRequestDispatcher("create.jsp");

				rd.forward(request,response);

			}


		}

	}

}

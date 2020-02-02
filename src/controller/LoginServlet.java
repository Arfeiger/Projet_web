package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import Dao.UserDao;

/**
 * Servlet implementation class testservlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getParameter("Creer")!= null){

			request.getRequestDispatcher("create.jsp").forward(request, response);

		}

		String userName=request.getParameter("adresse");

		String password=request.getParameter("password");
		
		


		if((userName==null || password == null )|| userName.equals("")||password.equals(""))

		{

			request.setAttribute("loginVide","Espace vide !!!!"); 
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);

		}
		
		else {
			
			boolean alea = UserDao.find(userName, password);

			if(alea == true) {
				
				HttpSession session = request.getSession();
				
				session.setAttribute("mail", userName);
				
				String nom = UserDao.nom(userName);
				
				session.setAttribute("userSession", nom);
				
				session.setMaxInactiveInterval(30*60);

			//	RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				//rd.forward(request,response);
				
			    response.sendRedirect("http://localhost:9080/projet_web/mainServlet");

			}
			
			else
				
			{

				request.setAttribute("loginError","Compte introuvable"); 
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request,response);


			}
			
			
		}
	}



}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Dao.UserDao;

/**
 * Servlet implementation class profileServlet
 */
@WebServlet("/profileServlet")
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public profileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession(false);

		String userName = (String) session.getAttribute("mail");

		String nom = request.getParameter("nom");

		String mail = request.getParameter("mail");

		String pass = request.getParameter("pass");

		if(request.getParameter("nomMod")!= null ){


			boolean res = UserDao.updateNom(nom, userName);

			if(res) {

				request.setAttribute("changesuc","well done"); 

				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");

				rd.forward(request,response);

			}
		}

		if(request.getParameter("mailMod")!= null){

			boolean res = UserDao.updatemail(mail, userName);

			if(res) {


				request.setAttribute("changesuc","well done"); 

				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");

				rd.forward(request,response);

			}
		}

		if(request.getParameter("motMod")!= null){

			boolean res = UserDao.updatepass(pass, userName);

			if(res) {

				request.setAttribute("changesuc","well done"); 

				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");

				rd.forward(request,response);

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

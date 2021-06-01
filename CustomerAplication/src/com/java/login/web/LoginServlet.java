package com.java.login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.login.bean.LoginBean;
import com.java.login.database.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDao loginDao = new LoginDao();

		String userLoginId = request.getParameter("userLoginId");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUserLoginId(userLoginId);
		loginBean.setPassword(password);

		if (loginDao.validate(loginBean)) {
			response.sendRedirect("welcome.jsp");

		} else {
			// HttpSession session = request.getSession();
			response.sendRedirect("login.jsp");

		}

	}

}

package com.nankai.exchange.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nankai.exchange.dao.IUsersDao;
import com.nankai.exchange.dao.impl.UsersDaoImpl;
import com.nankai.exchange.po.Users;

/**
 * Servlet implementation class ChangeUserServlet
 */
public class ChangeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String cpwd = request.getParameter("cpwd");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String num = request.getParameter("num");
		String mail = request.getParameter("mail");
		
		HttpSession session = request.getSession();
		
		Users user = (Users) session.getAttribute("user");
		
		int msgcode = 0;
		String url = "";
		
		if(cpwd.equals(user.getUserpwd())) {
			if(pwd1.equals(pwd2)) {
				user.setUserpwd(pwd1);
				user.setUsernum(num);
				user.setUsermail(mail);
				
				session.setAttribute("user", user);
				IUsersDao usersDao = new UsersDaoImpl();
				usersDao.update(user);
				msgcode = 110;
				url = "jsp/Success.jsp";
			} else {
				msgcode = 111;
				url = "jsp/Error.jsp";
			}
		} else {
			msgcode = 112;
			url = "jsp/Error.jsp";
		}
		request.setAttribute("msgcode", msgcode);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}

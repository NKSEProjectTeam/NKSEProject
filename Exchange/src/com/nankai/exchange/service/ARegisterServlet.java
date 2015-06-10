package com.nankai.exchange.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.IUsersBiz;
import com.nankai.exchange.biz.impl.UsersBizImpl;
import com.nankai.exchange.po.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ARegisterServlet
 */
public class ARegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ARegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String user_info = request.getParameter("user_info");

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
				.create();
		Users user = gson.fromJson(user_info, Users.class);

		String username = user.getUsername();

		Users users = new Users();

		// -------------------婢跺嫮鎮婇弫鐗堝祦-----------------------
		IUsersBiz usersBiz = new UsersBizImpl();
		users = usersBiz.findByName(username);

		boolean registUser = usersBiz.addUser(user);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		if (users == null) {

			if (registUser == true) {

				PrintWriter out = response.getWriter();

				String registUserstate = "200";

				String gson_info = gson.toJson(registUserstate);

				System.out.println(gson_info);
				out.println(gson_info);

				out.flush();
				out.close();
			} else {
				PrintWriter out = response.getWriter();

				String registUserstate = "201";

				String gson_info = gson.toJson(registUserstate);

				System.out.println(gson_info);
				out.println(gson_info);

				out.flush();
				out.close();
			}

		} else {

			PrintWriter out = response.getWriter();
			String registUserstate = "202";
			String gson_info = gson.toJson(registUserstate);

			System.out.println(gson_info);
			out.println(gson_info);

			out.flush();
			out.close();
		}
	}

}

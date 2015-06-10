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
 * Servlet implementation class ALoginServlet
 */
public class ALoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ALoginServlet() {
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
		
		String user_data = request.getParameter("user_data");
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
		Users user = gson.fromJson(user_data, Users.class);
		
		String username = user.getUsername();
		
		IUsersBiz usersBiz = new UsersBizImpl();
		Users tuser = usersBiz.findByName(username);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(tuser != null) {
			if(!tuser.getUserpwd().equals(user.getUserpwd())) {
				tuser = null;
			}
		}
		String gson_data = gson.toJson(tuser);
		out.println(gson_data);
		
		out.flush();
		out.close();
	}

}

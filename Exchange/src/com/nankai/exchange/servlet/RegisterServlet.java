package com.nankai.exchange.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.IUsersBiz;
import com.nankai.exchange.biz.impl.UsersBizImpl;
import com.nankai.exchange.po.Users;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		// 设置request字符集
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String userpwd2 = request.getParameter("userpwd2");
		String usernum = request.getParameter("usernum");
		String usermail = request.getParameter("usermail");
		int sex = Integer.parseInt(request.getParameter("sex"));
		
		IUsersBiz usersBiz = new UsersBizImpl();
		Users tuser = usersBiz.findByName(username);
		
		// 105-用户已经存在、106-注册成功、107-注册失败、108-密码项错误
		int msgcode = 0;
		String url;
		
		if(tuser != null) {
			System.out.println("用户已经存在");
			msgcode = 105;
			request.setAttribute("msgcode", msgcode);
			url = "jsp/Error.jsp";
		} else {
			if(userpwd != null && userpwd2 != null && userpwd.equals(userpwd2)) {
				Users user = new Users();
				user.setUsername(username);
				user.setUserpwd(userpwd);
				user.setUsernum(usernum);
				user.setUsermail(usermail);
				user.setSex(sex);
				if(usersBiz.addUser(user)) {
					System.out.println("注册成功");
					msgcode = 106;
					request.setAttribute("msgcode", msgcode);
					url = "jsp/Success.jsp";
				} else {
					System.out.println("注册失败");
					msgcode = 107;
					request.setAttribute("msgcode", msgcode);
					url = "jsp/Error.jsp";
				}
			} else {
				System.out.println("密码项错误");
				msgcode = 108;
				request.setAttribute("msgcode", msgcode);
				url = "jsp/Error.jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

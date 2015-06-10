package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nankai.exchange.biz.IUsersBiz;
import com.nankai.exchange.biz.IWaitCfmBiz;
import com.nankai.exchange.biz.impl.UsersBizImpl;
import com.nankai.exchange.biz.impl.WaitCfmBizImpl;
import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.WaitOrder;

/**
 * Servlet implementation class LoginServlet
 */
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
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username").trim();
		String userpwd = request.getParameter("userpwd").trim();
		
		IUsersBiz usersBiz = new UsersBizImpl();
		Users user = usersBiz.findByName(username);
		
		// msgcode : 101-用户不存在、102-用户存在密码未验证、103-认证成功、104-密码不正确
		int msgcode = user == null ? 101 : 102;
		if(msgcode == 102) {
			msgcode = user.getUserpwd().equals(userpwd) ? 103 : 104;
		}
		
		String url = "";
		switch (msgcode) {
		case 101:
			url = "jsp/Error.jsp";
			request.setAttribute("msgcode", msgcode);
			break;
		case 103:
			url = "jsp/Success.jsp";
			request.setAttribute("msgcode", msgcode);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			IWaitCfmBiz waitCfmBiz = new WaitCfmBizImpl();
			List<WaitOrder> lstWO = waitCfmBiz.findWaitCfm(user);
			
			//System.out.println("lstWO.size():>" + lstWO.size());
			
			int woLen = lstWO.size();
			session.setAttribute("woLen", woLen);
			session.setAttribute("lstWO", lstWO);
			
			break;
		case 104:
			url = "jsp/Error.jsp";
			request.setAttribute("msgcode", msgcode);
			break;
		default:
			break;
		}
		
		//System.out.println(url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

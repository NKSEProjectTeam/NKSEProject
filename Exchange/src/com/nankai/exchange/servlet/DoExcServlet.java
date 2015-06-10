package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nankai.exchange.biz.IFindMsgBiz;
import com.nankai.exchange.biz.impl.FindMsgBizImpl;
import com.nankai.exchange.po.Msg;
import com.nankai.exchange.po.Users;

/**
 * Servlet implementation class DoExcServlet
 */
public class DoExcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoExcServlet() {
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
		
		HttpSession session = request.getSession();
		
		Users user = (Users) session.getAttribute("user");
		
		String typeid1 = request.getParameter("typeid1");
		int typeid2 = Integer.parseInt(request.getParameter("typeid2"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		String resource = user.getResource();
		
		IFindMsgBiz findMsgBiz = new FindMsgBizImpl();
		List<Msg> lstMsg = findMsgBiz.findAllMsgs(resource);
		
		for(Msg msg : lstMsg) {
			System.out.println(msg);
		}
		if(!lstMsg.isEmpty()) {
			request.setAttribute("lstMsg", lstMsg);
		}
		request.setAttribute("typeid1", typeid1);
		request.setAttribute("typeid2", typeid2);
		request.setAttribute("uid", uid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/choose.jsp");
		dispatcher.forward(request, response);
	}

}

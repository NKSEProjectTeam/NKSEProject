package com.nankai.exchange.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nankai.exchange.biz.IConfirmBiz;
import com.nankai.exchange.biz.impl.ConfirmBizImpl;
import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.WaitOrder;

/**
 * Servlet implementation class ConfirmServlet
 */
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
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
		
		@SuppressWarnings("unchecked")
		List<WaitOrder> lstWO = (List<WaitOrder>) session.getAttribute("lstWO"); 
		
		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("type:>" + type);
		System.out.println("id:>" + id);
		
		WaitOrder waitOrder = null;
		for(int i = 0; i < lstWO.size(); i++) {
			if(lstWO.get(i).getBid() == id) {
				waitOrder = lstWO.get(i);
				break;
			}
		}
		
		System.out.println("lstWO:>" + waitOrder);
		
		IConfirmBiz confirmBiz = new ConfirmBizImpl();
		confirmBiz.confirm(waitOrder, user, type);
		
		lstWO.remove(waitOrder);
		
		response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        out.println("<response>");
        if(type.equals("agree")) {
        	out.println("<res>" + "yes" + "</res>");
        } else {
        	out.println("<res>" + "no" + "</res>");
        }
        out.println("</response>");
        out.close();
		
	}

}

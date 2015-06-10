package com.nankai.exchange.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nankai.exchange.biz.IDetailBiz;
import com.nankai.exchange.biz.impl.DetailBizImpl;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		
		HttpSession session = request.getSession();
		
		session.setAttribute("typeid1", "audios");
		session.setAttribute("typeid2", 2);
		
		String typeid1 = (String) request.getParameter("typeid1");
		int typeid2 = Integer.parseInt(request.getParameter("typeid2").toString());
		
		//String typeid1 = (String) session.getAttribute("typeid1");
		//int typeid2 = Integer.parseInt(session.getAttribute("typeid2").toString());
		
		IDetailBiz detailBiz = new DetailBizImpl();
		
		Object[] aobj = detailBiz.findItem(typeid1, typeid2);
		
		switch (typeid1) {
		case "textbooks":
			request.setAttribute("tb", aobj[0]);
			break;
		case "extrabooks":
			request.setAttribute("eb", aobj[0]);
			break;
		case "audios":
			request.setAttribute("audio", aobj[0]);
			break;
		case "bags":
			request.setAttribute("bag", aobj[0]);
			break;
		case "cosmetics":
			request.setAttribute("cos", aobj[0]);
			break;
		case "dailypros":
			request.setAttribute("dp", aobj[0]);
			break;
		case "decorations":
			request.setAttribute("dec", aobj[0]);
			break;
		case "digits":
			request.setAttribute("digit", aobj[0]);
			break;
		case "electrics":
			request.setAttribute("ele", aobj[0]);
			break;
		case "entertainments":
			request.setAttribute("enter", aobj[0]);
			break;
		case "females":
			request.setAttribute("female", aobj[0]);
			break;
		case "instruments":
			request.setAttribute("instrument", aobj[0]);
			break;
		case "males":
			request.setAttribute("male", aobj[0]);
			break;
		case "others":
			request.setAttribute("other", aobj[0]);
			break;
		case "pc":
			request.setAttribute("pc", aobj[0]);
			break;
		case "phones":
			request.setAttribute("phone", aobj[0]);
			break;
		case "sppros":
			request.setAttribute("sp", aobj[0]);
			break;
		case "sptasts":
			request.setAttribute("sa", aobj[0]);
			break;
		case "spteqpts":
			request.setAttribute("se", aobj[0]);
			break;
		case "virtuals":
			request.setAttribute("virtual", aobj[0]);
			break;
		}
		
		request.setAttribute("user", aobj[1]);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/detail.jsp");
		dispatcher.forward(request, response);
		
	}

}

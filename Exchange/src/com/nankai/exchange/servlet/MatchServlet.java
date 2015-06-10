package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.IMatchBiz;
import com.nankai.exchange.biz.impl.MatchBizImpl;

/**
 * Servlet implementation class MatchServlet
 */
public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchServlet() {
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
		
		String sexc = (String)request.getAttribute("sexc");
		String iexcthing = (String)request.getAttribute("iexcthing");
		
		IMatchBiz matchBiz = new MatchBizImpl();
		List<List<?>> lstItems = matchBiz.findMatch(sexc, iexcthing);
		for(List<?> lst : lstItems) {
			for(Object obj : lst) {
				System.out.println(obj);
			}
		}
		
		String msg = "";
		
		switch(sexc) {
		case "books":
			msg = "textbooks//extrabooks//audios";
			break;
		case "eles":
			msg = "pc//phones//digits";
			break;
		case "spts":
			msg = "sptasts//spteqpts";
			break;
		case "lifes":
			msg = "dailypros//electrics//entertainments//cosmetics//sppros";
			break;
		case "clothes":
			msg = "females//males";
			break;
		case "decs":
			msg = "decorations";
			break;
		case "bags":
			msg = "bags";
			break;
		case "ins":
			msg = "instruments";
			break;
		case "vis":
			msg = "virtuals";
			break;
		case "others":
			msg = "others";
			break;
		}
		
		String[] types = msg.split("//");
		
		request.setAttribute("types", types);
		request.setAttribute("lstItems", lstItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/match.jsp");
		dispatcher.forward(request, response);
	}

}

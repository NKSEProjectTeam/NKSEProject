package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.IFindExchangeBiz;
import com.nankai.exchange.biz.IFindHireBiz;
import com.nankai.exchange.biz.IFindRequestBiz;
import com.nankai.exchange.biz.impl.FindExchangeBizImpl;
import com.nankai.exchange.biz.impl.FindHireBizImpl;
import com.nankai.exchange.biz.impl.FindRequestBizImpl;

/**
 * Servlet implementation class NewServlet
 */
public class FindStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStateServlet() {
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
		//System.out.println("yes");
		int state=Integer.parseInt(request.getParameter("state"));
		List<List<?>> lstStateZero = null;
		String msg = "textbooks//extrabooks//pc//phones//bags//female";
		String[] types = msg.split("//");
		String url = "";
		switch (state) {
		case 0:
			IFindExchangeBiz findExchangeBiz = new FindExchangeBizImpl();
			lstStateZero = findExchangeBiz.findExchangeState(msg);
			url = "jsp/exchangepros.jsp";
			break;
		case 1:
			IFindHireBiz findHireBiz = new FindHireBizImpl();
			lstStateZero = findHireBiz.findHireState(msg);
			url = "jsp/hirepros.jsp";
			break;
		case 2:
			IFindRequestBiz findRequestBiz = new FindRequestBizImpl();
			lstStateZero = findRequestBiz.findRequestState(msg);
			url = "jsp/helppros.jsp";
			break;

		default:
			break;
		}
		// 鍥句功銆佺數瀛愪骇鍝併�浣撹偛鐢ㄥ搧銆佺敓娲汇�鏈嶉グ銆佷箰鍣ㄣ�铏氭嫙浜у搧銆佸叾浠�
		
		request.setAttribute("types", types);
		request.setAttribute("lstGoods",lstStateZero );
		for(List<?> lst : lstStateZero) {
			for(Object object : lst) {
				System.out.println(object);
			}
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

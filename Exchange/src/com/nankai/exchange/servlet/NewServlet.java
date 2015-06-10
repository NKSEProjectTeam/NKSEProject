package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.INewBiz;
import com.nankai.exchange.biz.impl.NewBizImpl;

/**
 * Servlet implementation class NewServlet
 */
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
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
		
		// 图书、电子产品、体育用品、生活、服饰、乐器、虚拟产品、其他
		String msg = "textbooks//extrabooks//phones//females";
		String[] types = msg.split("//");
		INewBiz newBiz = new NewBizImpl();
		List<List<?>> lstGoods = newBiz.findNew(msg, 8);
		
		request.setAttribute("types", types);
		request.setAttribute("lstGoods", lstGoods);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/newpros.jsp");
		dispatcher.forward(request, response);
	}

}

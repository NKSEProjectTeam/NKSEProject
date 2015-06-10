package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.ISearchProductsBiz;
import com.nankai.exchange.biz.impl.SearchProductsBizImpl;

/**
 * Servlet implementation class SearchProductsServlet
 */
public class SearchProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		//根据编码方式进行转吗
		if(name.equals(new String(name.getBytes("iso8859-1"),"iso8859-1"))) {
			name = new String(name.getBytes("iso8859-1"), "UTF-8");
		}
//		System.out.println("name is 1: " + name);
		String sid = request.getParameter("select2");
		int id = Integer.parseInt(sid);
		int intPage = Integer.parseInt(request.getParameter("intPage")); //当前页
		
		if (name.isEmpty() == true ||name.equals("请输入商品名")) {
//			System.out.println("name is 2: " + name);
			request.setAttribute("msgcode", 101);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/list.jsp");
			dispatcher.forward(request, response);
		} else {
			ISearchProductsBiz searchProductsBiz = new SearchProductsBizImpl();
			List<?> lstProducts = searchProductsBiz.searchProductsByName(name, id);
			
			if (lstProducts.isEmpty() == true) {
				response.sendRedirect("jsp/404.html");
			} else {
				int intCount = lstProducts.size();//商品总数
				int intPageSize = 9;//每页显示商品数
				int intPageCount = (intCount+intPageSize-1) / intPageSize; //总页数	
				//分页，每次显示10页
				List<Integer> lstPage = new ArrayList<Integer>();
				int start = 1;
				if ((intPage+1) >= 3) {
					start = (intPage+1)/3 * 3 - 1;
				}
				int num = start;
				while (!(num > intPageCount || num > start+2 )) {
					lstPage.add(new Integer(num));
					num++;
				}
				
				request.setAttribute("lstPage", lstPage);
				request.setAttribute("intCount", intCount);
				request.setAttribute("intPageSize", intPageSize);
				request.setAttribute("intPageCount", intPageCount);
				request.setAttribute("intPage", intPage);
				
				request.setAttribute("id", sid);
				request.setAttribute("name", name);
				request.setAttribute("msgcode", null);
				request.setAttribute("lstProducts", lstProducts);
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/list.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}
}















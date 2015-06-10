package com.nankai.exchange.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.ISearchProductsBiz;
import com.nankai.exchange.biz.impl.SearchProductsBizImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ASearchProductsServlet
 */
public class ASearchProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ASearchProductsServlet() {
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
		//---------------------接收数据---------------------------------
		//String name = "java";
		//int id = 19;
		//int firstItemId = 3;
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		// 获取终端传入的JSon数据
		String firstId = request.getParameter("firstId_data");
		String name = request.getParameter("name_data");
		String id = request.getParameter("id_data");
		// 反序列化
		
		int firstItemId = gson.fromJson(firstId, int.class);
		String itemName = gson.fromJson(name, String.class);
		int itemId = gson.fromJson(id, int.class);
		
		System.out.println("itemId:>" + itemId);
		//根据编码方式进行转码
		if(name.equals(new String(name.getBytes("iso8859-1"),"iso8859-1"))) {
			name = new String(name.getBytes("iso8859-1"), "UTF-8");
		}
		
		//----------------------查询处理数据-----------------------------
		ISearchProductsBiz searchProductsBiz = new SearchProductsBizImpl();
		List<?> lstProducts = searchProductsBiz.searchProductsByName(itemName, itemId);
		
		if (lstProducts.isEmpty() == true) {
			//查无商品,101
			String gson_data = gson.toJson("101");
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(gson_data);			
			out.flush();
			out.close();
		} else {
			//将十件商品封装到一个list
			if(lstProducts.size() - firstItemId >= 10) {
				lstProducts = lstProducts.subList(firstItemId, firstItemId + 10);
			} else {
				lstProducts = lstProducts.subList(firstItemId, lstProducts.size());
			}
			
			/*List<Object> lstItems = new ArrayList<Object>();
			for (int i = firstItemId; i < firstItemId+10; i++) {
				if (i >= lstProducts.size()-1) {
					break;
				} else {
					lstItems.add(lstProducts.get(i));
					System.out.println(i);
					System.out.println(lstProducts.get(i));
				}
			}*/
			System.out.println(lstProducts.toString());
			
			//---------------------------发送数据-----------------------------------
			String gson_data = gson.toJson(lstProducts);
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(gson_data);			
			out.flush();
			out.close();
		}
		
	}

}

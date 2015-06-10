package com.nankai.exchange.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;


/**
 * Servlet implementation class AUploadImgServlet
 */
public class AUploadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AUploadImgServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String temp = this.getServletContext().getRealPath("/tempDir");
		File fileUploadTempPath = new File(temp);
		if (!fileUploadTempPath.exists()) {
			// 创建一个全新的
			fileUploadTempPath.mkdir();
		}
		
		System.out.println("temp:>" + temp);
		String loadpath = this.getServletContext().getRealPath(
				"/upload/goodsimg");
		System.out.println("loadpath:>" + loadpath);
		@SuppressWarnings("deprecation")
		DiskFileUpload fu = new DiskFileUpload();
		fu.setSizeMax(2 * 1024 * 1024);
		fu.setSizeThreshold(4096);
		fu.setRepositoryPath(temp);
		int index = 0;

		List fileItems = null;

		try {
			fileItems = fu.parseRequest(request);
			System.out.println("fileItems=" + fileItems);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Iterator iter = fileItems.iterator(); // 依次处理每个上传的文件
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();// 忽略其他不是文件域的所有表单信息
			if (!item.isFormField()) {
				String name = item.getName();// 获取上传文件名,包括路径
				name = name.substring(name.lastIndexOf("\\") + 1);// 从全路径中提取文件名
				long size = item.getSize();
				if ((name == null || name.equals("")) && size == 0)
					continue;
				int point = name.indexOf(".");
				name = (new Date()).getTime()
						+ name.substring(point, name.length());
				index++;
				File fNew = new File(loadpath, name);
				try {
					item.write(fNew);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else// 取出不是文件域的所有表单信息
			{
				String fieldvalue = item.getString();
				// 如果包含中文应写为：(转为UTF-8编码)
				// String fieldvalue = new
				// String(item.getString().getBytes(),"UTF-8");
			}
		}
	}

}

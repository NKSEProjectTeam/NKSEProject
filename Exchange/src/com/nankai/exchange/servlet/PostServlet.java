package com.nankai.exchange.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nankai.exchange.biz.IPostBiz;
import com.nankai.exchange.biz.impl.PostBizImpl;
import com.nankai.exchange.po.Audios;
import com.nankai.exchange.po.Bags;
import com.nankai.exchange.po.Cosmetics;
import com.nankai.exchange.po.Dailypros;
import com.nankai.exchange.po.Decorations;
import com.nankai.exchange.po.Digits;
import com.nankai.exchange.po.Electrics;
import com.nankai.exchange.po.Entertainments;
import com.nankai.exchange.po.Extrabooks;
import com.nankai.exchange.po.Females;
import com.nankai.exchange.po.Instruments;
import com.nankai.exchange.po.Males;
import com.nankai.exchange.po.Others;
import com.nankai.exchange.po.Pc;
import com.nankai.exchange.po.Phones;
import com.nankai.exchange.po.Sppros;
import com.nankai.exchange.po.Sptasts;
import com.nankai.exchange.po.Spteqpts;
import com.nankai.exchange.po.Textbooks;
import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.Virtuals;

/**
 * Servlet implementation class PostServlet
 */
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		//request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		Users user = (Users) session.getAttribute("user");
		
		// 步骤1：设置上传文件的参数
		// 1-1：设置服务器接受上传文件的位置（服务器的文件夹）
		String fileUploadPath = this.getServletContext().getRealPath("/upload/goodsimg");
		System.out.println("[FileUpload] 设置服务器接受客户端上传文件的位置是：" + fileUploadPath);
		// 1-2：设置服务器临时缓冲区的位置（临时缓冲的文件夹）
		File fileUploadTempPath = new File(this.getServletContext().getRealPath("/tempDir"));
		if (!fileUploadTempPath.exists()) {
			// 创建一个全新的
			fileUploadTempPath.mkdir();
		}
		System.out.println("[FileUpload] 设置服务器接受客户端上传文件的临时位置是：" + fileUploadTempPath.getPath());
		
		String[] attributes;
		RequestDispatcher dispatcher;
		IPostBiz postBiz = new PostBizImpl();
		
		// 步骤2：判断表单是否符合上传要求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			// 步骤3：设置文件上传缓冲区对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 3-1:缓冲区对象与磁盘物理位置的绑定
			factory.setRepository(fileUploadTempPath);
			// 3-2：设置缓冲区对象的大小（4*1024 字节）
			factory.setSizeThreshold(4 * 1024);
			System.out.println("[FileUpload] 初始化服务器接受客户端上传文件的临时位置完毕！");

			// 步骤4：解析客户端表单待上传的数据
			// 4-1:创建一个ServletFileUpload对象完成对二进制表单数据的解析，并实现服务器上传功能
			ServletFileUpload sfu = new ServletFileUpload(factory);
			
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> fileItems = sfu.parseRequest(request);
				
				String type = fileItems.get(0).getString();
				System.out.println("type:>" + type);
				
				switch (type) {
				case "textbooks":
					attributes = new String[9];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 5) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName().trim();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}
					
					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
						//System.out.println(attributes[i]);
					}
					
					Textbooks textbooks = new Textbooks();
					textbooks.setUid(user.getUserid());
					textbooks.setTbstate(Integer.parseInt(attributes[0]));
					textbooks.setTbname(attributes[1]);
					textbooks.setTbauthor(attributes[2]);
					textbooks.setTbpublish(attributes[3]);
					textbooks.setTbversion(attributes[4]);
					textbooks.setTbresource(attributes[5]);
					textbooks.setTbmark(attributes[7] + "<&>" + attributes[8] + "<&>" + attributes[6]);
					
					postBiz.addPost(type, textbooks, user);
					
					request.setAttribute("sexc", attributes[7]);
					request.setAttribute("iexcthing", attributes[8]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.jsp");
					break;
				case "extrabooks":
					attributes = new String[8];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 4) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}
					
					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Extrabooks extrabooks = new Extrabooks();
					extrabooks.setUid(user.getUserid());
					extrabooks.setEbstate(Integer.parseInt(attributes[0]));
					extrabooks.setEbname(attributes[1]);
					extrabooks.setEbauthor(attributes[2]);
					extrabooks.setEbpublish(attributes[3]);
					extrabooks.setEbresource(attributes[4]);
					extrabooks.setEbmark(attributes[6] + "<&>" + attributes[7] + "<&>" + attributes[5]);
					
					postBiz.addPost(type, extrabooks, user);
					
					request.setAttribute("sexc", attributes[6]);
					request.setAttribute("iexcthing", attributes[7]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "audios":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Audios audios = new Audios();
					audios.setUid(user.getUserid());
					audios.setAudiostate(Integer.parseInt(attributes[0]));
					audios.setAudioname(attributes[1]);
					audios.setAudiopublish(attributes[2]);
					audios.setAudioresource(attributes[3]);
					audios.setAudiomark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, audios, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "bags":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Bags bags = new Bags();
					bags.setUid(user.getUserid());
					bags.setBagstate(Integer.parseInt(attributes[0]));
					bags.setBagbrand(attributes[1]);
					bags.setBagtype(attributes[2]);
					bags.setBagresource(attributes[3]);
					bags.setBagmark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, bags, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "cosmetics":
					attributes = new String[8];
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 4) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Cosmetics cosmetics = new Cosmetics();
					cosmetics.setUid(user.getUserid());
					cosmetics.setCosstate(Integer.parseInt(attributes[0]));
					cosmetics.setCosname(attributes[1]);
					cosmetics.setCosbrand(attributes[2]);
					cosmetics.setCostype(attributes[3]);
					cosmetics.setCosresource(attributes[4]);
					cosmetics.setCosmark(attributes[6] + "<&>" + attributes[7] + "<&>" + attributes[5]);
					
					postBiz.addPost(type, cosmetics, user);
					
					request.setAttribute("sexc", attributes[6]);
					request.setAttribute("iexcthing", attributes[7]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "dailypros":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Dailypros dailypros = new Dailypros();
					dailypros.setUid(user.getUserid());
					dailypros.setDpstate(Integer.parseInt(attributes[0]));
					dailypros.setDpname(attributes[1]);
					dailypros.setDptype(attributes[2]);
					dailypros.setDpresource(attributes[3]);
					dailypros.setDpmark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, dailypros, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "decorations":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Decorations decorations = new Decorations();
					decorations.setUid(user.getUserid());
					decorations.setDecstate(Integer.parseInt(attributes[0]));
					decorations.setDecname(attributes[1]);
					decorations.setDectype(attributes[2]);
					decorations.setDecresource(attributes[3]);
					decorations.setDecmark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, decorations, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "digits":
					attributes = new String[8];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 4) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Digits digits = new Digits();
					digits.setUid(user.getUserid());
					digits.setDigitstate(Integer.parseInt(attributes[0]));
					digits.setDigitbrand(attributes[1]);
					digits.setDigitmodel(attributes[2]);
					digits.setDigittype(attributes[3]);
					digits.setDigitresource(attributes[4]);
					digits.setDigitmark(attributes[6] + "<&>" + attributes[7] + "<&>" + attributes[5]);
					
					postBiz.addPost(type, digits, user);
					
					request.setAttribute("sexc", attributes[6]);
					request.setAttribute("iexcthing", attributes[7]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "electrics":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Electrics electrics = new Electrics();
					electrics.setUid(user.getUserid());
					electrics.setElestate(Integer.parseInt(attributes[0]));
					electrics.setElename(attributes[1]);
					electrics.setEletype(attributes[2]);
					electrics.setEleresource(attributes[3]);
					electrics.setElemark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, electrics, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "entertainments":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Entertainments entertainments = new Entertainments();
					entertainments.setUid(user.getUserid());
					entertainments.setEnterstate(Integer.parseInt(attributes[0]));
					entertainments.setEntername(attributes[1]);
					entertainments.setEntertype(attributes[2]);
					entertainments.setEnterresource(attributes[3]);
					entertainments.setEntermark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, entertainments, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "females":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Females females = new Females();
					females.setUid(user.getUserid());
					females.setFemalestate(Integer.parseInt(attributes[0]));
					females.setFemaletype(attributes[1]);
					females.setFemalesize(attributes[2]);
					females.setFemaleresource(attributes[3]);
					females.setFemalemark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, females, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "instruments":
					attributes = new String[8];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 4) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Instruments instruments = new Instruments();
					instruments.setUid(user.getUserid());
					instruments.setInstrumentstate(Integer.parseInt(attributes[0]));
					instruments.setInstrumentname(attributes[1]);
					instruments.setInstrumentbrand(attributes[2]);
					instruments.setInstrumenttype(attributes[3]);
					instruments.setInstrumentresource(attributes[4]);
					instruments.setInstrumentmark(attributes[6] + "<&>" + attributes[7] + "<&>" + attributes[5]);
					
					postBiz.addPost(type, instruments, user);
					
					request.setAttribute("sexc", attributes[6]);
					request.setAttribute("iexcthing", attributes[7]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "males":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Males males = new Males();
					males.setUid(user.getUserid());
					males.setMalestate(Integer.parseInt(attributes[0]));
					males.setMaletype(attributes[1]);
					males.setMalesize(attributes[2]);
					males.setMaleresource(attributes[3]);
					males.setMalemark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, males, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "others":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Others others = new Others();
					others.setUid(user.getUserid());
					others.setOthersstate(Integer.parseInt(attributes[0]));
					others.setOthersname(attributes[1]);
					others.setOthertype(attributes[2]);
					others.setOtherresource(attributes[3]);
					others.setOthermark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, others, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "pc":
					attributes = new String[8];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 4) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Pc pc = new Pc();
					pc.setUid(user.getUserid());
					pc.setPcstate(Integer.parseInt(attributes[0]));
					pc.setPcbrand(attributes[1]);
					pc.setPcmodel(attributes[2]);
					pc.setPctype(attributes[3]);
					pc.setPcresource(attributes[4]);
					pc.setPcmark(attributes[6] + "<&>" + attributes[7] + "<&>" + attributes[5]);
					
					postBiz.addPost(type, pc, user);
					
					request.setAttribute("sexc", attributes[6]);
					request.setAttribute("iexcthing", attributes[7]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "phones":
					attributes = new String[8];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 4) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Phones phones = new Phones();
					phones.setUid(user.getUserid());
					phones.setPhonestate(Integer.parseInt(attributes[0]));
					phones.setPhonebrand(attributes[1]);
					phones.setPhonemodel(attributes[2]);
					phones.setPhonetype(attributes[3]);
					phones.setPhoneresource(attributes[4]);
					phones.setPhonemark(attributes[6] + "<&>" + attributes[7] + "<&>" + attributes[5]);
					
					postBiz.addPost(type, phones, user);
					
					request.setAttribute("sexc", attributes[6]);
					request.setAttribute("iexcthing", attributes[7]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "sppros":
					attributes = new String[8];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 4) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Sppros sppros = new Sppros();
					sppros.setUid(user.getUserid());
					sppros.setSpstate(Integer.parseInt(attributes[0]));
					sppros.setSpname(attributes[1]);
					sppros.setSplocation(attributes[2]);
					sppros.setSptype(attributes[3]);
					sppros.setSpresource(attributes[4]);
					sppros.setSpmark(attributes[6] + "<&>" + attributes[7] + "<&>" + attributes[5]);
					
					postBiz.addPost(type, sppros, user);
					
					request.setAttribute("sexc", attributes[6]);
					request.setAttribute("iexcthing", attributes[7]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "sptasts":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Sptasts sptasts = new Sptasts();
					sptasts.setUid(user.getUserid());
					sptasts.setSastate(Integer.parseInt(attributes[0]));
					sptasts.setSaname(attributes[1]);
					sptasts.setSatype(attributes[2]);
					sptasts.setSaresource(attributes[3]);
					sptasts.setSamark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, sptasts, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "spteqpts":
					attributes = new String[7];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 3) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Spteqpts spteqpts = new Spteqpts();
					spteqpts.setUid(user.getUserid());
					spteqpts.setSestate(Integer.parseInt(attributes[0]));
					spteqpts.setSename(attributes[1]);
					spteqpts.setSetype(attributes[2]);
					spteqpts.setSeresource(attributes[3]);
					spteqpts.setSemark(attributes[5] + "<&>" + attributes[6] + "<&>" + attributes[4]);
					
					postBiz.addPost(type, spteqpts, user);
					
					request.setAttribute("sexc", attributes[5]);
					request.setAttribute("iexcthing", attributes[6]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.html");
					break;
				case "virtuals":
					attributes = new String[6];
					
					for(int cnt = 0; cnt < attributes.length; cnt++) {
						if(cnt != 2) {
							attributes[cnt] = fileItems.get(cnt + 1).getString();
							//System.out.println(attributes[cnt]);
						} else {
							String fileName = fileItems.get(cnt + 1).getName();
							String fileExtName = fileName.substring(fileName.lastIndexOf("."));
							attributes[cnt] = generateUnqieName() + fileExtName;
							File saveFile = new File(fileUploadPath, attributes[cnt]);
							fileItems.get(cnt + 1).write(saveFile);
							System.out.println("[FileUpload] 上传文件成功！");
						}
					}

					for(int i = 0; i < attributes.length; i++) {
						attributes[i] = new String(attributes[i].getBytes("iso8859-1"), "UTF-8");
					}
					
					Virtuals virtuals = new Virtuals();
					virtuals.setUid(user.getUserid());
					virtuals.setVirtualstate(Integer.parseInt(attributes[0]));
					virtuals.setVirtualname(attributes[1]);
					virtuals.setVirtualresource(attributes[2]);
					virtuals.setVirtualmark(attributes[4] + "<&>" + attributes[5] + "<&>" + attributes[3]);
					
					postBiz.addPost(type, virtuals, user);
					
					request.setAttribute("sexc", attributes[4]);
					request.setAttribute("iexcthing", attributes[5]);
					dispatcher = request.getRequestDispatcher("/MatchServlet");
					dispatcher.forward(request, response);
					//response.sendRedirect("jsp/Success.jsp");
					break;
				}
				session.setAttribute("user", user);
				System.out.println(user);
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("客户端表单不符合上传要求！");
		}
		
	}
	
	// 自定义方法完成上传文件名称的自动生成
	private synchronized String generateUnqieName() {
		return String.valueOf(System.nanoTime());
	}

}

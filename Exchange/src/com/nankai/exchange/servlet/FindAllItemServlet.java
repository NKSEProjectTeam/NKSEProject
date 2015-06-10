package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.IAudiosBiz;
import com.nankai.exchange.biz.IBagsBiz;
import com.nankai.exchange.biz.ICosmeticsBiz;
import com.nankai.exchange.biz.IDailyprosBiz;
import com.nankai.exchange.biz.IDecorationsBiz;
import com.nankai.exchange.biz.IDigitsBiz;
import com.nankai.exchange.biz.IElectricsBiz;
import com.nankai.exchange.biz.IEntertainmentsBiz;
import com.nankai.exchange.biz.IExtrabooksBiz;
import com.nankai.exchange.biz.IFemalesBiz;
import com.nankai.exchange.biz.IInstrumentsBiz;
import com.nankai.exchange.biz.IMalesBiz;
import com.nankai.exchange.biz.IOthersBiz;
import com.nankai.exchange.biz.IPcBiz;
import com.nankai.exchange.biz.IPhonesBiz;
import com.nankai.exchange.biz.ISpprosBiz;
import com.nankai.exchange.biz.ISptastsBiz;
import com.nankai.exchange.biz.ISpteqptsBiz;
import com.nankai.exchange.biz.ITextbooksBiz;
import com.nankai.exchange.biz.IVirtualsBiz;
import com.nankai.exchange.biz.impl.AudiosBizImpl;
import com.nankai.exchange.biz.impl.BagsBizImpl;
import com.nankai.exchange.biz.impl.CosmeticsBizImpl;
import com.nankai.exchange.biz.impl.DailyprosBizImpl;
import com.nankai.exchange.biz.impl.DecorationsBizImpl;
import com.nankai.exchange.biz.impl.DigitsBizImpl;
import com.nankai.exchange.biz.impl.ElectricsBizImpl;
import com.nankai.exchange.biz.impl.EntertainmentsBizImpl;
import com.nankai.exchange.biz.impl.ExtrabooksBizImpl;
import com.nankai.exchange.biz.impl.FemalesBizImpl;
import com.nankai.exchange.biz.impl.InstrumentsBizImpl;
import com.nankai.exchange.biz.impl.MalesBizImpl;
import com.nankai.exchange.biz.impl.OthersBizImpl;
import com.nankai.exchange.biz.impl.PcBizImpl;
import com.nankai.exchange.biz.impl.PhonesBizImpl;
import com.nankai.exchange.biz.impl.SpprosBizImpl;
import com.nankai.exchange.biz.impl.SptastsBizImpl;
import com.nankai.exchange.biz.impl.SpteqptsBizImpl;
import com.nankai.exchange.biz.impl.TextbooksBizImpl;
import com.nankai.exchange.biz.impl.VirtualsBizImpl;


/**
 * Servlet implementation class FindAllItemServlet
 */
public class FindAllItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		List<?> lstItems = null;
		
		String url=null;
		
		int kind=Integer.parseInt(request.getParameter("id"));
		
		System.out.println(kind);
		
		switch (kind) {
		case  1:
		   
			IAudiosBiz audiosBiz=new AudiosBizImpl();
		    lstItems=audiosBiz.findAll();
		    url="jsp/display/showaudio.jsp";
		    break;
			 
		case  2:
		   
			IBagsBiz bagsBiz=new BagsBizImpl();
			lstItems=bagsBiz.findAll();
			url="jsp/display/showbag.jsp";
		    break;
		case  3:
			
		    ICosmeticsBiz CosmeticsBiz=new CosmeticsBizImpl();
		    lstItems=CosmeticsBiz.findAll();
		    url="jsp/display/showcos.jsp";
		    break;
		case  4:
		    IDecorationsBiz DecorationsBiz=new DecorationsBizImpl();
		    lstItems=DecorationsBiz.findAll();
		    url="jsp/display/showdec.jsp";
		    break;
		case  5:
		    IDigitsBiz DigitsBiz=new DigitsBizImpl();
		    lstItems=DigitsBiz.findAll();
		    url="jsp/display/showdigit.jsp";
		    break;
		case  6:
		    
			IExtrabooksBiz ExtrabooksBiz=new ExtrabooksBizImpl();
		    lstItems=ExtrabooksBiz.findAll();
		    url="/jsp/display/showeb.jsp";

		    break;
		    
		case  7:
		    IFemalesBiz FemalesBiz=new FemalesBizImpl();
		    lstItems=FemalesBiz.findAll();
		    url="jsp/display/showfemale.jsp";
		    break;
		case  8:
		    IInstrumentsBiz InstrumentsBiz=new InstrumentsBizImpl();
		    lstItems=InstrumentsBiz.findAll();
		    url="/jsp/display/showinstrument.jsp";
		    break;
		case  9:
		    IMalesBiz MalesBiz=new MalesBizImpl();
		    lstItems=MalesBiz.findAll();
		    url="jsp/display/showmale.jsp";
		    break;
		case  10:
		    IOthersBiz OthersBiz=new OthersBizImpl();
		    lstItems=OthersBiz.findAll();
		    url="jsp/display/showother.jsp";
		    break;
		case  11:
		    IPcBiz pcBiz=new PcBizImpl();
		    lstItems=pcBiz.findAll();
		    url="jsp/display/showpc.jsp";
		    break;
		case  12:
		    IPhonesBiz PhonesBiz=new PhonesBizImpl();
		    lstItems=PhonesBiz.findAll();
		    url="jsp/display/showphone.jsp";
		    break;
		case  13:
		    ISptastsBiz SptastsBiz=new SptastsBizImpl();
		    lstItems=SptastsBiz.findAll();
		    url="jsp/display/showsa.jsp";
		    break;
		case  14:
		    ISpteqptsBiz SpteqptsBiz=new SpteqptsBizImpl();
		    lstItems=SpteqptsBiz.findAll();
		    url="jsp/display/showse.jsp";
		    break;
		case  15:
			//System.out.println(kind);
		    ITextbooksBiz TextbooksBiz=new TextbooksBizImpl();
		    
		    lstItems=TextbooksBiz.findAll();
		    url="/jsp/display/showtb.jsp";
		   
		    break;
		case  16:
		    IVirtualsBiz VirtualsBiz=new VirtualsBizImpl();
		    lstItems=VirtualsBiz.findAll();
		    url="jsp/display/showvirtual.jsp";
		    break;
		case  17:
		    IDailyprosBiz DailyprosBiz=new DailyprosBizImpl();
		    lstItems=DailyprosBiz.findAll();
		    
		    url="jsp/display/showdp.jsp";
		    break;
		case  18:
		    IElectricsBiz ElectricsBiz=new ElectricsBizImpl();
		    lstItems=ElectricsBiz.findAll();
		    url="jsp/display/showele.jsp";
		    break;
		case  19:
		    IEntertainmentsBiz EntertainmentsBiz=new EntertainmentsBizImpl();
		    lstItems=EntertainmentsBiz.findAll();
		    url="jsp/display/showenter.jsp";
		    break;
		case  20:
		    ISpprosBiz SpprosBiz=new SpprosBizImpl();
		    lstItems=SpprosBiz.findAll();
		    url="jsp/display/showsp.jsp";
		    break;
		default:
		    break;
		}
		
		request.setAttribute("lstItems", lstItems);
		
		System.out.println(url);
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			
		 dispatcher.forward(request, response);
		 
			
		
	}

}




package controller.mstseihin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeihinDAO;
import model.MSTSEIHIN;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Updatemstseihin")
public class Updatemstseihin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_seihin_code=request.getParameter("seihin_code");
		if(s_seihin_code==null) {
			response.sendRedirect("/20221017tokunagakaihatu/Readmstseihin");
		}else {
			SeihinDAO dao=new SeihinDAO();
			MSTSEIHIN mstseihin=dao.findOne(s_seihin_code);
			request.setAttribute("mstseihin",mstseihin );
			request.getRequestDispatcher("/WEB-INF/lib/view/updatemstseihin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String id=request.getParameter("id");
//		String name=request.getParameter("name");
//		String menu=request.getParameter("menu");
//		
		
		String seihin_code=request.getParameter("seihin_code");
		String seihin_name=request.getParameter("seihin_name");
		String seihin_genka=request.getParameter("seihin_genka");
		String seihin_teika=request.getParameter("seihin_teika");
		
		
		int seihingenka2;
		if (seihin_genka =="") {seihingenka2 = 0; }else {seihingenka2 = Integer.parseInt (seihin_genka);};
		
		int seihinteika2;
		if (seihin_teika =="") {seihinteika2 = 0; }else {seihinteika2 = Integer.parseInt (seihin_teika);};

//		int seihingenka2 = Integer.parseInt (seihin_genka);
//		int seihinteika2 = Integer.parseInt (seihin_teika);
//		
		
	
		
		
		
		MSTSEIHIN mstseihin=new MSTSEIHIN(seihin_code,seihin_name,seihingenka2,seihinteika2);
		
		mstseihin.setSeihin_code(seihin_code);
		mstseihin.setSeihin_name(seihin_name);
		mstseihin.setSeihin_genka(seihingenka2);
		mstseihin.setSeihin_teika(seihinteika2);
		
		
		
		SeihinDAO dao=new SeihinDAO();
		
		dao.updateOne(mstseihin);
		
		response.sendRedirect("/20221017tokunagakaihatu/Readmstseihin");
	}

}


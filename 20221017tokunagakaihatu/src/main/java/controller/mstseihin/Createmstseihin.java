
package controller.mstseihin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeihinDAO;
import model.MSTSEIHIN;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Createmstseihin")
public class Createmstseihin extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/lib/view/createmstseihin.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String seihin_code=request.getParameter("seihin_code");
		String seihin_name=request.getParameter("seihin_name");
		String seihin_genka=request.getParameter("seihin_genka");
		String seihin_teika=request.getParameter("seihin_teika");
		
		
		
		
//		
//		if (seihingenka2 = NotNull) {int seihingenka2 = Integer.parseInt (seihin_genka)};
		
		int seihingenka2;
		if (seihin_genka =="") {seihingenka2 = 1; }else {seihingenka2 = Integer.parseInt (seihin_genka);};
		
		int seihinteika2;
		if (seihin_teika =="") {seihinteika2 = 1; }else {seihinteika2 = Integer.parseInt (seihin_teika);};
		
		
//		 seihingenka2 = Integer.parseInt (seihin_genka);
//		 seihinteika2 = Integer.parseInt (seihin_teika);
		
//		int seihin_genka=Integer.parseInt(request.getParameter("seihin_genka")) ;
//		int seihin_teika=Integer.parseInt(request.getParameter("seihin_teika"));
		
		
	
		
		MSTSEIHIN mstseihin=new MSTSEIHIN(seihin_code,seihin_name,seihingenka2,seihinteika2);
		
		
		
		mstseihin.setSeihin_code(seihin_code);
		
		mstseihin.setSeihin_name(seihin_name);
		mstseihin.setSeihin_genka(seihingenka2);
		mstseihin.setSeihin_teika(seihinteika2);
		
		
		
		SeihinDAO ld=new SeihinDAO();
		ld.insertOne(mstseihin);

		response.sendRedirect("/20221017tokunagakaihatu/Readmstseihin");
		
		
		
	}

}

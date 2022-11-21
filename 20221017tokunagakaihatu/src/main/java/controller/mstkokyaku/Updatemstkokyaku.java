




package controller.mstkokyaku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KokyakuDAO;
import model.MSTKOKYAKU;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Updatemstkokyaku")
public class Updatemstkokyaku extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_kokyaku_code=request.getParameter("kokyaku_code");
		if(s_kokyaku_code==null) {
			response.sendRedirect("/20221017tokunagakaihatu/Readmstkokyaku");
		}else {
			KokyakuDAO dao=new KokyakuDAO();
			MSTKOKYAKU mstkokyaku=dao.findOne(s_kokyaku_code);
			request.setAttribute("mstkokyaku",mstkokyaku );
			request.getRequestDispatcher("/WEB-INF/lib/view/updatemstkokyaku.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String id=request.getParameter("id");
//		String name=request.getParameter("name");
//		String menu=request.getParameter("menu");
//		
		
		String kokyaku_code=request.getParameter("kokyaku_code");
		String kokyaku_name=request.getParameter("kokyaku_name");
		String kokyaku_address=request.getParameter("kokyaku_address");
		String kokyaku_tel=request.getParameter("kokyaku_tel");
		
		
		
		
//		int seihingenka2;
//		if (seihin_genka =="") {seihingenka2 = 0; }else {seihingenka2 = Integer.parseInt (seihin_genka);};
//		
//		int seihinteika2;
//		if (seihin_teika =="") {seihinteika2 = 0; }else {seihinteika2 = Integer.parseInt (seihin_teika);};

		
		
//		int seihingenka2 = Integer.parseInt (seihin_genka);
//		int seihinteika2 = Integer.parseInt (seihin_teika);
//		
		
	
		
		
//		
//		MSTKOKYAKU mstkokyaku=new MSTKOKYAKU(seihin_code,seihin_name,seihingenka2,seihinteika2);
//		
//		mstseihin.setSeihin_code(seihin_code);
//		mstseihin.setSeihin_name(seihin_name);
//		mstseihin.setSeihin_genka(seihingenka2);
//		mstseihin.setSeihin_teika(seihinteika2);
		
		
		
MSTKOKYAKU mstkokyaku=new MSTKOKYAKU(kokyaku_code,kokyaku_name,kokyaku_address,kokyaku_tel);
		
mstkokyaku.setKokyaku_code(kokyaku_code);
mstkokyaku.setKokyaku_name(kokyaku_name);
mstkokyaku.setKokyaku_address(kokyaku_address);
mstkokyaku.setKokyaku_tel(kokyaku_tel);
		
		
		KokyakuDAO dao=new KokyakuDAO();
		
		dao.updateOne(mstkokyaku);
		
		response.sendRedirect("/20221017tokunagakaihatu/Readmstkokyaku");
	}

}



package controller.mstkokyaku;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KokyakuDAO;
import model.MSTKOKYAKU;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Createmstkokyaku")
public class Createmstkokyaku extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/lib/view/createmstkokyaku.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String kokyaku_code=request.getParameter("kokyaku_code");
		String kokyaku_name=request.getParameter("kokyaku_name");
		String kokyaku_address=request.getParameter("kokyaku_address");
		String kokyaku_tel=request.getParameter("kokyaku_tel");
		
		
		
		
		
		String kokyaku_address2;
		if (kokyaku_address =="") {kokyaku_address2 = null; }else {kokyaku_address2 = kokyaku_address;};
		
		String kokyaku_tel2;
		if (kokyaku_tel =="") {kokyaku_tel2 = null; }else {kokyaku_tel2 = kokyaku_tel;};
		
		

		
		
//		if (kokyaku_address =="") {kokyaku_address= "0"; };
		
//		int seihinteika2;
//		if (seihin_teika =="") {seihinteika2 = 0; }else {seihinteika2 = Integer.parseInt (seihin_teika);};
//		
		
//		String kokyaku_code = "";
//		if (num < 20) {
//		  System.out.println("numの値は20未満");
//		}
//		System.out.println("if文後の処理");
//		
		
	
		
		MSTKOKYAKU mstkokyaku=new MSTKOKYAKU(kokyaku_code,kokyaku_name,kokyaku_address2,kokyaku_tel2);
		
		
		
		mstkokyaku.setKokyaku_code(kokyaku_code);
		
		mstkokyaku.setKokyaku_name(kokyaku_name);
		mstkokyaku.setKokyaku_address(kokyaku_address2);
		mstkokyaku.setKokyaku_tel(kokyaku_tel2);
		
		
		
		KokyakuDAO ld=new KokyakuDAO();
		ld.insertOne(mstkokyaku);

		response.sendRedirect("/20221017tokunagakaihatu/Readmstkokyaku");
		
		
		
	}

}
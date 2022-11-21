
package controller.mstkokyaku;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KokyakuDAO;
import model.MSTKOKYAKU;

@WebServlet("/Searchmstkokyaku")
public class Searchmstkokyaku extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String kokyaku_code2=request.getParameter("kokyaku_code");
		String kokyaku_name2=request.getParameter("kokyaku_name");
		
		
		KokyakuDAO dao=new KokyakuDAO();
		List<MSTKOKYAKU> list=dao.searchAll(kokyaku_code2,kokyaku_name2);
		
		List<MSTKOKYAKU> list1=dao.listAll();
		request.setAttribute("list1", list1);
		
		
		
		
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/lib/view/searchmstkokyaku.jsp");
		rd.forward(request, response);
		
		
//
//		MSTSEIHIN mstseihin=new MSTSEIHIN(seihin_code);
//
//
//
//		mstseihin.setSeihin_code(seihin_code);
//		
//		SeihinDAO ld=new SeihinDAO();
//		ld.insertOne(mstseihin);

		
		
		
		
		
		
		
	}

	
	
	
	
}

	
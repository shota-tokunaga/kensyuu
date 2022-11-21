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

//@WebServlet("/Readmstkokyaku")

@WebServlet("/Readmstkokyaku")

public class Readmstkokyaku extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KokyakuDAO dao=new KokyakuDAO();
		List<MSTKOKYAKU> list=dao.findAll();
		request.setAttribute("list", list);
//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/lib/view/readmstkokyaku.jsp");
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/lib/view/readmstkokyaku.jsp");
		
		
		rd.forward(request, response);}
		
	
	
		
		
}



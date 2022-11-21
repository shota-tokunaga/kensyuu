package controller.mstkokyaku;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KokyakuDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Deletemstkokyaku")
public class Deletemstkokyaku extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kokyaku_code=request.getParameter("kokyaku_code");
		if(kokyaku_code !=null) {
			KokyakuDAO dao=new KokyakuDAO();
			dao.deleteOne(kokyaku_code);
		}
		response.sendRedirect("/20221017tokunagakaihatu/Readmstkokyaku");
	}
	}
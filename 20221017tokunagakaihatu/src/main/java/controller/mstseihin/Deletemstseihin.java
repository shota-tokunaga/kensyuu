package controller.mstseihin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeihinDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Deletemstseihin")
public class Deletemstseihin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seihin_code=request.getParameter("seihin_code");
		if(seihin_code !=null) {
			SeihinDAO dao=new SeihinDAO();
			dao.deleteOne(seihin_code);
		}
		response.sendRedirect("/20221017tokunagakaihatu/Readmstseihin");
	}
	}
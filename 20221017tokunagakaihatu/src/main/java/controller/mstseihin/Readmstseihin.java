package controller.mstseihin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeihinDAO;
import model.MSTSEIHIN;

@WebServlet("/Readmstseihin")
public class Readmstseihin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SeihinDAO dao=new SeihinDAO();
		List<MSTSEIHIN> list=dao.findAll();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/lib/view/readmstseihin.jsp");
		rd.forward(request, response);
	}

}
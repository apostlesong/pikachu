package card.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import card.model.CardBean;
import card.service.CardService;
import card.service.impl.CardServiceImpl;


public class CardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		int nId = Integer.parseInt(id);
		CardService service = new CardServiceImpl();
		CardBean bean = service.getCard(nId);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/cards/cradeitsearch_produce.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

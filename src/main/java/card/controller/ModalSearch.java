package card.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import card.model.CardBean;
import card.service.CardService;
import card.service.impl.CardServiceImpl;

@WebServlet("/ModalSearchs")
public class ModalSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//取得modal選單查詢的條件
		String ops1 = request.getParameter("opt1");
		String ops2 = request.getParameter("opt2");
		String ops3 = request.getParameter("opt3");
		String sal =  request.getParameter("sal");
		
		//組合查詢條件
		List<String> op = new ArrayList<>();
		op.add(ops1);
		op.add(ops2);
		op.add(ops3);
		String al = "";
		for(String s :op) {
			if(s.indexOf("請選擇") == -1) {
				al=al +" and " +s; 
			}			
		}
		//成為一個完整的hql
		String ql = "From CardBean c WHERE " + sal + al;
		
		
//		System.out.println(ops);
//		int sl = ops.length;
//		String hp =request.getParameter("mimi");

//		request.setAttribute("mimi", hp);
//		request.setAttribute("mdtest", sl);
		request.setAttribute("opt1", ops1);
		request.setAttribute("opt2", ops2);
		request.setAttribute("opt3", ops3);
		request.setAttribute("sal", sal);
		request.setAttribute("ql", ql);
		CardService service = new CardServiceImpl();
		Map<Integer, CardBean> CardMap = service.getModalBean(ql);
		session.setAttribute("products_DPP", CardMap);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/cards/modaltest.jsp");		
//		RequestDispatcher rd = request.getRequestDispatcher("/cards/cradeitsearch_minecredit.jsp");
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/cards/cradeitsearch_minecredit.jsp");
	
//		rd.forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

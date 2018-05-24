package web;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchBean;
import service.KaiinService;

/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SearchServletが実行されました。");

		//画面から入力したデータを取得する
		String idstr = request.getParameter("id");

		int id = Integer.parseInt(idstr);

		KaiinService ks = new KaiinService();

		SearchBean sb = ks.searchKaiin(id);

		request.setAttribute("bean", sb);

		RequestDispatcher disp = request.getRequestDispatcher("/search.jsp");
		disp.forward(request, response);






		//JSPに遷移する

	}

}

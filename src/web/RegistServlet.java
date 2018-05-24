package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegistBean;
import service.KaiinService;

/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
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
		String namestr = new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
		String sexstr = request.getParameter("sex");

		int id = Integer.parseInt(idstr);

		KaiinService ks = new KaiinService();

		RegistBean rb = ks.registKaiin(id, namestr, sexstr);

		request.setAttribute("bean", rb);

		RequestDispatcher disp = request.getRequestDispatcher("/regist.jsp");
		disp.forward(request, response);
	}



}

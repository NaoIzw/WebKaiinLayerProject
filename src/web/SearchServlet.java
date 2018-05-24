package web;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String get = " SELECT " +
				" KAIINNO " +
				" ,NAME " +
				" ,REGISTDATE" +
				" FROM " +
				" KAIIN " +
				" WHERE " +
				" KAIINNO " +
				" = ? ";

		ResultSet rset = null;

		//接続文字列の構築
		/* ユーザ名 */
		String user = "train2018";
		/* パスワード */
		String pass = "train2018";

		/* サーバ名 */
		String servername = "localhost:3306";
		/* DB名 */
		String dbname = "new_schema";

		// ドライバーのロード
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		//com.mysql.jdbc.Driver d= new com.mysql.jdbc.Driver();
		//com.mysql.jdbc.JDBC4Connection c = new com.mysql.jdbc.JDBC4Connection();



		//接続の実行とコネクションオブジェクトの取得
		Connection c;
		try {
			c = DriverManager.getConnection(
					"jdbc:mysql://"
							+ servername
							+ "/"
							+ dbname,
							user,
							pass);


			PreparedStatement stmt = c.prepareStatement(get);

			String name = null;

			stmt.setInt(1, id);

			rset = stmt.executeQuery();

			while(rset.next())
			{
				request.setAttribute("id", rset.getInt(1));
				request.setAttribute("name", rset.getString(2));
				name = rset.getString(2);
				request.setAttribute("date", rset.getDate(3));
			}

			if(name==null) {
				request.setAttribute("message", "そんなかいいんいません");
				RequestDispatcher disp = request.getRequestDispatcher("/Notfound.jsp");
				disp.forward(request, response);
			}else {

				RequestDispatcher disp = request.getRequestDispatcher("/next.jsp");
				disp.forward(request, response);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		//JSPに遷移する

	}

}

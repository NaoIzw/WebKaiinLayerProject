package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.KaiinVo;

public class KaiinMgr extends Dao{

	private static final String PUT =
			"insert into kaiin ( "
			+ "  KaiinNo "
			+ " ,Name "
			+ " ,registDate "
			+ " ) "
			+ " values ( "
			+ "  ?,?,? ) ";

	private static final String GET =
			          "   select "
					+ "   KAIINNO"
					+ "  ,NAME"
					+ "  ,REGISTDATE "
					+ "  ,SEX"
					+ " from "
					+ "   KAIIN "
					+ "where "
					+ "  KAIINNO "
					+ "   =? ";

	private static final String VAL = "select "
			+ "   KAIINNO"
			+ "  ,NAME"
			+ "  ,REGISTDATE "
			+ " from "
			+ "   KAIIN ";

	public KaiinMgr(Connection con) {
		super(con);
	}

	//-------------------------------------------------------
	// 会員登録
	public void putKaiin(KaiinVo kv) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try{

			stmt = con.prepareStatement(PUT);

			//stmt.setInt(1,e.getEmployeeid() );
			stmt.setInt(1, kv.getKaiinno());
			stmt.setString(2,kv.getName());
			stmt.setDate(3, kv.getRegistdate());


			/* ｓｑｌ実行 */
			//rset = stmt.executeQuery();
			int numCount = stmt.executeUpdate();
		}
		catch (SQLException ex) {
			throw ex;
		}
		finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}
	}


	//-------------------------------------------------------
	// 会員取得
	public KaiinVo getKaiin(int i) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rset = null;
		KaiinVo kv = null;

		try{

			/* Statementの作成 */
			stmt = con.prepareStatement(GET);

			stmt.setInt(1, i);

			/* ｓｑｌ実行 */
			rset = stmt.executeQuery();

			/* 取得したデータを表示します。 */
			while (rset.next())
			{
				kv = new KaiinVo();
				kv.setKaiinno(		 rset.getInt(1) );
				kv.setName( 	     rset.getString(2));
				kv.setRegistdate(    rset.getDate(3));
				kv.setSex( rset.getString(4));
			}
		}

		catch (SQLException e) {
			throw e;
		}
		finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}

		return kv;
	}


	public /**Collection<Kaiin>**/List<KaiinVo> values() throws SQLException {
		//return kaiinDB.values();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		List<KaiinVo>  list = new ArrayList<KaiinVo> ();

		try{

			/* Statementの作成 */
			stmt = con.prepareStatement(VAL);

			/* ｓｑｌ実行 */
			rset = stmt.executeQuery();

			/* 取得したデータを表示します。 */
			while (rset.next())
			{
				KaiinVo kv = new KaiinVo();
				kv.setKaiinno(		 rset.getInt(1) );
				kv.setName( 	     rset.getString(2));
				kv.setRegistdate(    rset.getDate(3));
				list.add(kv);
			}
		}

		catch (SQLException e) {
			throw e;
		}
		finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}
		return list;
	}
}
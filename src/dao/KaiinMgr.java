package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KaiinMgr extends Dao{

    //static Map<Integer, Kaiin> kaiinDB = new HashMap<>();

	public KaiinMgr(Connection con) {
		super(con);
	}

	//-------------------------------------------------------
	// 会員登録
	public void putKaiin(kaiinVo kv) throws SQLException {
		  PreparedStatement stmt = null;
		  ResultSet rset = null;
		  try{

			  stmt = con.prepareStatement(
					  "insert into kaiin ( "
					+ "  KaiinNo "
					+ " ,Name "
					+ " ,registDate "
					+ " ) "
					+ " values ( "
					+ "  ?,?,? ) ");


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
	public kaiinVo getKaiin(int i) throws SQLException {

	  PreparedStatement stmt = null;
	  ResultSet rset = null;
	  kaiinVo kv = new kaiinVo();

	  try{

		/* Statementの作成 */
			stmt = con.prepareStatement(
					  "select "
					+ "   KAIINNO"
					+ "  ,NAME"
					+ "  ,REGISTDATE "
					+ " from "
					+ "   KAIIN "
					+ "where "
					+ "  KAIINNO "
					+ "   =? ");

		stmt.setInt(1, i);

		/* ｓｑｌ実行 */
		rset = stmt.executeQuery();

		/* 取得したデータを表示します。 */
		while (rset.next())
			{
				//sm.setEmployeeid(		rset.getInt("EMPLOYEEID") );
				kv.setKaiinno(		 rset.getInt(1) );
				kv.setName( 	     rset.getString(2));
				kv.setRegistdate(    rset.getDate(3));
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


	public /**Collection<Kaiin>**/List<kaiinVo> values() throws SQLException {
		//return kaiinDB.values();
		  PreparedStatement stmt = null;
		  ResultSet rset = null;
		  List<kaiinVo>  list = new ArrayList<kaiinVo> ();

		  try{

			/* Statementの作成 */
				stmt = con.prepareStatement(
						  "select "
						+ "   KAIINNO"
						+ "  ,NAME"
						+ "  ,REGISTDATE "
						+ " from "
						+ "   KAIIN "
						);

			/* ｓｑｌ実行 */
			rset = stmt.executeQuery();

			/* 取得したデータを表示します。 */
			while (rset.next())
				{
					kaiinVo kv = new kaiinVo();
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
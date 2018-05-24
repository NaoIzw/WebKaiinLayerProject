package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.RegistBean;
import bean.SearchBean;
import dao.Dao;
import dao.KaiinMgr;
import domain.SexEnum;
import vo.KaiinVo;

public class KaiinService {

	public RegistBean registKaiin(int id, String name, String sex) {

		RegistBean rb = null;

		try(
				Connection con = Dao.getConnection();
		)
		{
			KaiinMgr km = new KaiinMgr(con);
			rb = new RegistBean();

			KaiinVo kv = new KaiinVo(id, name, sex);

			km.putKaiin(kv);

			rb.setMessage("登録が完了しました。");

			return rb;
		}catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public SearchBean searchKaiin(int id) {

		SearchBean sb = null;

		try(
			Connection con = Dao.getConnection();
		)
		{
			KaiinMgr km = new KaiinMgr(con);
			sb = new SearchBean();

			KaiinVo kv = km.getKaiin(id);

			if(kv == null) {
				sb.setExist(false);
				sb.setMassage("入力されたIDに該当する会員はいませんでした。");
				return sb;
			}

			sb.setExist(true);
			sb.setMassage("検索結果");

			sb.setKaiinno(kv.getKaiinno());
			sb.setName(kv.getName());
			sb.setRegistdate(kv.getRegistdate().toLocalDate());
			sb.setSex(SexEnum.valueOf(kv.getSex()));

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		return sb;
	}

}

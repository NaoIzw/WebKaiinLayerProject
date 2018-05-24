package service;

import java.time.LocalDate;

import bean.SearchBean;

public class KaiinService {

	public SearchBean searchKaiin(int id) {
		// TODO 自動生成されたメソッド・スタブ

		SearchBean sb = new SearchBean();

		sb.setKaiinno(2);
		sb.setName("いざわ");
		sb.setRegistdate(LocalDate.now());

		return sb;
	}

}

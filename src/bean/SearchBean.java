package bean;

import java.time.LocalDate;

public class SearchBean {
	private int kaiinno;
	private String name;
	private LocalDate registdate;

	public SearchBean(){}

	public int getKaiinno() {
		return kaiinno;
	}

	public void setKaiinno(int kaiinno) {
		this.kaiinno = kaiinno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getRegistdate() {
		return registdate;
	}

	public void setRegistdate(LocalDate registdate) {
		this.registdate = registdate;
	}

	@Override
	public String toString() {
		return "SearchBean [kaiinno=" + kaiinno + ", name=" + name + ", registdate=" + registdate + "]";
	}


}

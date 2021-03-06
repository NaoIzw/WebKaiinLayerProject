package bean;

import java.time.LocalDate;

import domain.SexEnum;

public class SearchBean {
	private String massage;
	private int kaiinno;
	private String name;
	private LocalDate registdate;
	private SexEnum sex;
	private boolean isExist;

	public SearchBean(){}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

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

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	@Override
	public String toString() {
		return "SearchBean [kaiinno=" + kaiinno + ", name=" + name + ", registdate=" + registdate + "]";
	}


}

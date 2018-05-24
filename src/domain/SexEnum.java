package domain;

public enum SexEnum {
	MALE("男性"),FEMALE("女性");

	private String dispname;

	private SexEnum(String dispname) {
		this.dispname = dispname;
	}

	public String getDispname() {
		return dispname;
	}
}

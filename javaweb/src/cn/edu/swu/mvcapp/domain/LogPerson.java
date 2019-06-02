package cn.edu.swu.mvcapp.domain;

public class LogPerson {
	private String passWd;
	private String name;
	private String id;
	
	public LogPerson(String passWd, String name, String id) {
		super();
		this.passWd = passWd;
		this.name = name;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LogPerson(String passWd) {
		super();
		this.passWd = passWd;
	}

	public String getPassWd() {
		return passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
}

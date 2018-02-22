package my.satish.jdbc;

public class Person {
	private Integer pId;
	private String pName;
	private String pCountry;
	
	
	
	public Person(Integer pId, String pName, String pCountry) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pCountry = pCountry;
	}
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCountry() {
		return pCountry;
	}
	public void setpCountry(String pCountry) {
		this.pCountry = pCountry;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", pCountry=" + pCountry + "]";
	}
	
	
}

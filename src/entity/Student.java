package entity;

public class Student {

	private Integer sId;
	
	private String sName;
	
	private double sal;
	
	public Student() {
		
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Double getSalary() {
		return sal;
	}

	public void setSalary(Double salary) {
		this.sal = salary;
	}
	
	@Override
	public String toString() {
		return "id="+this.getsId()+" name="+this.getsName()+" salary:"+this.getSalary();
	}
}

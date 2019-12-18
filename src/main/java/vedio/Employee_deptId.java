package vedio;

public class Employee_deptId extends Employee {

	private Integer dept_id ;

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "Employee_deptId [getDept_id()=" + getDept_id() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + ", getDepartment()=" + getDepartment() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	
	
	
}

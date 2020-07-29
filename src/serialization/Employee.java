package serialization;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4227138074044013136L;

	private String name;
	private transient String id;
	private String department;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getDepartment() {
		return department;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}

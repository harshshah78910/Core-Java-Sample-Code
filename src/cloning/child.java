package cloning;

import java.util.ArrayList;
import java.util.List;

public class child extends Parent{

	private String name;
	
	private List<String> list = new ArrayList<String>();
	
	public child(int id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public child(String name) {
		super();
		this.name = name;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException  {
		
		return (child)super.clone();
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	
	
	
	

}

package cloning;

public class Parent  implements Cloneable{

	
	private int id;
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException  {
		
		return (Parent)super.clone();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Parent(int id) {
		super();
		this.id = id;
	}
	
	Parent()
	{
		
	}
}

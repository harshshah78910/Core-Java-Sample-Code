package fundamentals;

public class fundamentals {

	public static void main(String args[]) {

		fundamentals fd = new fundamentals();
		System.out.println(fd.overloadTest(1, 2));
		System.out.println(fd.overloadTest(new Integer(1), new Integer(2)));
		
		Child c = new Child();
		
		Parent p = new Parent();
		if(c instanceof Parent)
		{
			System.out.println("Parent Instance");
		}
		if(p.equals(c))
		{
			System.out.println("Equal objects");
		}
		if(c.equals(p))
		{
			System.out.println("Equal objects Child");
		}
		
	}

	public int overloadTest(int a, int b) {
		return 1;
	}

	public int overloadTest(Integer a, Integer b) {
		return 2;
	}
	
	public int overloadTest(int a, Integer b) {
		return 2;
	}
	
	public int overloadTest(Integer a, int b) {
		return 2;
	}
	
	
	
}

class Parent
{
int id=1;



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Parent other = (Parent) obj;
	if (id != other.id)
		return false;
	return true;
}

}

class Child extends Parent
{
	int id=1;
	int name;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass()) // This is Important
			return false;
		Child other = (Child) obj;
		if (id != other.id)
			return false;
		if (name != other.name)
			return false;
		return true;
	}
	
	
	
}

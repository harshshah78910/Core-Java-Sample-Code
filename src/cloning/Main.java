package cloning;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		//Just Parent Class
		Parent p = new Parent(1);
		Parent p1 =  (Parent)p.clone();
		p.setId(2);
		System.out.println(p.getId());
		System.out.println(p1.getId());
		
		//Just a Child Class
		child c1 = new child("ABC");
		child c2 = (child)c1.clone();
		
		if(c1 == c2)
		{
			System.out.println("Clonning Failed");
		}
		
		if(c1.getList() == c2.getList())
		{
			System.out.println("Shallow Clonning Example");
		}
		
		c1.setName("Harsh");
		p.setId(23);
		System.out.println(c1.getName());
		System.out.println(c2.getName());
	}

}

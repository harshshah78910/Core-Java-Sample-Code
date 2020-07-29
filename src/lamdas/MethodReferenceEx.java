package lamdas;

public class MethodReferenceEx {
	
	public static void main(String[] args) {
	
		Thread t1 = new Thread(() -> methodRef());
		t1.start();
		Thread t2 = new Thread(MethodReferenceEx :: methodRef);
		t2.start();
	}
	
	

	public static void methodRef()
	{
		System.out.println("Method Ref Example");
	}
}



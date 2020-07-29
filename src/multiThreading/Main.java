package multiThreading;

public class Main {

	
	public static volatile int counter =0;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		t1.start();
		t2.start();

	}
	
	public static synchronized void incrementCounter()
	{
		System.out.println(counter++);
	}

}

package multiThreading;

public class Thread1 implements Runnable{

	@Override
	public void run() {
		
		Main.incrementCounter();
	}

}



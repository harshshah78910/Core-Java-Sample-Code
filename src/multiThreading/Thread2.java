package multiThreading;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		Main.incrementCounter();
	}

}



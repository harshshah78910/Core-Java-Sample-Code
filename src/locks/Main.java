package locks;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);
		Thread s1 = new Thread(new CountDownLatch1(latch));
		Thread s2 = new Thread(new CountDownLatch2(latch));
		s1.start();
		s2.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Count Down to latch completed");
	}

}

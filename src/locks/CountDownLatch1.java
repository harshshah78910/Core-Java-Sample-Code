package locks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 implements Runnable {

	private CountDownLatch latch;

	 CountDownLatch1(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		System.out.println("This is Service 1 for CountDownLatch Example");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();

	}

}

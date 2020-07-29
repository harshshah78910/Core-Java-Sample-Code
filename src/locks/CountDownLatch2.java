package locks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch2 implements Runnable {

	private CountDownLatch latch;

	CountDownLatch2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		System.out.println("This is Service 2");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}

}

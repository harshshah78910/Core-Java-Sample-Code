package locks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierEx {

	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(10);
		CyclicBarrier barrier = new CyclicBarrier(10);

		for (int i = 0; i < 9; i++) {
			ex.submit(new RunnableEx(barrier, i));
		}

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All the Cyclic barriers Reached");
	}

}

class RunnableEx implements Runnable {
	CyclicBarrier barrier;
	int id;

	RunnableEx(CyclicBarrier barrier, int id) {
		this.barrier = barrier;
		this.id = id;
	}

	@Override
	public void run() {

		System.out.println("Cyclic Barrire Reached for " + id);
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

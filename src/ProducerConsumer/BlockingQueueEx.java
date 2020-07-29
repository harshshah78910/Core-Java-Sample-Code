package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueEx {

	public static void main(String[] args) {

		ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

		Thread p1 = new Thread(new Prod(blockingQueue));
		Thread p2 = new Thread(new Prod(blockingQueue));

		Thread c1 = new Thread(new Cons(blockingQueue));
		Thread c2 = new Thread(new Cons(blockingQueue));

		p1.start();
		p2.start();
		c1.start();
		c2.start();

	}

}

class Prod implements Runnable {

	ArrayBlockingQueue<Integer> blockingQueue;

	Prod(ArrayBlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			Random r = new Random();
			int i = r.nextInt(10);

			try {
				blockingQueue.put(i);
				System.out.println("Putting " + i);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Cons implements Runnable {
	ArrayBlockingQueue<Integer> blockingQueue;

	Cons(ArrayBlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		while(true)
		{
			try {

				Integer take = blockingQueue.take();
				System.out.println("Taking " + take);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
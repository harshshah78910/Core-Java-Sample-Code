package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueImp {

	public static void main(String[] args) {

		SynchronousQueue<Integer> synchQ = new SynchronousQueue<Integer>();

		Thread t = new Thread(new Producer(synchQ));
		t.start();

		Thread t2 = new Thread(new Consumer(synchQ));
		t2.start();

	}

}

class Producer implements Runnable {

	SynchronousQueue<Integer> synchQ;

	Producer(SynchronousQueue<Integer> synchQ) {
		this.synchQ = synchQ;
	}

	@Override
	public void run() {

		Random rand = new Random();
		while (true) {
			try {
				int nextInt = rand.nextInt(10);
				synchQ.put(nextInt);
				System.out.println("Putting Value " + nextInt);
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Consumer implements Runnable {
	SynchronousQueue<Integer> synchQ;

	Consumer(SynchronousQueue<Integer> synchQ) {
		this.synchQ = synchQ;
	}

	@Override
	public void run() {

		while (true) {
			Integer remove = null;
			try {
				remove = synchQ.take();
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumer Consumed " + remove);
		}

	}

}

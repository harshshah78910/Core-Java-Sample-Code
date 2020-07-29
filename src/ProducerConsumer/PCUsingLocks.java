package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PCUsingLocks {

	public static void main(String[] args) {

		MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<Integer>();

		Thread p1 = new Thread(new P(blockingQueue));
		Thread p2 = new Thread(new P(blockingQueue));

		Thread c1 = new Thread(new C(blockingQueue));
		Thread c2 = new Thread(new C(blockingQueue));

		p1.start();
		p2.start();
		c1.start();
		c2.start();

	}

}

class MyBlockingQueue<E> {
	private Queue<E> queue;
	private int size = 10;
	ReentrantLock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	MyBlockingQueue() {
		queue = new LinkedList<>();
	}

	public void put(E e) throws InterruptedException {

		try {
			lock.lock();
			if (queue.size() == this.size) {
				notFull.await();
			}
			queue.add(e);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}

	}

	public E take() throws InterruptedException {

		try {
			lock.lock();
			while (queue.size() == 0) {
				notEmpty.await();
			}
			E remove = queue.remove();
			notFull.signalAll();
			return remove;
		} finally {
			lock.unlock();
		}

	}
}

class P implements Runnable {

	MyBlockingQueue<Integer> blockingQueue;

	P(MyBlockingQueue<Integer> blockingQueue) {
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

class C implements Runnable {
	MyBlockingQueue<Integer> blockingQueue;

	C(MyBlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		while (true) {
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

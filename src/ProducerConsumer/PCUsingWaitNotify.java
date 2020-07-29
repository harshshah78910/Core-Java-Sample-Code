package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class PCUsingWaitNotify {

}

// Replace Lock and Unlock by Synchronized Block
// Replace NotFull and NotEmpty Condition by Object which has inbuilt wait and notify methods

class MyBlockingQueueWN<E> {

	private Queue<E> queue;
	private int size = 10;
	//ReentrantLock lock = new ReentrantLock();
	private Object notEmpty = new Object();
	private Object notFull = new Object();

	MyBlockingQueueWN() {
		queue = new LinkedList<>();
	}

	public void put(E e) throws InterruptedException {

		synchronized (this) {
			if (queue.size() == this.size) {
				notFull.wait();
			}
			queue.add(e);
			notEmpty.notifyAll();
		}

	}

	public E take() throws InterruptedException {

		synchronized (this) {
			while (queue.size() == 0) {
				notEmpty.wait();
			}
			E remove = queue.remove();
			notFull.notifyAll();
			return remove;
		}

	}

}

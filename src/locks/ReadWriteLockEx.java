package locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReadWriteLockEx {

	private static ReadLock readLock = new ReentrantReadWriteLock().readLock();
	private static WriteLock writeLock = new ReentrantReadWriteLock().writeLock();

	static void readSharedRes() {
		boolean tryLock = false;
		try {
			tryLock = readLock.tryLock();
			if (tryLock) {
				
				System.out.println("Reading Shared Resource " + Thread.currentThread().getName());
				Thread.currentThread().sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (tryLock) {
				readLock.unlock();
			}
		}

	}

	static void writeSharedRes() {
		boolean tryLock = false;
		try {
			tryLock = writeLock.tryLock();
			if (tryLock) {
				System.out.println("Writing Shared Resource " + Thread.currentThread().getName());
			}
		} finally {
			if (tryLock) {
				writeLock.unlock();
			}
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> readSharedRes());
		t1.setName("t1");
		t1.start();
		Thread t2 = new Thread(() -> writeSharedRes());
		t2.setName("t2");
		t2.start();
		Thread t3 = new Thread(() -> readSharedRes());
		t3.setName("t3");
		t3.start();
		Thread t4 = new Thread(() -> writeSharedRes());
		t4.setName("t4");
		t4.start();

	}

}

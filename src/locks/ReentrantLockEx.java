package locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {

	private static ReentrantLock lock = new ReentrantLock(true);

	private static void accessResource() {
		try {
			lock.lock();
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " has access");
			//System.out.println(lock.getHoldCount());

			for(int i=0; i<10; i++)
			{
				System.out.println(i);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);

		} finally {
			lock.unlock();
			lock.unlock();
		}

	}

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> accessResource());
		t1.setName("t1");
		t1.start();
		Thread t2 = new Thread(() -> accessResource());
		t2.setName("t2");
		t2.start();
		Thread t3 = new Thread(() -> accessResource());
		t3.setName("t3");
		t3.start();
		Thread t4 = new Thread(() -> accessResource());
		t4.setName("t4");
		t4.start();

	}

}

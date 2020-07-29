package multiThreading;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerDemo {

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			Thread.currentThread().setUncaughtExceptionHandler(new CatchUnCheckedExceptionByThread());
			throw new NullPointerException();
		});
		t1.setName("Runtime Exception Caught");
		t1.start();

	}

}

class CatchUnCheckedExceptionByThread implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {

		System.out.println(t.getName());
		System.out.println(e);

	}

}
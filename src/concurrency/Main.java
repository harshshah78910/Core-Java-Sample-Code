package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		/*
		 * int coreCount = Runtime.getRuntime().availableProcessors();
		 * System.out.println(coreCount);
		 */

		// naiveWayToCreateThreads();
		// basicExecutorService();
		// scheduledPoolEx();
		// callableEx();
	}

	private static void callableEx() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<String> futureString = executor.submit(new CallableTask());
		
		try {
			System.out.println(futureString.get()); // Blocking Operation
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
	}

	private static void scheduledPoolEx() {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 10; i++) {
			newScheduledThreadPool.scheduleAtFixedRate(new RunnableTask(), 15, 10, TimeUnit.SECONDS);
		}
	}

	private static void basicExecutorService() {
		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) { // 100 Tasks are being executed by 10 Threads // Parallelism
			executor.submit(new RunnableTask());
		}
	}

	private static void naiveWayToCreateThreads() {
		for (int i = 0; i < 11; i++) {
			Thread t = new Thread(new RunnableTask());
			t.setName("" + i);
			t.start();
		}
	}

}

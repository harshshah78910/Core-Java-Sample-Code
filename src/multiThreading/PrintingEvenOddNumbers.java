package multiThreading;

public class PrintingEvenOddNumbers {

	public static void main(String[] args) {
		PrintTask printTask = new PrintTask();
		Thread t1 = new Thread(new TaskEvenOdd(10, printTask, false));
		t1.setName("odd thread");
		Thread t2 = new Thread(new TaskEvenOdd(10, printTask, true));
		t2.setName("Even Thread");
		t1.start();
		t2.start();
	}
}

class TaskEvenOdd implements Runnable {
	private int max;
	private PrintTask print;
	private boolean isEvenNumber;

	// standard constructors

	@Override
	public void run() {
		int number = isEvenNumber ? 2 : 1;
		while (number <= max) {
			if (isEvenNumber) {
				print.printEven(number);
			} else {
				print.printOdd(number);
			}
			number += 2;
		}
	}

	public TaskEvenOdd(int max, PrintTask print, boolean isEvenNumber) {
		super();
		this.max = max;
		this.print = print;
		this.isEvenNumber = isEvenNumber;
	}
}

class PrintTask {
	private volatile boolean isOdd;

	 synchronized void printOdd(int number) {
	        while (isOdd) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        System.out.println(Thread.currentThread().getName() + ":" + number);
	        isOdd = true;
	        notify();
	    }

	synchronized void printEven(int number) {
		while (!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + number);
		isOdd = false;
		notify();
	}

}

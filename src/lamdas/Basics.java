package lamdas;

public class Basics {

	public static void main(String args[]) {

		MyLambda lambdaExample = () -> System.out.println("Function as value using Lambda");
		lambdaExample.lambdaExample();
		lambdaExample.m2();
		//lambdaExample.m1(); // Wont Compile
		MyLambda.m1();
		
		// Runnable Implementation
		Thread thread = new Thread(() -> System.out.println("This is Thread Example"));
		thread.run();
	}

}

@FunctionalInterface
interface MyLambda {
	void lambdaExample();

	static void m1() {
		System.out.println("This is static example");
	}

	default void m2() {
		System.out.println("Default Example");
	}

}

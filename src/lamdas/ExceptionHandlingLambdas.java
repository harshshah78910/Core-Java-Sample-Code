package lamdas;

import java.util.function.BiConsumer;

public class ExceptionHandlingLambdas {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		// int key = 2;
		int key = 0;

		//1. Basic Bi-Consumer Example
		process(arr, key, (k, v) -> System.out.println(k + v));

		//2. Not a Good Practice
		process(arr, key, (k, v) -> {
			try {
				System.out.println(k / v);
			} catch (Exception e) {
				System.out.println("Exception Caught in Lamdas");
			}
		});

		//3. WrapperLamda Example for Exception Handling in Neat way
		process(arr, key, wrapperLambda((k, v) -> System.out.println(k / v)));

	}

	private static void process(int[] arr, int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int i : arr) {
			biConsumer.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		//return (k,v) -> System.out.println("This will Override Previous Lambda");
		return (k,v) -> 
		{
			try
			{
				biConsumer.accept(k, v);
			}
			catch (Exception e) {
				System.out.println("Exception Handling Wrapper for Lamdas");
			}
			
		};
	}

}

package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		//Array
		
		Integer[] myArray = {2,3,4,5,6,4,3,21,3,4};
		
		Stream<Integer> stream = Arrays.stream(myArray); // Stream of Objects 
		Stream<Integer> str1 = Stream.of(myArray);
		
		IntStream str2 = IntStream.of(2,3,4,5,32); // Stream of Primitives 
		
		System.out.println(stream.filter(i -> i > 10).count());
		
		//Collections
		
		List<Double> myList = new ArrayList<Double>();
		List<Double> dummy = new ArrayList<Double>();
		myList.add((double) 23);
		myList.add((double) 7);
		
		myList.stream().filter(i -> i > 5).peek(i -> System.out.println(i)); 
		// will not print since no terminal operation
		
		myList.stream().filter(i -> i > 9).forEach(i -> System.out.print(i));
		
		long count = myList.stream().map(n -> n * n).filter(n -> n>20).count();
		
		
		
		myList.stream().forEach(c -> dummy.add(c));
		System.out.println(dummy);
		System.out.println(count);
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student());
		studentList.add(new Student());
		
		
		List<Student> collect = studentList.stream().collect(Collectors.toList());
		studentList.stream().forEach(st -> st.setId(1));
		
		System.out.println(studentList.get(0).getId());
		
	}

}

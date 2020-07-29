package lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise1 {

	public static void main(String args[]) {

		List<Person> personList = Arrays.asList(new Person(12, "Harsh", "A"), new Person(1, "Aarsh", "B"),
				new Person(2, "Sarsh", "C"));

		// Q1 Sort the List by Last Name
		Comparator<Person> personComparator = (p1, p2) -> {
			return p1.getLastName().compareTo(p2.getLastName());
		};

		Collections.sort(personList, personComparator);

		for (Person p : personList) {
			System.out.println(p.getLastName());
		}

		// Q2 Print the Names that Start with A or Any Condition that we wants
		printConditionally(personList, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getFirstName()));

	}

//	static void printConditionally(List<Person> personList, Condition<Person> condition) {
//		for (Person p : personList) {
//			if (condition.test(p)) {
//				System.out.println(p.getFirstName());
//			}
//		}
//	}

	static void printConditionally(List<Person> personList, Predicate<Person> condition, Consumer<Person> consumer) {
		for (Person p : personList) {
			if (condition.test(p)) {
				consumer.accept(p);
			}
		}
		
		//Lamda Way of Iterating Things // Non-Sequential, Multi-Threading
		personList.forEach((p) -> System.out.println(p.getFirstName()));
		
	}

}

//Own implementation of Predicate
interface Condition<T> {
	boolean test(T t);
}

class Person {
	private int age;
	private String firstName;
	private String lastName;

	public int getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person(int age, String firstName, String lastName) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

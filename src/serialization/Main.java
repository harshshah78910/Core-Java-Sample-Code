package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setId("13");
		e.setName("Harsh");
		e.setDepartment("CSE");

		doSerialization(e);

		doDeserialization();
	}

	private static void doDeserialization() {
		Employee e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("employee.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.getName());
	      System.out.println("Address: " + e.getId());
	      System.out.println("SSN: " + e.getDepartment());
		
	}

	private static void doSerialization(Employee e) {
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in employee.ser");
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

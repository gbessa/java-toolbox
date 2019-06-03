package br.com.hoptech.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {

	public static void main(String[] args) {

		String course_1 = "JAVA Fundamentals";
		String course_2 = "JAVA Intermediate";
		String course_3 = "JAVA Advanced";

		ArrayList<String> courses = new ArrayList<String>();
		courses.add(course_1);
		courses.add(course_2);
		courses.add(course_3);

		System.out.println("=== FULL ARRAY ===");
		courses.forEach(course -> System.out.println(course));

		//Reading by index
		System.out.println("\nThe first course is: " + courses.get(0) + " of " + courses.size() + " courses.");

		//Sorting - Default for string is Alphabet
		courses.sort(null);
		//or
		Collections.sort(courses);
		
		System.out.println("\n=== Sorted List===");
		courses.forEach(course -> System.out.println(course));

		//Removing by the index
		courses.remove(1);

		System.out.println("\n=== Second position removed ===");
		courses.forEach(course -> System.out.println(course));


	}

}

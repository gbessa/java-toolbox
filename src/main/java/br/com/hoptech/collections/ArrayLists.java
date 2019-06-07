package br.com.hoptech.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.hoptech.foobar.Client;

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
		
		System.out.println("\n=== Sorted List ===");
		courses.forEach(course -> System.out.println(course));

		//Removing by the index
		courses.remove(1);

		System.out.println("\n=== Second position removed ===");
		courses.forEach(course -> System.out.println(course));
		
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(new Client("Lauro", "Sodre", "21-909099992"));
		clients.add(new Client("Gustavo", "Bessa", "21-909099991"));
		clients.add(new Client("Marcos", "Frota", "21-909099993"));
		
		Client clientToRepeat = new Client("Fernando", "Bezerra", null);
		clients.add(clientToRepeat);
		
		System.out.println("\n=== Inicial Object List ===");
		clients.forEach(client -> System.out.println(client));
		
		clients.sort(null);
		System.out.println("\n=== Sorted Object List ===");
		clients.forEach(client -> System.out.println(client));
		
		Collections.sort(clients, Comparator.comparing(Client::getLastName));
		System.out.println("\n=== Sorted Object List by Last Name ===");
		clients.forEach(client -> System.out.println(client));
		
		// A List aceita repetição de items
		System.out.println("\n=== C/ ITEM REPETIDO ===");
		clients.add(clientToRepeat);
		clients.forEach(client -> System.out.println(client));
	}

}

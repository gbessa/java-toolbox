package br.com.hoptech.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.hoptech.foobar.Client;

public class Sets {

	public static void main(String[] args) {

		Set<Client> clients = new HashSet<>();
		clients.add(new Client("Gustavo", "Bessa", null));
		clients.add(new Client("Nuno", "Lisboa", null));
		clients.add(new Client("José", "Braga", null));
		
		// Até aqui o SET parece ter o mesmo comportamento do LIST
		clients.forEach(client -> System.out.println(client));
	
		clients.add(new Client("Antonio", "Freitas", null));
		clients.add(new Client("Carlos", "França", null));
		
		Client clientToRepeat = new Client("Fernando", "Bezerra", null);
		clients.add(clientToRepeat);
		
		// Nesse momento já se observa que não manteve a ordem de inserção
		System.out.println("\n=== MAIS ITEMS ===");
		clients.forEach(client -> System.out.println(client));
		
		// Uma das maiores vantagens de se trabalhar com SET é que ele não insere um item se ele já existir na lista
		System.out.println("\n=== C/ ITEM REPETIDO ===");
		clients.add(clientToRepeat);
		clients.forEach(client -> System.out.println(client));
		
		System.out.println("\n=== CONTAINS ===");		
		System.out.println(clients.contains(clientToRepeat));
		
		// Os Sets (conjuntos) não são ordenáveis, mas podemos fazer uma transformação para List
		// Collections.sort(clients);
		System.out.println("\n=== ORDENANDO COMO LIST ===");
		List<Client> clientsList = new ArrayList<Client>(clients);
		Collections.sort(clientsList);
		clientsList.forEach(client -> System.out.println(client));
		
	}

}

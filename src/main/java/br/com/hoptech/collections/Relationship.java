package br.com.hoptech.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.hoptech.foobar.Client;
import br.com.hoptech.foobar.Company;

public class Relationship {

	public static void main(String[] args) {

		Company company = new Company("HOPTECH", "21-01212211");
		
		List<Client> clientsImutable = company.getClients();
		
		// Funciona, mas não é uma boa pratica. Melhor delecar para Company a função de adicionar cliente
		// Então uma boa prática seria inclusive Company devolver uma lista de clientes Unmodifiable
		// Assim não poderemos manipulá-la como era feito abaixo
		// clients.add(new Client("Gustavo", "Bessa", "21-98989898"));		
		System.out.println(company.getClients());
		
		company.add(new Client("Gustavo", "Bessa", "21-98989898"));
		company.add(new Client("Billy", "The Kid", "21-98989891"));
		company.add(new Client("Alvaro", "Dias", null));
		
		company.getClients().forEach(client -> System.out.println(client));
		
		// Não funcionaria pois temos um objeto protegido pela imutabilidade
		// Collections.sort(clientsImutables);
		
		System.out.println("\n=== Mutable Sorteded ===");
		List<Client> clientsMutable = new ArrayList<>(company.getClients());
		Collections.sort(clientsMutable);
		clientsMutable.forEach(client -> System.out.println(client));
		
	}

}

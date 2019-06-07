package br.com.hoptech.foobar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

	private String name;
	private String phoneNumer;
	private List<Client> clients = new ArrayList<Client>();
	
	public Company(String name, String phoneNumer) {
		super();
		this.name = name;
		this.phoneNumer = phoneNumer;
	}

	public String getName() {
		return name;
	}
	
	public String getPhoneNumer() {
		return phoneNumer;
	}
	
	public List<Client> getClients() {
		return Collections.unmodifiableList(clients);
	}
	
	public void add(Client client) {
		this.clients.add(client);
	}
}

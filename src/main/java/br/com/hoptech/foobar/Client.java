package br.com.hoptech.foobar;

import java.io.Serializable;

public class Client implements Serializable, Comparable<Client> {
	private static final long serialVersionUID = 1L; // Funciona como um versionamento da classe. Usado para manter a compatibilidade quando existem mudanças na classe.
	
	private	String firtName;
	private String lastName;
	private String phoneNumer;
	private transient String id; //Não fará parte da serialização
	
	public Client() {
	}
	
	public Client(String firtName, String lastName, String phoneNumer) {
		this.firtName = firtName;
		this.lastName = lastName;
		this.phoneNumer = phoneNumer;
	}
	
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumer() {
		return phoneNumer;
	}
	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Client [firtName=" + firtName + ", lastName=" + lastName + ", phoneNumer=" + phoneNumer + "]";
	}

	@Override
	public int compareTo(Client o) {
		return this.firtName.compareTo(o.getFirtName());
	}

	// SEMPRE que implementarmos um EQUALS, devemos implementar o HASCODE com o mesmo critério. Senão haverá inconsistências.
	// Exemplo. O EQUALS implementado não considera o PHONE na comparação.
	// Portanto o Phone não deve entrar no calculo do hashcode.

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (firtName == null) {
			if (other.firtName != null)
				return false;
		} else if (!firtName.equals(other.firtName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firtName == null) ? 0 : firtName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
	
}

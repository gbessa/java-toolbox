package br.com.hoptech.foobar;

import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L; // Funciona como um versionamento da classe. Usado para manter a compatibilidade quando existem mudanças na classe.
	
	private	String firtName;
	private String lastName;
	private String phoneNumer;
	private transient String id; //Não fará parte da serialização
	
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

}

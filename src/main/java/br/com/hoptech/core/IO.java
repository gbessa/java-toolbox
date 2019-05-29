package br.com.hoptech.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.hoptech.foobar.Client;

public class IO {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		// Serialização - transformação de um objeto em um fluxo binário
		serializationOut();
		// Desserialização
		serializationIn();
		
	}

	private static void serializationOut() throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.bin"));

		String name = "Gustavo Bessa";

		Client client = new Client();
		client.setFirtName("Gustavo");
		client.setLastName("Bessa");
		client.setPhoneNumer("999-999-999");

//		oos.writeObject(name);
		oos.writeObject(client); //só pode serializar se a classe implementar a interface Serializable
		oos.close();

	}
	
	private static void serializationIn() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.bin"));
		
//		String obj = (String) ois.readObject();
		Client obj = (Client) ois.readObject();
		
		System.out.println(obj);
		System.out.println(obj.getFirtName());
		
	}
}


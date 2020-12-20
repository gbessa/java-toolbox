package br.com.hoptech.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * É uma forma alternativa e mais clean para representar uma Lambda
 * O method reference a essa forma de dizer qual classe e qual metodo voce que executar
 * Java vai converter isso para uma Lambda function
 *
 * Tipos:
 * 	Método Estático
 */
public class MethodReference {

    public static void main(String[] args) {

		List<String> myList = new ArrayList<String>();
		myList.add("02. two");
		myList.add("03. three");
		myList.add("01. one");
		myList.add("04. four");

		/**
		 * Antes e Depois
		 */
		//BEFORE
		myList.sort((String s1, String s2) -> s1.length() - s2.length());
		//AFTER
		myList.sort(Comparator.comparing(String::length));

		//BEFORE
		myList.forEach(val -> System.out.println(val));
		//AFTER
		myList.forEach(System.out::println);

		//BEFORE
		Function<Usuario, String> funcao = u -> u.getNome();
		//AFTER
		Function<Usuario, String> funcaoAfter = Usuario::getNome;

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		/**
		 * Tipo: Com método Stático
		 */
		list.stream()
				.map(MethodReference::sum10)
				.forEach(System.out::println);

		/**
		 * Tipo: Com contrutores
		 */
		list.stream()
				.map(BigDecimal::new)
				.forEach(System.out::println);

		/**
		 * Tipo: Com uma instância
		 */
		BigDecimal b = new BigDecimal(2);
		list.stream()
				.map(BigDecimal::new)
				.map(b::multiply)
				.forEach(System.out::println);

	
    }

    public static int sum10(int val) {
    	return val+10;
    }

	public int sum20(int val) {
		return val+20;
	}
    
}

class Usuario {
    
    private String nome;
    
    public String getNome() {
	return nome;
    }
    
}

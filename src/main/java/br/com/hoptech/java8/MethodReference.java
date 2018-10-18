package br.com.hoptech.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReference {

    public static void main(String[] args) {

	List<String> myList = new ArrayList<String>();
	myList.add("02. two");
	myList.add("03. three");
	myList.add("01. one");
	myList.add("04. four");
	
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
	
	//O method reference é essa forma de dizer qual classe e qual método você que executar
	//O Java vai converter isso para uma Lambda function
	//Isso é aplicável em casos simples como esses
	
    }
    
}

class Usuario {
    
    private String nome;
    
    public String getNome() {
	return nome;
    }
    
}

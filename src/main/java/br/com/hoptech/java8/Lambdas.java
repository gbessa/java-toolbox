package br.com.hoptech.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lambdas {

    public static void main(String[] args) {

	List<String> myList = new ArrayList<String>();
	myList.add("02. two");
	myList.add("03. three");
	myList.add("01. one");
	myList.add("04. four");
	
	/*BEFORE
	Essa é uma forma de não precisarmor criar uma classe muito simples
	Criamos ela diretamente na passagem dela como parametro
	Isso se chama Classe Anônima (chama-se anônima pois não demos nome para ela) */
	myList.sort(new Comparator<String>() {
	    @Override
	    public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	    }
	});
	
	/*AFTER
	Nesse caso o Java infere que o método escrito refere-se a implementação do compare(), 
	pois o mesmo é obrigatório na implementação da classe, e seu comportamento é compatível.
	Mas isso só funciona se a interface tiver apenas 1 método (chamados de Interface Funcional)
	*/
	myList.sort((String s1, String s2) -> s1.length() - s2.length());
	
	
	//BEFORE - outro exemplo
	myList.forEach(new Consumer<String>() {
	    @Override
	    public void accept(String t) {
		System.out.println(t);	
	    }  
	});
	
	/*AFTER
	As arrow functions vieram simplificar esse código (como já tinha no JS) */
	myList.forEach(val -> System.out.println(val));
	
	
    }

}

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
	Essa � uma forma de n�o precisarmor criar uma classe muito simples
	Criamos ela diretamente na passagem dela como parametro
	Isso se chama Classe An�nima (chama-se an�nima pois n�o demos nome para ela) */
	myList.sort(new Comparator<String>() {
	    @Override
	    public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	    }
	});
	
	/*AFTER
	Nesse caso o Java infere que o m�todo escrito refere-se a implementa��o do compare(), 
	pois o mesmo � obrigat�rio na implementa��o da classe, e seu comportamento � compat�vel.
	Mas isso s� funciona se a interface tiver apenas 1 m�todo (chamados de Interface Funcional)
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
	As arrow functions vieram simplificar esse c�digo (como j� tinha no JS) */
	myList.forEach(val -> System.out.println(val));
	
	
    }

}

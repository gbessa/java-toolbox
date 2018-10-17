package br.com.hoptech.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Consumer;

public class DefaultMethods {

    public static void main(String[] args) {

	//ORDENATION

	//BEFORE
	List<String> myList = new ArrayList<String>();
	myList.add("02. two");
	myList.add("03. three");
	myList.add("01. one");
	myList.add("04. four");

	Collections.sort(myList);
	System.out.println(myList);	

	Collections.sort(myList, new ComparatorBySyze());
	System.out.println(myList);	

	Collections.sort(myList);
	System.out.println(myList);	

	//AFTER
	myList.sort(new ComparatorBySyze());
	System.out.println(myList);	

	//	O Sort é um método implementado na interface Set. Podemos fazer isso agora com o modificador Default
	//	Se não fosse assim, e incluíssemos um método novo na interface List, todas as implementações dela iriam quebrar

	//	@SuppressWarnings({"unchecked", "rawtypes"})
	//	default void sort(Comparator<? super E> c) {
	//	    Object[] a = this.toArray();
	//	    Arrays.sort(a, (Comparator) c);
	//	    ListIterator<E> i = this.listIterator();
	//	    for (Object e : a) {
	//		i.next();
	//		i.set((E) e);
	//	    }
	//	}

	//BEFORE
	for(String val : myList) {
	    System.out.println(val);
	}

	//AFTER
	Consumer consumer = new PrintElement();
	myList.forEach(consumer);
	
	//AFTER WITH ARROW FUNCTION
	myList.forEach(val -> System.out.println(val));

//	O foreach tb foi um default method inserido na interface Iterable

//	default void forEach(Consumer<? super T> action) {
//	    Objects.requireNonNull(action);
//	    for (T t : this) {
//		action.accept(t);
//	    }
//	}	

    }

}

class ComparatorBySyze implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
	return s1.length() - s2.length();
    }

}

class PrintElement implements Consumer<String> {

    @Override
    public void accept(String t) {
	System.out.println(t);	
    }
    
}

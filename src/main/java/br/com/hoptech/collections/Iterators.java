package br.com.hoptech.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterators {
    

    public static void main(String []args){
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("Hello");
        mylist.add("Java");
        mylist.add("4");
        Iterator<String> it = mylist.iterator();
        while(it.hasNext()){
            Object element = it.next();
            System.out.println((String)element);
        }
    }
    

}

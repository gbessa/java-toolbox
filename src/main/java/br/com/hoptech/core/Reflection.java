package br.com.hoptech.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;


public class Reflection {

    public static void main(String[] args) {

        Class<Student> student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<String>();
        for(int i=0; i<methods.length; i++){
            methodList.add(methods[i].getName());
            System.out.println(methods[i].getName());
        }
        
        System.out.println("-------------------------------------------");
        
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
	
    }
    
    class Student{
	
	    private String name;
	    private String id;
	    private String email;

	    public String getName() {
	        return name;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public void anothermethod(){  }
	}

}

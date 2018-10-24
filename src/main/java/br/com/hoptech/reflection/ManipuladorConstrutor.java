package br.com.hoptech.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {

    private Constructor<?> construtor;

    public ManipuladorConstrutor(Constructor<?> construtor) {
	this.construtor = construtor;
	
    }

    public Object invoca() {
	try {
	    construtor.setAccessible(true);
	    return construtor.newInstance();
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
	    e.printStackTrace();
	    return new RuntimeException(e);
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	    return new RuntimeException("Erro no construtor!", e.getTargetException());
	}
    }

}

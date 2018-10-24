package br.com.hoptech.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassMethod {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
	//FORMA REFATORADA
	String nomeMetodo = "metodoPrivadoSub";
	Object retorno = new Reflexao()
		.refleteClasse("br.com.hoptech.reflection.ExemploSubController")
		.criaInstancia()
		.getMetodo(nomeMetodo)
		.invoca();
	System.out.println("Retorno da forma refatorada: " + retorno);

	Class<?> classSubController = Class.forName("br.com.hoptech.reflection.ExemploSubController");
	
	Constructor<?> construtorPadrao = classSubController.getDeclaredConstructor();
	construtorPadrao.setAccessible(true);
	Object instancia = construtorPadrao.newInstance();
	
	//Lista os Métodos Públicos da Classe
	//E inclusive da super classe e de possíveis interfaces
	for (Method method : classSubController.getMethods()) {
	    System.out.println(method);
	}
	
	System.out.println("/////////////////////////////");
	
	//Lista os métodos publicos e privados - mas só da classe em questão
	for (Method method : classSubController.getDeclaredMethods()) {
	    System.out.println(method);
	}
	
	Method m = classSubController.getDeclaredMethod("metodoPublicoSub");
	m.invoke(instancia);
	
	m = classSubController.getDeclaredMethod("metodoPrivadoSub");
	m.setAccessible(true);
	retorno = m.invoke(instancia);
	System.out.println(retorno);
    
	
    }


}

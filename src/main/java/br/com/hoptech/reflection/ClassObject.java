package br.com.hoptech.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Formas de instanciar o Class Object
 */
public class ClassObject {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	//Basicamente pelo insegurança devido ao newInstance não nos avisar se a classe recebe no contrutor objetos de classes que possuem Checked Exceptions

	//->-> Pelo .class da classe
	Class<ExemploController> classCtrl1 = ExemploController.class;
	ExemploController objCtrl1 = classCtrl1.newInstance(); //Deprecated
	
	Constructor<ExemploController> constructor = classCtrl1.getConstructor();
	ExemploController objCtrl11 = constructor.newInstance();
	//obs: 
	//se o contrutor fosse privado, teria que pegar ele pelo getDeclaredContructor(), e deixá-lo acessível pelo .setAcessible(true)
	
	//->-> Pelo .getClass
	ExemploController exemploControler = new ExemploController();
	Class<? extends ExemploController> classCtrl2 = exemploControler.getClass();
	ExemploController objCtrl2 = classCtrl2.newInstance(); //Deprecated
	
	//->-> Pelo .formName passando o Fully Qualified Name
	Class<?> classCtrl3 = Class.forName("br.com.hoptech.reflection.ExemploController");
	Object objCtrl3 = classCtrl3.newInstance(); //Deprecated
	
	//Verifica-se que todos os objetos são instâncias de ExemploController
	System.out.println(objCtrl1 instanceof ExemploController);
	System.out.println(objCtrl11 instanceof ExemploController);
	System.out.println(objCtrl2 instanceof ExemploController);
	System.out.println(objCtrl3 instanceof ExemploController);
	
	//A terceira forma é a mais flexível, e é a que frameworks MVC (como vraptor/spring) usam
	
	//O newInstance foi depreciado a partir da versão 9
	
    }

}

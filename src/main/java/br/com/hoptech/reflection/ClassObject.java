package br.com.hoptech.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Formas de instanciar o Class Object
 */
public class ClassObject {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	//Basicamente pelo inseguran�a devido ao newInstance n�o nos avisar se a classe recebe no contrutor objetos de classes que possuem Checked Exceptions

	//Pela forma refatorada
	Object instanciaControle = new Reflexao()
		.refleteClasse("br.com.hoptech.reflection.ExemploController")
		.getConstructorPadrao()
		.invoca();
		
	//->-> Pelo .class da classe
	//O newInstance da classe Classe foi depreciado a partir da versao 9
	Class<ExemploController> classCtrl1 = ExemploController.class;
	ExemploController objCtrlDeprec = classCtrl1.newInstance(); //Deprecated
	
	Constructor<ExemploController> constructor = classCtrl1.getConstructor();
	ExemploController objCtrl1 = constructor.newInstance();
	//obs: 
	//se o contrutor fosse privado, teria que pegar ele pelo getDeclaredContructor(), e deixa-lo acessivel pelo .setAcessible(true)
	
	//->-> Pelo .getClass
	ExemploController exemploControler = new ExemploController();
	Class<? extends ExemploController> classCtrl2 = exemploControler.getClass();
	ExemploController objCtrl2 = classCtrl2.newInstance(); //Deprecated
	
	//->-> Pelo .formName passando o Fully Qualified Name
	//Essa forma e a mais flexivel, e e a que frameworks MVC (como vraptor/spring) usam
	Class<?> classCtrl3 = Class.forName("br.com.hoptech.reflection.ExemploController");
	Object objCtrl3 = classCtrl3.newInstance(); //Deprecated
	
	//Verifica-se que todos os objetos são instancias de ExemploController
	System.out.println(objCtrlDeprec instanceof ExemploController);
	System.out.println(objCtrl1 instanceof ExemploController);
	System.out.println(objCtrl2 instanceof ExemploController);
	System.out.println(objCtrl3 instanceof ExemploController);
	System.out.println(instanciaControle instanceof ExemploController);
	
    }

}

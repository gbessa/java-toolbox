package br.com.hoptech.reflection;

/**
 * Formas de instanciar o Class Object
 */
public class ClassObject {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

	//Pelo .class da classe
	Class<ExemploController> classCtrl1 = ExemploController.class;
	ExemploController objCtrl1 = classCtrl1.newInstance();
	
	//Pelo .getClass
	ExemploController exemploControler = new ExemploController();
	Class<? extends ExemploController> classCtrl2 = exemploControler.getClass();
	ExemploController objCtrl2 = classCtrl2.newInstance();
	
	//Pelo .formName passando o Fully Qualified Name
	Class<?> classCtrl3 = Class.forName("br.com.hoptech.reflection.ExemploController");
	Object objCtrl3 = classCtrl3.newInstance();
	
	//Verifica-se que todos os objetos são instâncias de ExemploController
	System.out.println(objCtrl1 instanceof ExemploController);
	System.out.println(objCtrl2 instanceof ExemploController);
	System.out.println(objCtrl3 instanceof ExemploController);
	
	//A terceira forma é a mais flexível, e é a que frameworks MVC (como vraptor/spring) usam
	
    }

}

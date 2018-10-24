package br.com.hoptech.reflection;

public class ExemploSubController extends ExemploController {

    private ExemploSubController() {}
    
    private ExemploSubController(String s) {}
    
    public void metodoPublicoSub() {
	System.out.println("Executando o método publico da classe ExemploSubController");
    }
    
    private String metodoPrivadoSub() {
	System.out.println("Executando o método privado da classe ExemploSubController");
    
	return "Retorno do método metodoPrivado";
    }
    
}

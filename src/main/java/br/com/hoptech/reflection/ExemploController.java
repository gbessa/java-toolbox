package br.com.hoptech.reflection;

import java.util.ArrayList;
import java.util.List;

public class ExemploController {

    private List<String> lista = new ArrayList<String>();
    
    public ExemploController() {}
    
    private ExemploController(String s, String t) {}
    
    public List<String> getLista() {
	return lista;
    }
    
    private void metodoPrivado() {}

}

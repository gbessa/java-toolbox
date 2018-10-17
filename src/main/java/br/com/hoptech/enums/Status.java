package br.com.hoptech.enums;

public enum Status {
    OPEN("Aberto"), CLOSED("Fechado");
    
    public String statusDescription;
    
    Status(String value) {
	statusDescription = value;
    }
}

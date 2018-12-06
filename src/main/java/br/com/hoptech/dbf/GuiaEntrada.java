package br.com.hoptech.dbf;

public class GuiaEntrada {
	
	public String numGec;
	public String codDep;
	
	public GuiaEntrada(String numGec, String codDep) {
		super();
		this.numGec = numGec;
		this.codDep = codDep;
	}

	@Override
	public String toString() {
		return "GuiaEntrada [numGec=" + numGec + ", codDep=" + codDep + "]";
	}
		
}

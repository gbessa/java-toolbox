package br.com.hoptech.hrank;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

    public static void main(String []argh)
    {
	Scanner sc = new Scanner(System.in);

	while (sc.hasNext()) {
	    String input=sc.next();

	    System.out.println(isBalanced(input));
	}
	sc.close();

//	System.out.println(isBalanced("{"));
//	System.out.println(isBalanced("({()})"));
//	System.out.println(isBalanced("{}("));
//	System.out.println(isBalanced("({}[])"));
//	System.out.println(isBalanced("(({()})))"));
	
    }
    
    public static boolean isBalanced(String testString) { 
	
	if (testString.equals("")) return true;
	Stack<String> pilha = new Stack<String>();
	    String[] symbols = testString.split("");
	    for (String symbol : symbols) {
		if (!symbol.matches("^[\\s)(\\]\\[}{]")) return false;
		if (symbol.equals("{") || symbol.equals("[") || symbol.equals("(")) {
		    pilha.push(symbol);
		}    else {
		    if (pilha.empty()) return false;
		    if (symbol.equals(")") && pilha.peek().equals("(")) pilha.pop();
        	    if (symbol.equals("]") && pilha.peek().equals("[")) pilha.pop();
        	    if (symbol.equals("}") && pilha.peek().equals("{")) pilha.pop();
		}  
	    }
	    return pilha.isEmpty();
	
    }
}

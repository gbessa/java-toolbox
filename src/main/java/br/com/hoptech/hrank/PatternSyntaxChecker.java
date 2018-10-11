package br.com.hoptech.hrank;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker {

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int testCases = Integer.parseInt(in.nextLine());
	while(testCases>0){
	    String pattern = in.nextLine();
	    
	    String retorno = isValid(pattern) ? "Valid" : "Invalid";
	    
	    System.out.println(retorno);
	    
	}
	in.close();

//	System.out.println(isValid("([A-Z])(.+)"));
    
    }
    
    
    
    public static boolean isValid(String strPattern) {
	try {
	    Pattern p = Pattern.compile(strPattern);
	    return true;

	} catch (PatternSyntaxException e) {
	    return false;
	}
	
    }

}

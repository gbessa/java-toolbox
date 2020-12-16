package br.com.hoptech.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlHandle {

    public static void main(String[] args) {

	String line = "<h1>teste 123</h1>";

	boolean matchFound = false;
	Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
	// <(.+)>  Pega tag de inicio com qualquer conteudo
	// ([^<]+) Pega qualquer conjunto de caracteres, exceto <
	// </\\1>  Pega tag de fechamento, onde o tipo da TAB da match com a tag de abertura
	
	Matcher m = r.matcher(line);

	while (m.find()) {
	    System.out.println(m.group(2));
	    matchFound = true;
	}
	
	if ( ! matchFound) {
	    System.out.println("None");
	}

    }

}

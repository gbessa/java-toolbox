package br.com.hoptech.core;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Unicode {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String s = "1°";
		System.out.println(s.codePointAt(0));  //Codepoint é a representação decimal na tabela unicode (tabela universal de todos os caracteres)
		System.out.println(s.codePointAt(1));
		
		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName());	//Verifica o Charset usado para fazer o encoding do Unicode para o SO (windows-1252 / UTF-8, etc)
		
		byte[] bytes = s.getBytes();
		System.out.println(bytes.length + " bytes no " + charset.displayName() + " (default)");
		
		byte[] bytesUTF16 = s.getBytes("UTF-16");
		System.out.println(bytesUTF16.length + " bytes no UTF-16");
		String sNovo = new String(bytesUTF16);
		System.out.println(sNovo); // Vai dar erro pois estou inserindo um unicode codado em UTF-16 em um charset UTF-8 (no caso do linux)
		sNovo = new String(bytesUTF16, StandardCharsets.UTF_16);
		System.out.println(sNovo + " => (solução)");	// Solução
		
		byte[] bytesUS_ASCII = s.getBytes(StandardCharsets.US_ASCII);
		System.out.println(bytesUS_ASCII.length + " bytes no US_ASCII");
		sNovo = new String(bytesUS_ASCII);
		System.out.println(sNovo);
		
	}

}

package br.com.hoptech.formatting;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatting {

    public static void main(String[] args) throws ParseException {
	
	double payment = 10000.0;

	NumberFormat nf;
	
	nf = NumberFormat.getCurrencyInstance(Locale.US);
	String us = nf.format(payment);
	
	nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
	String india = nf.format(payment);
	
	nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
	String china = nf.format(payment);
	
	nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	String france = nf.format(payment);
    	
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    	
    }
    
    
}

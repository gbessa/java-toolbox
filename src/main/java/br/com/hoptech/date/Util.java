package br.com.hoptech.date;

import java.util.Calendar;

public class Util {

    public static void main(String[] args) {

	//DATA ATUAL
	Calendar cal = Calendar.getInstance();

	//ALTERANDO DATA
	cal.set(2013, 11, 28);
	
	System.out.println(String.format("%tA", cal.getTime()).toUpperCase());
	
    }

}

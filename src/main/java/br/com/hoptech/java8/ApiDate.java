package br.com.hoptech.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ApiDate {

    public static void main(String[] args) {
	
	//Foi implementado muita coisa da JODA TIME

	LocalDate hoje = LocalDate.now();
	System.out.println(hoje);
	
	LocalDate diaD = LocalDate.of(2019, Month.JANUARY, 18);
	
	Period periodo = Period.between(hoje, diaD);
	System.out.println("Faltam: " + periodo.getMonths() + " meses e " + periodo.getDays() + " dias.");
	
	LocalDate depoisDeUmAno = diaD.plusYears(1); //Atribuimos, pois o localDate é imutavel
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	System.out.println("Depois de 1 ano: " + depoisDeUmAno.format(formatter));
	
	LocalDateTime agora = LocalDateTime.now();
	System.out.println("Agora: " + agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
	
	// Classe para guardar mes e ano - evita ter que quardar o dia desnecessariamente
	YearMonth mesDoAno = YearMonth.now();
	System.out.println(mesDoAno);
	
	LocalTime horario = LocalTime.of(5, 10);
	System.out.println("Horário: " + horario);
	
	
    }

}

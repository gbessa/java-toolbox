package br.com.hoptech.enums;

public class TestEnums {

    public static void main(String[] args) {
	
	System.out.println(Status.CLOSED + " => " + Status.CLOSED.statusDescription);
	
	System.out.println(CardsEnum.A + " => " + CardsEnum.A.cardValue);
	
    }

}

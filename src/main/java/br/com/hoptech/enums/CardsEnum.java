package br.com.hoptech.enums;

public enum CardsEnum {
    
    J(11),Q(12),K(13),A(14);

    public int cardValue;
    
    CardsEnum(int value) {
	cardValue = value;
    }
    
}

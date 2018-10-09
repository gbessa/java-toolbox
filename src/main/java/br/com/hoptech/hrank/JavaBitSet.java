package br.com.hoptech.hrank;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class JavaBitSet {

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	
	int N = scan.nextInt();
	int M = scan.nextInt();
	String result = "";
	
	List<BitSet> bn = new ArrayList<BitSet>(); 
	bn.add(new BitSet(N));
	bn.add(new BitSet(N));
	
	for (int i=0; i<M; i++) {
	    
	    String operation = scan.next();
	    int par1 = scan.nextInt();
	    int par2 = scan.nextInt();
	    
	    switch (operation) {
	    case "AND":
		bn.get(par1-1).and(bn.get(par2-1));
		
		break;
	    case "OR":
		bn.get(par1-1).or(bn.get(par2-1));
		
		break;
	    case "XOR":
		bn.get(par1-1).xor(bn.get(par2-1));
		
		break;
	    case "FLIP":
		bn.get(par1 - 1).flip(par2);;
		
		break;
		
	    case "SET":
		bn.get(par1 - 1).set(par2);
		
		break;
		
	    default:
		break;
	    }
	    
	    result += setBits(bn.get(0)) + " " + setBits(bn.get(1)) + "\n"; 
	}
	
	scan.close();
	    
	System.out.println(result);
	
    }
    
    public static int setBits(BitSet bs) {
	int setBits = 0; 
	for (int i=0; i<bs.size(); i++) {
	    if (bs.get(i)) setBits++;
	    
	}
	return setBits;
    }

}

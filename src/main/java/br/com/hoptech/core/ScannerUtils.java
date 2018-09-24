package br.com.hoptech.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerUtils {

    public static void main(String[] args) throws FileNotFoundException {
	
	Scanner scanner = new Scanner(new File("file.csv"));
	
	while (scanner.hasNextLine()) {
	    String line = scanner.nextLine();
	    
	    Scanner lineScanner = new Scanner(line);
	    lineScanner.useDelimiter(",");
	    
	    String pos1 = lineScanner.next();
	    Integer pos2 = lineScanner.nextInt();
	    Boolean pos3 = lineScanner.nextBoolean();
	    Double pos4 = lineScanner.nextDouble();
	    
	}
	
    }
    
    
    
}

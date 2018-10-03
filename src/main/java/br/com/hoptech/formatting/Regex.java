package br.com.hoptech.formatting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    
//	https://regexr.com/
//	https://regex101.com/


    private static Pattern pattern = Pattern.compile("(\\d\\d)(\\w)"); // tem que escapar as barras

    public static void main(String[] args) {

        Matcher matcher = pattern.matcher("11a22b33c");
        
        while(matcher.find()) {
            String match = matcher.group();
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);

            int start = matcher.start();
            int end = matcher.end();

            System.out.printf("%s | %s |  %s [%d,%d] %n", match, group1, group2, start, end);
        }
        
        System.out.println("12-10-2018".replaceAll("-", "/"));
        
    }
    
}

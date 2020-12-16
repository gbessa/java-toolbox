package br.com.hoptech.challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestPassword {
    public static void main(String[] args) {
        String input = "test 5 a0A pass007 ?xy1 1WeRtYuIoPs22";
        System.out.println(new LongestPassword().run(input));
    }

    int run(String S) {
        String[] lista = S.split(" ");
        int maxSize = -1;
        Pattern patternDigit = Pattern.compile("[0-9]");
        Pattern patternLetter = Pattern.compile("[A-z]");
        for (String v : lista) {
            Matcher matcher1 = patternDigit.matcher(v);
            long digits = 0;
            while (matcher1.find()) digits++;
            Matcher matcher2 = patternLetter.matcher(v);
            long letters = 0;
            while (matcher2.find()) letters++;
            if (digits%2==1 && letters%2==0 && digits+letters==v.length()) {
                if (v.length() > maxSize) maxSize = v.length();
            }
        }
        return maxSize;
    }
}

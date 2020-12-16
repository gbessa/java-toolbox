package br.com.hoptech.challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(new BinaryGap().run(529));
    }

    public int run(int N) {
        String binaryString = Integer.toBinaryString(N);
        Pattern patternBinaryGap = Pattern.compile("10+1");
        Matcher matcher = patternBinaryGap.matcher(binaryString);
        int startPosition = 0;
        int maxGap = 0;
        while (matcher.find(startPosition)) {
            int gap = matcher.end() - matcher.start() - 2;
            startPosition = matcher.end()-1;
            if (gap > maxGap) maxGap = gap;
        }
        return maxGap;
    }

}

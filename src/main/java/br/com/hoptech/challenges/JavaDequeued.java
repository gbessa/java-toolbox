package br.com.hoptech.challenges;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class JavaDequeued {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        File file = new File("/Users/gbessa/Workspaces/intellij/java-toolbox/src/main/java/br/com/hoptech/challenges/java_dequeued.txt");
        try {

            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                Deque<Integer> deque = new ArrayDeque<>();
                int n = in.nextInt();
                int m = in.nextInt();
                int num;
                long max = 0;
                long dequeSize;
                Set<Integer> uniques = new HashSet();

                // 6 3
                // 5 3 5 2 3 2

                for (int i = 0; i < n; i++) {
                    num = in.nextInt();

                    deque.add(num);
                    uniques.add(num);

                    if (deque.size()==m+1) { // 4
                        //dequeSize = deque.stream().distinct().count();

                        int q_out = (int) deque.removeFirst();

                        if (!deque.contains(q_out)) {
                            uniques.remove(q_out);
                        }
                        //if (dequeSize > max) max = dequeSize;
                        //deque.removeFirst();
                    }
                    max = Math.max(uniques.size(), max);

                }
                System.out.println(max);
                System.out.println(max == 94531);

                long endTime = System.nanoTime();
                // get difference of two nanoTime values
                long timeElapsed = endTime - startTime;
                System.out.println("Execution time in seconds : " + timeElapsed / 1000000000);

            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

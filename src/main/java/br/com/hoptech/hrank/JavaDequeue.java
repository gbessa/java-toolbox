package br.com.hoptech.hrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaDequeue {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Deque deque = new ArrayDeque<>();
	int n = in.nextInt();
	int m = in.nextInt();

	int maxSize = 0;
	int maxNotAdds = m;

	for (int i = 0; i < n; i++) {
	    int num = in.nextInt();
	    deque.add(num);

	    if (deque.size() == m) {

		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		int countNotAdds = 0;
		for(Iterator<Integer> itr = deque.iterator(); itr.hasNext();)  {
		    if (!linkedHashSet.add(itr.next())) countNotAdds++;
		    if (countNotAdds >= maxNotAdds) break;
		}
		for (int j = 0; j < m; j++) {
		    if (!linkedHashSet.add(num)) countNotAdds++;
		    if (countNotAdds >= maxNotAdds) break;
		}
		if (linkedHashSet.size()>maxSize) maxSize = linkedHashSet.size();
		maxNotAdds = countNotAdds;

		deque.removeFirst();
	    }

	}

	System.out.println(maxSize);


    }

}

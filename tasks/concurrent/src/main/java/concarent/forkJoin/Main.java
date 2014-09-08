package concarent.forkJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static List<Integer> INTS = new ArrayList<Integer>();
	static {
		Random random = new Random();
		for (int i = 0; i < 3000000; i++) {
			INTS.add(random.nextInt(Integer.MAX_VALUE));
		}
	}

	public static void main(String[] args) {
		// System.out.println(INTS);
		System.out.println(INTS.size());
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		MaxValue maxValue = new MaxValue(INTS);
		long startTime = System.currentTimeMillis();
		System.out.println("max " + forkJoinPool.invoke(maxValue));
		long endTime = System.currentTimeMillis();
		System.out.println(startTime);
		System.out.println(endTime);
		long totalTime = endTime - startTime;
		System.out.println("czas fork join " + totalTime);

		long startTime2 = System.currentTimeMillis();
		System.out.println("max " + Collections.max(INTS));
		long endTime2 = System.currentTimeMillis();
		System.out.println(startTime2);
		System.out.println(endTime2);
		long totalTime2 = endTime2 - startTime2;
		System.out.println("czas zwyklego " + totalTime2);
	}
}

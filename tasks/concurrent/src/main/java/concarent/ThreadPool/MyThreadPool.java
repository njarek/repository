package concarent.ThreadPool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadPool {

	public static List<BigInteger> INTS = new ArrayList<BigInteger>();
	public static int NUMBER_OF_THREADS=5;
	static {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			INTS.add(new BigInteger(random.nextInt(20) + ""));
		}
	}
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		System.out.println(INTS);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		List<Future<Integer>> primes = new ArrayList<Future<Integer>>();
		int sizeForWorker=INTS.size()/NUMBER_OF_THREADS;
		
		for (int i=0;i<NUMBER_OF_THREADS;i++){
			Callable<Integer> callable=new PrimeCounter(INTS, i*sizeForWorker, (i*sizeForWorker)+sizeForWorker);
			Future<Integer> future = executor.submit(callable);
			primes.add(future);
		}
		int sum=0;
		for (Future<Integer> future:primes){
			sum+=future.get();
		}
		System.out.println(sum);
	
	}

}

class PrimeCounter implements Callable<Integer> {

	private List<BigInteger> ints;
	private int from;
	private int to;

	public PrimeCounter(List<BigInteger> ints, int from, int to) {
		this.ints = ints;
		this.from = from;
		this.to = to;
	}

	public Integer call() throws Exception {
		int counter = 0;
		for (int i = from; i < to; i++) {
			if (new BigInteger(ints.get(i).toString()).isProbablePrime(1)) {
				counter++;
			}
		}
		return counter;
	}

}
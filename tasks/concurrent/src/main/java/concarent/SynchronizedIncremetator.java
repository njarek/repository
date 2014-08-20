package concarent;

public class SynchronizedIncremetator {

	private int increment;

	public static void main(String[] args) {
		SynchronizedIncremetator byLocks = new SynchronizedIncremetator();
		byLocks.go();
	}

	public void go() {
		Thread incrementThread = new Thread(new Runnable() {
			public void run() {
				increment();
			}
		});

		Thread decrementThread = new Thread(new Runnable() {
			public void run() {
				decrement();
			}
		});
		incrementThread.start();
		decrementThread.start();
	}

	public synchronized void increment() {
		for (int i = 0; i < 10000; i++) {
			increment++;
			System.out.println("plus " + increment);
		}
	}

	public synchronized void decrement() {
		for (int i = 0; i < 10000; i++) {
			increment--;
			System.out.println("minyus " + increment);
		}
	}

}

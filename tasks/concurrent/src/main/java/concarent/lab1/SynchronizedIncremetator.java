package concarent.lab1;

public class SynchronizedIncremetator {

	private int increment;

	public static void main(String[] args) {
		SynchronizedIncremetator byLocks = new SynchronizedIncremetator();
		byLocks.go();
	}

	public void go() {
		Thread incrementThread = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
					System.out.println("plus " + increment);
				}
			}
		});

		Thread decrementThread = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					decrement();
					System.out.println("minus " + increment);
				}
			}
		});
		incrementThread.start();
		decrementThread.start();
	}

	public synchronized void increment() {
		increment++;

	}

	public synchronized void decrement() {
		increment--;
	}

}

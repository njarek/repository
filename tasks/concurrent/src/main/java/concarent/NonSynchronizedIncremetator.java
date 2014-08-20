package concarent;

public class NonSynchronizedIncremetator {

	private int increment;

	public static void main(String[] args) {
		NonSynchronizedIncremetator byLocks = new NonSynchronizedIncremetator();
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

	public void increment() {
		for (int i = 0; i < 10000; i++) {
			increment++;
			System.out.println("plus " + increment);
		}
	}

	public void decrement() {
		for (int i = 0; i < 10000; i++) {
			increment--;
			System.out.println("minyus " + increment);
		}
	}

}

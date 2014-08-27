package concarent.lab1;


public class SynchronizedIncremetatorByLocks {

	private int increment;
	private JareksSemafor lock = new JareksSemafor(4);

	public static void main(String[] args) {
		SynchronizedIncremetatorByLocks byLocks = new SynchronizedIncremetatorByLocks();
		byLocks.go();
	}

	public void go() {
		
		
		for(int i=0; i< 20; i++) {
			final int j = i;

		Thread incrementThread1 = new Thread(new Runnable() {
			public void run() {
				try {
					increment("thread" + j);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		incrementThread1.start();
		}

	}

	public void increment(String threadName) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 500));
		System.out.println("thread " + threadName
				+ " waiting to enter synchronized scope");
		lock.lock();
		System.out.println("thread " + threadName + " in synchronized scope");
		System.out.println("Threads in scope " + lock.getCurrentThread());
		Thread.sleep(1000);
		for (int i = 0; i < 10000; i++) {
			increment++;
		}
		lock.unlock();
		System.out.println("thread " + threadName + " left synchronized scope");

	}

}

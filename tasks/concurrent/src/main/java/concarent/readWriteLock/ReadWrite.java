package concarent.readWriteLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {

	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	Lock wLock = rwLock.writeLock();
	Lock rLock = rwLock.readLock();
	private volatile int value = 0;

	public static void main(String[] args) {
		final ReadWrite rw = new ReadWrite();

		for (int i = 0; i < 3; i++) {
			final int threadNr = i;

			Thread reader1Thread = new Thread(new Runnable() {
				public void run() {
					while (true) {
						System.out.println(threadNr + " is readinig value " + rw.getValue());
					}

				}
			});
			reader1Thread.start();
		}

		Thread writeThread = new Thread(new Runnable() {

			public void run() {
				while (true) {
					int o=new Random().nextInt(20);
					System.out.println("new value is "+o);
					rw.setValue(o);
				}

			}
		});
		writeThread.start();
	}

	public int getValue() {
		rLock.lock();
		try {
			return value;
		} finally {
			rLock.unlock();
		}
	}

	public void setValue(int value) {
		wLock.lock();
		try {
			Thread.sleep(2000);
			this.value = value;
		} catch (InterruptedException e) {
		} finally {
			wLock.unlock();
		}
	}
}

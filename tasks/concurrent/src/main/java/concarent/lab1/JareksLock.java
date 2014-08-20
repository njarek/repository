package concarent.lab1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class JareksLock implements Lock{

	boolean isLocked=false;
	
	public  void lock() {
		
		synchronized (this) {
			try {
				while(isLocked){
					System.out.println("elo");
					this.wait();
				}
				isLocked=true;
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public synchronized void unlock() {
		isLocked=false;
		this.notify();
		
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
